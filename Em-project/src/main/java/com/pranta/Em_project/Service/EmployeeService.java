package com.pranta.Em_project.Service;

import java.util.List;

import com.pranta.Em_project.Employee.Employee;

public interface EmployeeService {
    String createEmployee(Employee employee);
    List<Employee> readEmployees();
    boolean deleteEmployee(Long id);
    String updateEmployee(Long id,Employee employee);
    Employee readEmployee(Long id);
}

