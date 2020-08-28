package com.petproject.voting.util;

import com.petproject.voting.model.Meal;
import com.petproject.voting.to.MealTo;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class MealsUtil {
    private MealsUtil() {
    }

    public static List<MealTo> getTos(Collection<Meal> meals) {
        return meals.stream()
                .map(MealsUtil::createTo)
                .collect(Collectors.toList());
    }

    public static MealTo createTo(Meal meal) {
        return new MealTo(meal.getId(), meal.getDescription(), meal.getPrice(),
                meal.getLocalDate(), meal.getRestaurant().getId(), meal.getRestaurant().getName());
    }

    public static Meal createFromTo(MealTo mealTo) {
        return new Meal(mealTo.getId(), mealTo.getDescription(), mealTo.getPrice(),
                mealTo.getLocalDate());
    }
}
