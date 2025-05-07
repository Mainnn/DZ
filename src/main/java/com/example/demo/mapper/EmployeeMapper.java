package com.example.demo.mapper;

import com.example.demo.DTO.EmployeeDto;
import com.example.demo.Entity.Employee;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    EmployeeDto toDto(Employee entity);
    Employee toEntity(EmployeeDto dto);

    List<EmployeeDto> toDto(List<Employee> entities);
    List<Employee> toEntities(List<EmployeeDto> dtos);
}
