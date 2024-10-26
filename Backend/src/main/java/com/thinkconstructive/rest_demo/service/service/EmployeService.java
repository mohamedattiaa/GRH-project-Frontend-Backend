package com.thinkconstructive.rest_demo.service.service;

import com.thinkconstructive.rest_demo.model.Employee;

import java.util.List;

public interface EmployeService {
    List<Employee> getAllEmployee();

    String createEmployee(Employee employee);

    String updateEmployee(Employee employee);

    void deleteEmployee(Long id);

    Employee getEmployee(Long id);

    List<Employee> getAllEmployees();


    Employee getEmployeeByEmail(String email);

    boolean updateEmployeeByEmail(String email, Employee updatedEmployee);



    Employee updateEmployeeBycin(String cin, Employee employee);

    Employee findBycin(String cin);
}
