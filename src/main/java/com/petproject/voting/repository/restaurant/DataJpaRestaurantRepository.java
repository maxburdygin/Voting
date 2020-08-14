package com.petproject.voting.repository.restaurant;

import com.petproject.voting.model.Meal;
import com.petproject.voting.model.Restaurant;
import com.petproject.voting.repository.RestaurantRepository;
import com.petproject.voting.repository.restaurant.CrudRestaurantRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Repository
public class DataJpaRestaurantRepository implements RestaurantRepository {

    private final CrudRestaurantRepository crudRestaurantRepository;

    public DataJpaRestaurantRepository(CrudRestaurantRepository crudRestaurantRepository) {
        this.crudRestaurantRepository = crudRestaurantRepository;
    }

    @Override
    @Transactional
    public Restaurant save(Restaurant restaurant) {
        return crudRestaurantRepository.save(restaurant);
    }

    @Override
    public boolean delete(int restaurantId) {
        return crudRestaurantRepository.delete(restaurantId) != 0;
    }

    @Override
    public Restaurant get(int restaurantId) {
        return crudRestaurantRepository.findById(restaurantId).orElse(null);
    }

    @Override
    public List<Restaurant> getAll() {
        return crudRestaurantRepository.getAll();
    }

}
