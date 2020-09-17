package com.petproject.voting.service;

import com.petproject.voting.model.Dish;
import com.petproject.voting.util.NotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintViolationException;
import java.time.LocalDate;

import static com.petproject.voting.testdata.DishTestData.*;
import static com.petproject.voting.testdata.RestaurantTestData.MCD;
import static com.petproject.voting.testdata.RestaurantTestData.MCD_ID;
import static com.petproject.voting.testdata.UserTestData.ADMIN_ID;
import static com.petproject.voting.testdata.UserTestData.USER_ID;
import static org.junit.jupiter.api.Assertions.assertThrows;


class DishServiceTest extends AbstractServiceTest {

    @Autowired
    protected DishService service;

    @Test
    void delete() throws Exception {
        service.delete(DISH1_ID);
        assertThrows(NotFoundException.class, () -> service.get(DISH1_ID));
    }

    @Test
    void deleteNotFound() throws Exception {
        assertThrows(NotFoundException.class, () -> service.delete(NOT_FOUND));
    }

    @Test
    void create() throws Exception {
        Dish created = service.create(getNew(), MCD_ID);
        int newId = created.id();
        Dish newDish = getNew();
        newDish.setId(newId);
        DISH_MATCHER.assertMatch(created, newDish);
        DISH_MATCHER.assertMatch(service.get(newId), newDish);
    }

    @Test
    void get() throws Exception {
        Dish actual = service.get(DISH1_ID);
        DISH_MATCHER.assertMatch(actual, DISH1);
    }

    @Test
    void getNotFound() throws Exception {
        assertThrows(NotFoundException.class, () -> service.get(NOT_FOUND));
    }

    @Test
    void update() throws Exception {
        Dish updated = getUpdated();
        service.update(updated, MCD_ID);
        DISH_MATCHER.assertMatch(service.get(DISH1_ID), getUpdated());
    }

    @Test
    void getAll() throws Exception {
        DISH_MATCHER.assertMatch(service.getAll(), DISHES);
    }

    @Test
    void getAllByDate() throws Exception {
        DISH_MATCHER.assertMatch(service.getAllByDate(LocalDate.of(2020, 8, 23)),
                DISH2, DISH5, DISH8);
    }

    @Test
    void getAllByRestaurantId() throws Exception {
        DISH_MATCHER.assertMatch(service.getAllByRestaurantId(100003),
                DISH5, DISH4, DISH6);
    }

    @Test
    void getAllByRestaurantIdAndDate() throws Exception {
        DISH_MATCHER.assertMatch(service.getAllByRestaurantIdAndDate(100003, LocalDate.of(2020, 8, 23)),
                DISH5);
    }

    @Test
    void createWithException() throws Exception {
        validateRootCause(() -> service.create(new Dish(null, "", 10000, LocalDate.of(2020, 8, 30)), MCD_ID), ConstraintViolationException.class);
        validateRootCause(() -> service.create(new Dish(null, "BestDish", 0, LocalDate.of(2020, 8, 30)), MCD_ID), ConstraintViolationException.class);
        validateRootCause(() -> service.create(new Dish(null, "BestDish", 500009, null), MCD_ID), ConstraintViolationException.class);
    }
}