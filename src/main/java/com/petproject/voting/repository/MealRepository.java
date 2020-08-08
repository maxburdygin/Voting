package com.petproject.voting.repository;


import com.petproject.voting.model.Meal;

import java.util.Collection;

public interface MealRepository {
    // null if not found, when updated
    Meal save(Meal meal);

    // false if not found
    boolean delete(int id);

    // 0 if not found
    int vote(int mealId);

    // null if not found
    Meal get(int id);

    Collection<Meal> getAll();
}
