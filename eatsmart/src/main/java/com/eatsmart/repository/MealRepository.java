package com.eatsmart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eatsmart.model.Meal;
import java.util.List;
import java.time.LocalDateTime;

public interface MealRepository extends JpaRepository<Meal, Long> {

    List<Meal> findByDateTimeBetween(LocalDateTime start, LocalDateTime end);
}
