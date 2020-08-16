package com.petproject.voting.web;

import com.petproject.voting.model.Meal;
import com.petproject.voting.service.MealService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import java.util.List;

import static com.petproject.voting.util.ValidationUtil.assureIdConsistent;
import static com.petproject.voting.util.ValidationUtil.checkNew;

@Controller
public class MealRestController {
    private static final Logger log = LoggerFactory.getLogger(MealRestController.class);

    private final MealService service;

    public MealRestController(MealService service) {
        this.service = service;
    }

    public Meal get(int id) {
        log.info("get meal {}", id);
        return service.get(id);
    }

    public void delete(int id) {
        log.info("delete meal {}", id);
        service.delete(id);
    }

    public List<Meal> getAll() {
        log.info("getAll");
        return service.getAll();
    }

    public Meal create(Meal meal, int restaurantId) {
        checkNew(meal);
        log.info("create {} for restaurant {}", meal, restaurantId);
        return service.create(meal, restaurantId);
    }

    public void update(Meal meal, int restaurantId) {
        assureIdConsistent(meal, restaurantId);
        log.info("update {} for restaurant {}", meal, restaurantId);
        service.update(meal, restaurantId);
    }

}
