package com.eatsmart.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "meals")
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

    @Column(length = 1000)
    private String description;

    private int protein;
    private int carbs;
    private int fat;
}
