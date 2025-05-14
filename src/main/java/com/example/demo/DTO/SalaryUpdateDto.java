package com.example.demo.DTO;

import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class SalaryUpdateDto {
    @NotNull(message = "Salary must not be null")
    @DecimalMin(value = "0.0", inclusive = true, message = "Salary must be ≥ 0")
    private BigDecimal salary;
}
