package com.petproject.voting.util;

import com.petproject.voting.model.Dish;
import com.petproject.voting.to.DishTo;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class DishesUtil {
    private DishesUtil() {
    }

    public static List<DishTo> getTos(Collection<Dish> dishes) {
        return dishes.stream()
                .map(DishesUtil::createTo)
                .collect(Collectors.toList());
    }

    public static DishTo createTo(Dish dish) {
        return new DishTo(dish.getId(), dish.getDescription(), dish.getPrice(),
                dish.getLocalDate(), dish.getRestaurant().getId(), dish.getRestaurant().getName());
    }

    public static Dish createFromTo(DishTo dishTo) {
        return new Dish(dishTo.getId(), dishTo.getDescription(), dishTo.getPrice(),
                dishTo.getLocalDate());
    }
}
