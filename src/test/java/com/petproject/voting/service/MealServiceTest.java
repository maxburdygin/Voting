package com.petproject.voting.service;

import com.petproject.voting.model.Meal;
import com.petproject.voting.util.NotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintViolationException;
import java.time.LocalDate;

import static com.petproject.voting.testdata.MealTestData.*;
import static com.petproject.voting.testdata.RestaurantTestData.MCD;
import static com.petproject.voting.testdata.RestaurantTestData.MCD_ID;
import static com.petproject.voting.testdata.UserTestData.ADMIN_ID;
import static com.petproject.voting.testdata.UserTestData.USER_ID;
import static org.junit.jupiter.api.Assertions.assertThrows;


class MealServiceTest extends AbstractServiceTest {

    @Autowired
    protected MealService service;

    @Test
    void delete() throws Exception {
        service.delete(MEAL1_ID);
        assertThrows(NotFoundException.class, () -> service.get(MEAL1_ID));
    }

    @Test
    void deleteNotFound() throws Exception {
        assertThrows(NotFoundException.class, () -> service.delete(NOT_FOUND));
    }

    @Test
    void create() throws Exception {
        Meal created = service.create(getNew(), MCD_ID);
        int newId = created.id();
        Meal newMeal = getNew();
        newMeal.setId(newId);
        MEAL_MATCHER.assertMatch(created, newMeal);
        MEAL_MATCHER.assertMatch(service.get(newId), newMeal);
    }

    @Test
    void get() throws Exception {
        Meal actual = service.get(MEAL1_ID);
        MEAL_MATCHER.assertMatch(actual, MEAL1);
    }

    @Test
    void getNotFound() throws Exception {
        assertThrows(NotFoundException.class, () -> service.get(NOT_FOUND));
    }

    @Test
    void update() throws Exception {
        Meal updated = getUpdated();
        service.update(updated, MCD_ID);
        MEAL_MATCHER.assertMatch(service.get(MEAL1_ID), getUpdated());
    }

    @Test
    void getAll() throws Exception {
        MEAL_MATCHER.assertMatch(service.getAll(), MEALS);
    }

    @Test
    void getAllByDate() throws Exception {
        MEAL_MATCHER.assertMatch(service.getAllByDate(LocalDate.of(2020, 8, 23)),
                MEAL2, MEAL5, MEAL8);
    }

    @Test
    void getAllByRestaurantId() throws Exception {
        MEAL_MATCHER.assertMatch(service.getAllByRestaurantId(100003),
                MEAL5, MEAL4, MEAL6);
    }

    @Test
    void getAllByRestaurantIdAndDate() throws Exception {
        MEAL_MATCHER.assertMatch(service.getAllByRestaurantIdAndDate(100003, LocalDate.of(2020, 8, 23)),
                MEAL5);
    }

    @Test
    void createWithException() throws Exception {
        validateRootCause(() -> service.create(new Meal(null, "", 100.0, LocalDate.of(2020, 8, 30)), MCD_ID), ConstraintViolationException.class);
        validateRootCause(() -> service.create(new Meal(null, "BestMeal", 0.2, LocalDate.of(2020, 8, 30)), MCD_ID), ConstraintViolationException.class);
        validateRootCause(() -> service.create(new Meal(null, "BestMeal", 20.2, null), MCD_ID), ConstraintViolationException.class);
    }
}