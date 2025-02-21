package com.gestionemployes.api.controller;

import com.gestionemployes.api.model.Employee;
import com.gestionemployes.api.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public Iterable<Employee> getEmployees() {
        return employeeService.getEmployees();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable("id") Long id) {
        return employeeService.getEmployee(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employé non trouvé"));
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity deleteEmploye(@PathVariable("id") Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/employees")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee newEmployee) {
        Employee employee = employeeService.saveEmployee(newEmployee);
        return ResponseEntity.status(HttpStatus.CREATED).body(employee);
    }
}
