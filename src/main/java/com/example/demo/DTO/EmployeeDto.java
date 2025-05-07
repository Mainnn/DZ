package com.example.demo.DTO;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class EmployeeDto {

    private String name;

    private BigDecimal salary;

    public EmployeeDto(String name, BigDecimal salary) {
        this.name = name;
        this.salary = salary;
    }

}
