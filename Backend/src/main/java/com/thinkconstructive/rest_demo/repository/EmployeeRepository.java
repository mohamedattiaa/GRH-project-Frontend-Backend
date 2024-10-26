package com.thinkconstructive.rest_demo.repository;

import com.thinkconstructive.rest_demo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> findById(Long id);
    Employee findByEmail(String email);
    Employee findBycin(String cin);


}
