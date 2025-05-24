package com.eatsmart.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer calories;
    private String mealType;
    private LocalDateTime dateTime;

    public Meal() {
    };

    public Meal(String name, Integer calories, String mealType, LocalDateTime dateTime) {
        this.name = name;
        this.calories = calories;
        this.mealType = mealType;
        this.dateTime = dateTime;
    }
}
