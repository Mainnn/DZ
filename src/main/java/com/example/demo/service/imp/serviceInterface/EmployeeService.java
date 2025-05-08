package com.example.demo.service.imp.serviceInterface;

import com.example.demo.DTO.EmployeeDto;
import com.example.demo.Entity.Employee;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public interface EmployeeService {

    UUID create(EmployeeDto userDto);
    EmployeeDto updateSalary(UUID id, BigDecimal salary);
    List<Employee> getAll();
    void deleteById(UUID id);
}
