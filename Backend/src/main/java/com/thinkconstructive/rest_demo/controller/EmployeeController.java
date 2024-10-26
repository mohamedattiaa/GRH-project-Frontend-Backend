package com.thinkconstructive.rest_demo.controller;

import com.thinkconstructive.rest_demo.model.Employee;
import com.thinkconstructive.rest_demo.service.service.EmployeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employees")
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeController {

    private final EmployeService employeeService; // Updated variable name

    public EmployeeController(EmployeService employeeService) {
        this.employeeService = employeeService;
    }

    // Read one Employee details from DB
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeDetails(@PathVariable("id") Long id) {
        Employee employee = employeeService.getEmployee(id);
        if (employee != null) {
            return ResponseEntity.ok(employee);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Read all Employees Details from DB
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployeeDetails() {
        List<Employee> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    // Create a new Employee
    @PostMapping
    public ResponseEntity<String> createEmployeeDetails(@RequestBody Employee employee) {
        employeeService.createEmployee(employee);
        return ResponseEntity.ok("Employee Created Successfully");
    }

    // Update an existing Employee
    @PutMapping("/{id}")
    public ResponseEntity<String> updateEmployeeDetails(@PathVariable("id") Long id, @RequestBody Employee employee) {
        employee.setId(id);
        employeeService.updateEmployee(employee);
        return ResponseEntity.ok("Employee Updated Successfully");
    }

    // Delete an Employee
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        if (employeeService.getEmployee(id) == null) {
            return ResponseEntity.notFound().build();
        }
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }


    /*
    @PostMapping("/upload")
    public ResponseEntity<String> uploadFiles(@RequestParam("employee") String employeeJson,
                                              @RequestParam("files") MultipartFile[] files) {
        // Parse the employee JSON and handle file uploads
        // Save employee data and files to the database
        return ResponseEntity.ok("Files uploaded successfully");
    }*/
    @PostMapping("/upload")
    public ResponseEntity<Map<String, String>> uploadFiles(
            @RequestParam("employee") String employeeJson,
            @RequestParam("files") MultipartFile[] files) {
        for (MultipartFile file : files) {
            // Handle the file (save to disk, database, etc.)
            System.out.println("Uploaded file: " + file.getOriginalFilename());
        }

        Map<String, String> response = new HashMap<>();
        response.put("message", "Files uploaded successfully");

        return ResponseEntity.ok(response);

    }
    @GetMapping("/email/{email}")
    public ResponseEntity<Employee> getEmployeeByEmail(@PathVariable String email) {
        Employee employee = employeeService.getEmployeeByEmail(email);
        if (employee != null) {
            return ResponseEntity.ok(employee);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/email/{email}")
    public ResponseEntity<String> updateEmployeeByEmail(
            @PathVariable String email, @RequestBody Employee updatedEmployee) {
        boolean isUpdated = employeeService.updateEmployeeByEmail(email, updatedEmployee);
        if (isUpdated) {
            return ResponseEntity.ok("Employee updated successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found");
        }
    }
    @GetMapping("/cin/{cin}")
    public ResponseEntity<Employee> getEmployeeBycin(@PathVariable("cin") String cin) {
        Employee employee = employeeService.findBycin(cin);
        if (employee != null) {
            return new ResponseEntity<>(employee, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/cin/{cin}")
    public ResponseEntity<Employee> updateEmployeeBycin(@PathVariable("cin") String cin, @RequestBody Employee employee) {
        Employee updatedEmployee = employeeService.updateEmployeeBycin(cin, employee);
        if (updatedEmployee != null) {
            return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}

