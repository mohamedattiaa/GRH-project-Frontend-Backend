package com.thinkconstructive.rest_demo.service.service.impl;

import com.thinkconstructive.rest_demo.model.Employee;
import com.thinkconstructive.rest_demo.repository.EmployeeRepository;
import com.thinkconstructive.rest_demo.service.service.EmployeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class EmployeeServiceimpl implements EmployeService {
    EmployeeRepository employeeRepository;
    public EmployeeServiceimpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @Override
    public String createEmployee(Employee employee) {
        employeeRepository.save(employee);
        return "Successfully Created";
    }

    @Override
    public String updateEmployee(Employee employee) {
        employeeRepository.save(employee);
        return "Successfully Updated";
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }




    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }


    @Override
    public Employee getEmployee(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        return employee.orElse(null);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeByEmail(String email) {
        return employeeRepository.findByEmail(email);
    }
    public boolean updateEmployeeByEmail(String email, Employee updatedEmployee) {
        Employee existingEmployee = employeeRepository.findByEmail(email);
        if (existingEmployee != null) {
            // Update fields from updatedEmployee to existingEmployee
            existingEmployee.setFullname(updatedEmployee.getFullname());
            existingEmployee.setAddress(updatedEmployee.getAddress());
            existingEmployee.setPhoneNumber(updatedEmployee.getPhoneNumber());
            existingEmployee.setPosition(updatedEmployee.getPosition());
            existingEmployee.setDepartment(updatedEmployee.getDepartment());
            existingEmployee.setContractType(updatedEmployee.getContractType());
            existingEmployee.setBaseSalary(updatedEmployee.getBaseSalary());
            // Add more fields as needed

            employeeRepository.save(existingEmployee);  // Save updated employee
            return true;
        }
        return false;
    }

    @Override
    public Employee findBycin(String cin) {
        return employeeRepository.findBycin(cin); // Call to repository method
    }

    @Override
    public Employee updateEmployeeBycin(String cin, Employee employee) {
        // Fetch the existing employee
        Employee existingEmployee = employeeRepository.findBycin(cin);

        if (existingEmployee != null) {
            // Update the existing employee's details with the new data
            existingEmployee.setFullname(employee.getFullname());
            existingEmployee.setEmail(employee.getEmail());
            existingEmployee.setAddress(employee.getAddress());
            existingEmployee.setPhoneNumber(employee.getPhoneNumber());
            existingEmployee.setPosition(employee.getPosition());
            existingEmployee.setDepartment(employee.getDepartment());
            existingEmployee.setContractType(employee.getContractType());
            existingEmployee.setBaseSalary(employee.getBaseSalary());
            // Update other fields as needed

            // Save the updated employee
            return employeeRepository.save(existingEmployee);
        } else {
            return null; // Employee not found
        }
    }

}
