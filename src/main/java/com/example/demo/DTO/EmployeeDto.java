package com.example.demo.DTO;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {

    private String name;

    private BigDecimal salary;

}
