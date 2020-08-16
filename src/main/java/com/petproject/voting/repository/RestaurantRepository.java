package com.petproject.voting.repository;

import com.petproject.voting.model.Meal;
import com.petproject.voting.model.Restaurant;

import java.util.List;

public interface RestaurantRepository {
    // null if updated meal do not belong to userId
    Restaurant save(Restaurant restaurant);

    // false if meal do not belong to userId
    boolean delete(int restaurantId);

    // null if meal do not belong to userId
    Restaurant get(int restaurantId);

    // ORDERED name asc
    List<Restaurant> getAll();

    Restaurant getByName(String name);
}
