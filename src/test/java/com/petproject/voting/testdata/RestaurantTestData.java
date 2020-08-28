package com.petproject.voting.testdata;

import com.petproject.voting.TestMatcher;
import com.petproject.voting.model.Meal;
import com.petproject.voting.model.Restaurant;
import com.petproject.voting.model.Role;
import com.petproject.voting.model.User;

import java.util.Collections;
import java.util.Date;

import static com.petproject.voting.model.AbstractBaseEntity.START_SEQ;

public class RestaurantTestData {
    public static TestMatcher<Restaurant> RESTAURANT_MATCHER = TestMatcher.usingFieldsWithIgnoringComparator(Restaurant.class, "meals");

    public static final int NOT_FOUND = 10;
    public static final int MCD_ID = START_SEQ + 2;
    public static final int KFC_ID = START_SEQ + 3;
    public static final int SUSHI_ID = START_SEQ + 4;

    public static final Restaurant MCD = new Restaurant(MCD_ID, "McDonalds");
    public static final Restaurant KFC = new Restaurant(KFC_ID, "KFC");
    public static final Restaurant SUSHI = new Restaurant(SUSHI_ID, "Sushi-Oki");

    public static Restaurant getNew() {
        return new Restaurant(null, "NewRestaurant");
    }

    public static Restaurant getUpdated() {
        Restaurant updated = new Restaurant(MCD);
        updated.setName("UpdatedRestaurantName");
        return updated;
    }
}
