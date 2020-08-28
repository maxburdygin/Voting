package com.petproject.voting.testdata;

import com.petproject.voting.TestMatcher;
import com.petproject.voting.model.Meal;
import com.petproject.voting.to.MealTo;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static com.petproject.voting.model.AbstractBaseEntity.START_SEQ;

public class MealTestData {
    public static TestMatcher<Meal> MEAL_MATCHER = TestMatcher.usingFieldsWithIgnoringComparator(Meal.class, "restaurant");
    public static TestMatcher<MealTo> MEAL_TO_MATCHER = TestMatcher.usingFieldsWithIgnoringComparator(MealTo.class, "");

    public static final int NOT_FOUND = 10;
    public static final int MEAL1_ID = START_SEQ + 5;

    public static final Meal MEAL1 = new Meal(MEAL1_ID, "McD Happy Meal", 150.0, LocalDate.of(2020, Month.AUGUST, 22));
    public static final Meal MEAL2 = new Meal(MEAL1_ID + 1, "McD UnHappy Meal", 250.0, LocalDate.of(2020, Month.AUGUST, 23));
    public static final Meal MEAL3 = new Meal(MEAL1_ID + 2, "McD Tripple HamBurger", 220.0, LocalDate.of(2020, Month.AUGUST, 21));
    public static final Meal MEAL4 = new Meal(MEAL1_ID + 3, "KFC Chicken McNuggets", 180.0, LocalDate.of(2020, Month.AUGUST, 22));
    public static final Meal MEAL5 = new Meal(MEAL1_ID + 4, "KFC Chicken Bresasts", 190.0, LocalDate.of(2020, Month.AUGUST, 23));
    public static final Meal MEAL6 = new Meal(MEAL1_ID + 5, "KFC Chicken Bucket", 390.0, LocalDate.of(2020, Month.AUGUST, 21));
    public static final Meal MEAL7 = new Meal(MEAL1_ID + 6, "California Roll", 260.0, LocalDate.of(2020, Month.AUGUST, 22));
    public static final Meal MEAL8 = new Meal(MEAL1_ID + 7, "Philadelphia Roll", 270.0, LocalDate.of(2020, Month.AUGUST, 23));
    public static final Meal MEAL9 = new Meal(MEAL1_ID + 8, "Salmon Boke", 280.0, LocalDate.of(2020, Month.AUGUST, 21));

    public static final MealTo MEAL1_TO = new MealTo(MEAL1, 100002, "McDonalds");
    public static final MealTo MEAL2_TO = new MealTo(MEAL2, 100002, "McDonalds");
    public static final MealTo MEAL3_TO = new MealTo(MEAL3, 100002, "McDonalds");
    public static final MealTo MEAL4_TO = new MealTo(MEAL4, 100003, "KFC");
    public static final MealTo MEAL5_TO = new MealTo(MEAL5, 100003, "KFC");
    public static final MealTo MEAL6_TO = new MealTo(MEAL6, 100003, "KFC");
    public static final MealTo MEAL7_TO = new MealTo(MEAL7, 100004, "Sushi-Oki");
    public static final MealTo MEAL8_TO = new MealTo(MEAL8, 100004, "Sushi-Oki");
    public static final MealTo MEAL9_TO = new MealTo(MEAL9, 100004, "Sushi-Oki");

    public static  List<Meal> MEALS = List.of(MEAL2, MEAL5, MEAL8, MEAL1, MEAL4, MEAL7, MEAL3, MEAL6, MEAL9);
    public static  List<MealTo> MEALS_TO = List.of(MEAL2_TO, MEAL5_TO, MEAL8_TO, MEAL1_TO, MEAL4_TO, MEAL7_TO, MEAL3_TO, MEAL6_TO, MEAL9_TO);

    public static Meal getNew() {
        return new Meal(null, "Созданное блюдо", 480.0 , LocalDate.of(2020, Month.AUGUST, 21));
    }

    public static MealTo getNewTo() {
        return new MealTo(getNew(), 100002, "McDonalds");
    }

    public static Meal getUpdated() {
        return new Meal(MEAL1_ID,"Обновленный завтрак", 200.0, LocalDate.of(2020, Month.AUGUST, 21));
    }

    public static MealTo getUpdatedTo() {
        return new MealTo(getUpdated(), 100002, "McDonalds");
    }
}
