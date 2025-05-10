package com.example.demo.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {

    @NotBlank(message = "Name must not be empty")
    private String name;

    private BigDecimal salary;

}
