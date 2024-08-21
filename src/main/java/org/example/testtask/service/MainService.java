package org.example.testtask.service;

import org.springframework.data.jpa.repository.Query;

public interface MainService {
    String headOfDepartment(String departmentName);
    String departmentStatistics(String departmentName);
    String averageSalary(String departmentName);
    String employeeCount(String departmentName);
    String globalSearch(String regex);
}
