package com.eatsmart.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(length = 1000)
    private String instructions;

    @ElementCollection
    private List<String> nutritionTags;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Ingredient> ingredients;
}
