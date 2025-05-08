package com.example.demo.service.imp.serviceInterface;

import com.example.demo.DTO.EmployeeDto;
import com.example.demo.Entity.Employee;
import com.example.demo.mapper.EmployeeMapper;
import com.example.demo.repo.EmployeeRepo;
import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeServiceImp implements EmployeeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImp.class);

    private final EmployeeRepo employeeRepo;
    private final EmployeeMapper employeeMapper;

    public EmployeeServiceImp(EmployeeRepo employeeRepo, EmployeeMapper employeeMapper) {
        this.employeeRepo = employeeRepo;
        this.employeeMapper = employeeMapper;
    }

    @Transactional
    public UUID create(EmployeeDto employeeDto) {
        if (employeeDto.getSalary() == null || employeeDto.getSalary().compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Salary must be ≥ 0");
        }
        if(employeeDto.getName() != null && !employeeDto.getName().isEmpty()){
            throw new IllegalArgumentException("Name must not be empty");
        }

        Employee user = employeeMapper.toEntity(employeeDto);
        LOGGER.info("Creating user: " + user);
        return employeeRepo.save(user).getId();
    }

    @Transactional
    public EmployeeDto updateSalary(UUID id, BigDecimal salary) {
        if (salary == null || salary.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Salary must be ≥ 0");
        }

        Employee entity = employeeRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Employee not found: " + id));

        entity.setSalary(salary);
        EmployeeDto dto = employeeMapper.toDto(employeeRepo.save(entity));
        LOGGER.info("Updating salary from employee UUID= {} -> {}", id, dto);
        return dto;
    }

    private EmployeeDto getById(UUID id) {
        Employee entity = employeeRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Employee not found: " + id));
        LOGGER.info("Get employee by id: {}", entity);
        return employeeMapper.toDto(entity);
    }

    public List<Employee> getAll() {
        List<Employee> employees = employeeRepo.findAll();
        LOGGER.info("Get all employees, size = {}", employees.size());
        return employees;
    }

    @Transactional()
    public void deleteById(UUID id) {
        if (!employeeRepo.existsById(id)) {
            throw new EntityNotFoundException("Cannot delete, employee not found: " + id);
        }
        employeeRepo.deleteById(id);
        LOGGER.info("Deleting employee by id: {}", id);
    }
}
