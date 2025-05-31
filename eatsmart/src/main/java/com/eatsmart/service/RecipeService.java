package com.eatsmart.service;

import com.eatsmart.model.Recipe;
import com.eatsmart.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    public Recipe addRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    public Recipe getRecipeById(Long id) {
        return recipeRepository.findById(id).orElse(null);
    }

    public void deleteRecipe(Long id) {
        recipeRepository.deleteById(id);
    }

    public Recipe updateRecipe(Long id, Recipe updatedRecipe) {
        Recipe existing = recipeRepository.findById(id).orElse(null);
        if (existing != null) {
            updatedRecipe.setId(id);
            return recipeRepository.save(updatedRecipe);
        }
        return null;
    }
}
