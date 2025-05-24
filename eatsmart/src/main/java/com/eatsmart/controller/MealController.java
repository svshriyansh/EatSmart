package com.eatsmart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eatsmart.model.Meal;
import com.eatsmart.service.MealService;

@RestController
@RequestMapping("/meals")
@CrossOrigin(origins = "*")
public class MealController {
    @Autowired
    private MealService mealService;

    @PostMapping
    public Meal addMeal(@RequestBody Meal meal) {
        return mealService.saveMeal(meal);
    }

    @GetMapping
    public List<Meal> getAllMeals() {
        return mealService.getAllMeals();
    }

    @GetMapping("/{id}")
    public Meal getMealById(@PathVariable Long id) {
        return mealService.getMEalById(id);
    }

    @GetMapping("/today")
    public List<Meal> getTodaysMeals() {
        return mealService.getTodayMeals();
    }

    @DeleteMapping("/{id}")
    public Meal deleteMealById(@PathVariable Long id) {
        return mealService.getMEalById(id);
    }

}
