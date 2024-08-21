package org.example.testtask.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.testtask.dto.DepartmentStatisticsDTO;
import org.example.testtask.entity.Department;
import org.example.testtask.entity.Lector;
import org.example.testtask.repository.DepartmentRepository;
import org.example.testtask.repository.LectorRepository;
import org.example.testtask.service.MainService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MainServiceImpl implements MainService {
    private final LectorRepository lectorRepository;
    private final DepartmentRepository departmentRepository;


    @Override
    public String headOfDepartment(String departmentName) {
        return departmentRepository.findByName(departmentName)
                .map(department -> "Head of " + departmentName + " is " + department.getHead().getFirstName())
                .orElse("Department not found");
    }

    @Override
    public String departmentStatistics(String departmentName) {
        DepartmentStatisticsDTO stats = departmentRepository.findByNameWithLectors(departmentName);
        if (stats == null) {
            return "Department not found";
        }

        return "assistants - " + stats.getAssistants() + ".\n" +
                "associate professors - " + stats.getAssociateProfessors() + ".\n" +
                "professors - " + stats.getProfessors() + ".";
//        return departmentRepository.findByNameWithLectors(departmentName)
//                .map(department -> {
//                    long assistants = department.getLectors().stream().filter(lector -> lector.getDegree().equals("assistant")).count();
//                    long associateProfessors = department.getLectors().stream().filter(lector -> lector.getDegree().equals("associate professor")).count();
//                    long professors = department.getLectors().stream().filter(lector -> lector.getDegree().equals("professor")).count();
//                    return "assistants - " + assistants + ".\n associate professors - " + associateProfessors + ".\n professors - " + professors + ".";
//                })
//                .orElse("Department not found");
    }

    @Override
    public String averageSalary(String departmentName) {
        return departmentRepository.findByName(departmentName)
                .map(department -> {
                    double averageSalary = department.getLectors().stream().mapToDouble(Lector::getSalary).average().orElse(0);
                    return "The average salary of " + departmentName + " is " + averageSalary;
                })
                .orElse("Department not found");
    }

    @Override
    public String employeeCount(String departmentName) {
        return departmentRepository.findByName(departmentName)
                .map(department -> "Employee count: " + department.getLectors().size())
                .orElse("Department not found");
    }

    @Override
    public String globalSearch(String regex) {
//        return lectorRepository.globalSearch(regex);
        List<Lector> lectors = lectorRepository.globalSearch(regex);
        return lectors.stream()
                .map(lector -> lector.getFirstName() + " " + lector.getLastName())
                .collect(Collectors.joining(", "));
    }
}
