package com.petproject.voting.repository;

import com.petproject.voting.model.Meal;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Repository
public class DataJpaMealRepository implements MealRepository {
    private static final Sort SORT_DATE_REST = Sort.by(Sort.Direction.DESC, "localDate", "restaurant");

    private final CrudMealRepository crudMealRepository;
    private final CrudRestaurantRepository crudRestaurantRepository;

    public DataJpaMealRepository(CrudMealRepository crudMealRepository, CrudRestaurantRepository crudRestaurantRepository) {
        this.crudMealRepository = crudMealRepository;
        this.crudRestaurantRepository = crudRestaurantRepository;
    }

    @Override
    @Transactional
    public Meal save(Meal meal, int restaurantId) {
        if (!meal.isNew() && get(meal.id()) == null) {
            return null;
        }
        meal.setRestaurant(crudRestaurantRepository.getOne(restaurantId));
        return crudMealRepository.save(meal);
    }

    @Override
    public boolean delete(int id) {
        return crudMealRepository.delete(id) != 0;
    }

    @Override
    public Meal get(int id) {
        return crudMealRepository.get(id);
    }

    @Override
    public List<Meal> getAll() {
        return crudMealRepository.getAll();
    }

    @Override
    public List<Meal> getAllByRestaurantId(int restaurantId) {
        return crudMealRepository.getAllByRestaurantId(restaurantId);
    }

    @Override
    public List<Meal> getAllByDate(LocalDate localDate) {
        return crudMealRepository.getAllByLocalDate(localDate);
    }

    @Override
    public List<Meal> getAllByRestaurantIdAndDate(int restaurantId, LocalDate localDate) {
        return crudMealRepository.getAllByRestaurantIdAndLocalDate(restaurantId, localDate);
    }



}
