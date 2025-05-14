package com.example.demo.DTO;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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

    @NotNull(message = "Salary must not be null")
    @DecimalMin(value = "0.0", inclusive = true,
            message = "Salary must be ≥ 0")
    private BigDecimal salary;

}
