package com.example.demo.service.imp.serviceInterface;

import com.example.demo.DTO.EmployeeDto;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public interface EmployeeService {

    UUID create(EmployeeDto userDto);
    EmployeeDto updateSalary(UUID id, BigDecimal salary);
    List<EmployeeDto> getAll();
    void deleteById(UUID id);
}
