package com.eatsmart.repository;

import com.eatsmart.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    // you can add custom queries like:
    // List<Recipe> findByNutritionTagsContaining(String tag);
}
