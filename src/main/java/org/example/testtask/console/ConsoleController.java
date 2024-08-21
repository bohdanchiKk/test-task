package org.example.testtask.console;

import lombok.RequiredArgsConstructor;
import org.example.testtask.service.MainService;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
@RequiredArgsConstructor
public class ConsoleController {
    private final MainService mainService;

//    @ShellMethod("Who is head of department {department_name}")
    @ShellMethod(value = "Who is head of department", key = {"Who is head of department"})
    public String headOfDepartment(String departmentName) {
        return mainService.headOfDepartment(departmentName);
    }

//    @ShellMethod("Show {department_name} statistics")
    @ShellMethod(value = "Show department statistics", key = {"Show department statistics"})
    public String showDepartmentStatistics(String departmentName) {
        return mainService.departmentStatistics(departmentName);
    }


    @ShellMethod(value = "Show the average salary for the department", key = {"Show the average salary for the department"})
    public String showAverageSalary(String departmentName) {
        return mainService.averageSalary(departmentName);
    }


    @ShellMethod(value = "Show count of employee for", key = {"Show count of employee for"})
    public String showEmployeeCount(String departmentName) {
        return mainService.employeeCount(departmentName);
    }


    @ShellMethod(value = "Global search by", key = {"Global search by"})
    public String globalSearch(String template) {
        return mainService.globalSearch(template);
    }
}
