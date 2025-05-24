package com.eatsmart.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eatsmart.model.Meal;
import com.eatsmart.repository.MealRepository;

@Service
public class MealService {
    @Autowired
    private MealRepository mealRepository;

    public Meal saveMeal(Meal meal) {
        return mealRepository.save(meal);
    }

    public List<Meal> getAllMeals() {
        return mealRepository.findAll();
    }

    public Meal getMealById(Long id) {
        return mealRepository.findById(id).orElse(null);
    }

    public void deleteMeal(Long id) {
        mealRepository.deleteById(id);
    }

    public List<Meal> getTodayMeals() {
        // LocalDate today = LocalDate.now();
        LocalDateTime startOfDay = LocalDate.now().atStartOfDay();
        LocalDateTime endOfDay = LocalDate.now().atTime(LocalTime.MAX);
        return mealRepository.findByDateTimeBetween(startOfDay, endOfDay);
    }

    public int getCaloriesByDate(LocalDate date) {
        LocalDateTime start = date.atStartOfDay();
        LocalDateTime end = date.plusDays(1).atStartOfDay();
        List<Meal> meals = mealRepository.findByDateTimeBetween(start, end);
        return meals.stream().mapToInt(Meal::getCalories).sum();
    }

    public Meal updateMeal(Long id, Meal updatedMeal) {
        Meal existing = mealRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Meal not found"));
        existing.setName(updatedMeal.getName());
        existing.setCalories(updatedMeal.getCalories());
        existing.setDateTime(updatedMeal.getDateTime());
        existing.setMealType(updatedMeal.getMealType());
        existing.setDescription(updatedMeal.getDescription());
        existing.setProtein(updatedMeal.getProtein());
        existing.setCarbs(updatedMeal.getCarbs());
        existing.setFat(updatedMeal.getFat());
        return mealRepository.save(existing);
    }

}
