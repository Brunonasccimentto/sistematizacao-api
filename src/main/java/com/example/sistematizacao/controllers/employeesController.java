package com.example.sistematizacao.controllers;

import com.example.sistematizacao.domain.Employee;
import com.example.sistematizacao.domain.EmployeeRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class employeesController {

    @Autowired
    private EmployeeRepository repository;

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Employee>> getAllEmployees() {
        var allEmployees = repository.findAll();
        return ResponseEntity.ok(allEmployees);
    }

    @PostMapping
    @ResponseBody
    public Employee createEmployee(@RequestBody Employee employee) {
        return repository.save(employee);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable String id, @RequestBody Employee updatedEmployee) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        updatedEmployee.setId(id);
        Employee savedEmployee = repository.save(updatedEmployee);
        return ResponseEntity.ok(savedEmployee);
    }

    @DeleteMapping("/delete/{employeeId}")
    @ResponseBody
    public ResponseEntity deleteEmployee(@PathVariable("employeeId") String id){
        Optional<Employee> optionalEmployee = repository.findById(id);

        if (optionalEmployee.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Employee employee = optionalEmployee.get();
        repository.deleteById(employee.getId());
        return ResponseEntity.ok("Employee deleted");
    }

}
