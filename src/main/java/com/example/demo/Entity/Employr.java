package com.example.demo.Entity;

import com.example.demo.DTO.UserDto;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity(name = "employr")
@Table( name = "employr")
public class Employr {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    private BigDecimal salary;

    public Employr() {
    }

    public Employr(UserDto userDto) {
        this.name = userDto.getName();
        this.salary = userDto.getSalary();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
}
