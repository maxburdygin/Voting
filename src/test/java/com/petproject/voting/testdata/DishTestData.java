package com.petproject.voting.testdata;

import com.petproject.voting.TestMatcher;
import com.petproject.voting.model.Dish;
import com.petproject.voting.to.DishTo;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static com.petproject.voting.model.AbstractBaseEntity.START_SEQ;

public class DishTestData {
    public static TestMatcher<Dish> DISH_MATCHER = TestMatcher.usingFieldsWithIgnoringComparator(Dish.class, "restaurant");
    public static TestMatcher<DishTo> DISH_TO_MATCHER = TestMatcher.usingFieldsWithIgnoringComparator(DishTo.class, "");

    public static final int NOT_FOUND = 10;
    public static final int DISH1_ID = START_SEQ + 5;

    public static final Dish DISH1 = new Dish(DISH1_ID, "McD Happy Dish", 150.0, LocalDate.of(2020, Month.AUGUST, 22));
    public static final Dish DISH2 = new Dish(DISH1_ID + 1, "McD UnHappy Dish", 250.0, LocalDate.of(2020, Month.AUGUST, 23));
    public static final Dish DISH3 = new Dish(DISH1_ID + 2, "McD Tripple HamBurger", 220.0, LocalDate.of(2020, Month.AUGUST, 21));
    public static final Dish DISH4 = new Dish(DISH1_ID + 3, "KFC Chicken McNuggets", 180.0, LocalDate.of(2020, Month.AUGUST, 22));
    public static final Dish DISH5 = new Dish(DISH1_ID + 4, "KFC Chicken Bresasts", 190.0, LocalDate.of(2020, Month.AUGUST, 23));
    public static final Dish DISH6 = new Dish(DISH1_ID + 5, "KFC Chicken Bucket", 390.0, LocalDate.of(2020, Month.AUGUST, 21));
    public static final Dish DISH7 = new Dish(DISH1_ID + 6, "California Roll", 260.0, LocalDate.of(2020, Month.AUGUST, 22));
    public static final Dish DISH8 = new Dish(DISH1_ID + 7, "Philadelphia Roll", 270.0, LocalDate.of(2020, Month.AUGUST, 23));
    public static final Dish DISH9 = new Dish(DISH1_ID + 8, "Salmon Boke", 280.0, LocalDate.of(2020, Month.AUGUST, 21));

    public static final DishTo DISH1_TO = new DishTo(DISH1, 100002, "McDonalds");
    public static final DishTo DISH2_TO = new DishTo(DISH2, 100002, "McDonalds");
    public static final DishTo DISH3_TO = new DishTo(DISH3, 100002, "McDonalds");
    public static final DishTo DISH4_TO = new DishTo(DISH4, 100003, "KFC");
    public static final DishTo DISH5_TO = new DishTo(DISH5, 100003, "KFC");
    public static final DishTo DISH6_TO = new DishTo(DISH6, 100003, "KFC");
    public static final DishTo DISH7_TO = new DishTo(DISH7, 100004, "Sushi-Oki");
    public static final DishTo DISH8_TO = new DishTo(DISH8, 100004, "Sushi-Oki");
    public static final DishTo DISH9_TO = new DishTo(DISH9, 100004, "Sushi-Oki");

    public static  List<Dish> DISHES = List.of(DISH2, DISH5, DISH8, DISH1, DISH4, DISH7, DISH3, DISH6, DISH9);
    public static  List<DishTo> DISHES_TO = List.of(DISH2_TO, DISH5_TO, DISH8_TO, DISH1_TO, DISH4_TO, DISH7_TO, DISH3_TO, DISH6_TO, DISH9_TO);

    public static Dish getNew() {
        return new Dish(null, "Созданное блюдо", 480.0 , LocalDate.of(2020, Month.AUGUST, 21));
    }

    public static DishTo getNewTo() {
        return new DishTo(getNew(), 100002, "McDonalds");
    }

    public static Dish getUpdated() {
        return new Dish(DISH1_ID,"Обновленный завтрак", 200.0, LocalDate.of(2020, Month.AUGUST, 21));
    }

    public static DishTo getUpdatedTo() {
        return new DishTo(getUpdated(), 100002, "McDonalds");
    }
}
