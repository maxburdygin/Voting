package com.petproject.voting.web.profile;

import com.petproject.voting.model.Restaurant;
import com.petproject.voting.service.DishService;
import com.petproject.voting.service.RestaurantService;
import com.petproject.voting.to.DishTo;
import com.petproject.voting.util.DishesUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = ProfileRestaurantRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class ProfileRestaurantRestController {
    public static final String REST_URL = "/restaurants";
    private static final Logger log = LoggerFactory.getLogger(ProfileRestaurantRestController.class);
    private final RestaurantService service;

    public ProfileRestaurantRestController(RestaurantService service) {
        this.service = service;
    }

    @GetMapping
    public List<Restaurant> getAll() {
        log.info("getAllWithMealsForToday");
        return service.getWithDishesForToday();
    }
}
