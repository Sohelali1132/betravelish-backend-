package com.betravelish.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Trek {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Location is required")
    private String location;

    @Min(value = 1, message = "Duration must be at least 1 day")
    private int duration;

    @Min(value = 1, message = "Price must be at least 1")
    private double price;

    @NotBlank(message = "Difficulty level is required")
    private String difficulty;

    @NotBlank(message = "Description is required")
    private String description;
}
