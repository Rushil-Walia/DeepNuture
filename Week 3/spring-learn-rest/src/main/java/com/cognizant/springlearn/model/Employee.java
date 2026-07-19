package com.cognizant.springlearn.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @NotNull
    private Long id;

    @NotBlank
    @Size(min = 1, max = 30, message = "Name length must be between 1 and 30")
    private String name;

    @NotNull
    @Min(value = 0, message = "Salary should be non-negative")
    private Double salary;

    @NotNull
    private Department department;

    private Skill skill;
}
