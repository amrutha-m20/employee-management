package com.example.emp_management.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="departments")
public class Department {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message="Department name is required")
    @Size(min = 2, max = 50, message = "Department name must be 2-50 characters")
    @Column(nullable = false, unique = true)
    private String name;

    @Size(max = 100, message = "Location must be up to 100 characters")
    private String location;






}
