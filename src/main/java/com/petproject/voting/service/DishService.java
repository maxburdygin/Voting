package com.petproject.voting.service;

import com.petproject.voting.model.Dish;
import com.petproject.voting.repository.DishRepository;
import com.petproject.voting.repository.RestaurantRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.util.List;

import static com.petproject.voting.util.ValidationUtil.checkNotFoundWithId;

@Service
public class DishService {

    private final DishRepository repository;
    private final RestaurantRepository restaurantRepository;

    public DishService(DishRepository repository, RestaurantRepository restaurantRepository) {
        this.repository = repository;
        this.restaurantRepository = restaurantRepository;
    }

    public Dish get(int id) {
        return checkNotFoundWithId(repository.get(id), id);
    }

    public void delete(int id) {
        checkNotFoundWithId((repository.delete(id) != 0), id);
    }

    public void update(Dish dish, int restaurantId) {
        Assert.notNull(dish, "Dish must not be null");
        checkNotFoundWithId(save(dish, restaurantId), dish.id());
    }

    public Dish create(Dish dish, int restaurantId) {
        Assert.notNull(dish, "dish must not be null");
        return save(dish, restaurantId);
    }

    @Transactional
    public Dish save(Dish dish, int restaurantId) {
        if (!dish.isNew() && get(dish.id()) == null) {
            return null;
        }
        dish.setRestaurant(restaurantRepository.getOne(restaurantId));
        return repository.save(dish);
    }

    public List<Dish> getAll() {
        return repository.getAll();
    }

    public List<Dish> getAllByRestaurantId(int restaurantId) {
        return repository.getAllByRestaurantId(restaurantId);
    }

    public List<Dish> getAllByDate(LocalDate localDate) {
        return repository.getAllByDate(localDate);
    }

    public List<Dish> getAllByRestaurantIdAndDate(int restaurantId, LocalDate localDate) {
        return repository.getAllByRestaurantIdAndDate(restaurantId, localDate);
    }
}
