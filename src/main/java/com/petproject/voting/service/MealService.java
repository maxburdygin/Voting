package com.petproject.voting.service;

import com.petproject.voting.model.Meal;
import com.petproject.voting.repository.MealRepository;
import com.petproject.voting.to.MealTo;
import com.petproject.voting.util.MealsUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.util.List;

import static com.petproject.voting.util.ValidationUtil.checkNotFoundWithId;

@Service
public class MealService {

    private final MealRepository repository;

    public MealService(MealRepository repository) {
        this.repository = repository;
    }

    public Meal get(int id) {
        return checkNotFoundWithId(repository.get(id), id);
    }

    public void delete(int id) {
        checkNotFoundWithId(repository.delete(id), id);
    }

    public void update(Meal meal, int restaurantId) {
        Assert.notNull(meal, "meal must not be null");
        checkNotFoundWithId(repository.save(meal, restaurantId), meal.id());
    }

    public Meal create(Meal meal, int restaurantId) {
        Assert.notNull(meal, "meal must not be null");
        return repository.save(meal, restaurantId);
    }

    public List<Meal> getAll() {
        return repository.getAll();
    }

    public List<Meal> getAllByRestaurantId(int restaurantId) {
        return repository.getAllByRestaurantId(restaurantId);
    }

    public List<Meal> getAllByDate(LocalDate localDate) {
        return repository.getAllByDate(localDate);
    }

    public List<Meal> getAllByRestaurantIdAndDate(int restaurantId, LocalDate localDate) {
        return repository.getAllByRestaurantIdAndDate(restaurantId, localDate);
    }
}
