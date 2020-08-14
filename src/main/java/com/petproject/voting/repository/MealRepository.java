package com.petproject.voting.repository;


import com.petproject.voting.model.Meal;

import java.time.LocalDate;
import java.util.List;

public interface MealRepository {
    // null if updated meal do not belong to restaurantId
    Meal save(Meal meal, int restaurantId);

    // false if meal do not belong to restaurantId
    boolean delete(int id);

    // null if meal do not belong to restaurantId
    Meal get(int id);

    // ORDERED dateTime and restaurant desc
    List<Meal> getAll();

    // ORDERED dateTime desc
    List<Meal> getAllByRestaurantId(int restaurantId);

    // ORDERED restaurant desc
    List<Meal> getAllForToday();

    List<Meal> getAllByRestaurantIdForToday(int restaurantId);
}
