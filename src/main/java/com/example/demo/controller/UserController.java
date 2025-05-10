package com.example.demo.controller;

import com.example.demo.DTO.EmployeeDto;
import com.example.demo.Entity.Employee;
import com.example.demo.service.imp.serviceInterface.EmployeeService;
import com.example.demo.service.imp.serviceInterface.EmployeeServiceImp;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@RestController("")
public class UserController {
    private final Logger logger= LoggerFactory.getLogger(UserController.class);

    private final EmployeeService employeeService;

    public UserController(EmployeeServiceImp employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/employees")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public UUID createEmployee(@Valid @RequestBody EmployeeDto employeeDto) {
        logger.info("Creating employee with name: " + employeeDto.getName());
        return employeeService.create(employeeDto);
    }

    @PatchMapping("/employees/{id}/salary")
    @ResponseStatus(HttpStatus.OK)
    public EmployeeDto updateUser(@PathVariable UUID id, @RequestBody BigDecimal salary) {
        return employeeService.updateSalary(id, salary);
    }

    @GetMapping("/employees")
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> getAllUsers() {
        return employeeService.getAll();
    }

    @DeleteMapping("/employees/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteUser(@PathVariable UUID id) {
        employeeService.deleteById(id);
    }

}
