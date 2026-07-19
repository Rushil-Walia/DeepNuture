package com.cognizant.springlearn.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department {
    @NotNull
    private Long id;

    @NotBlank
    @Size(min = 1, max = 30)
    private String name;
}
