package com.example.demo.Entity;

import com.example.demo.DTO.EmployeeDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.UUID;

@Entity(name = "employee")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    private BigDecimal salary;

    public Employee(EmployeeDto userDto) {
        this.name = userDto.getName();
        this.salary = userDto.getSalary();
    }

}
