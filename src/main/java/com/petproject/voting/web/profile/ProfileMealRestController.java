package com.petproject.voting.web.profile;

import com.petproject.voting.service.MealService;
import com.petproject.voting.to.MealTo;
import com.petproject.voting.util.MealsUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = ProfileMealRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class ProfileMealRestController {
    private static final Logger log = LoggerFactory.getLogger(ProfileMealRestController.class);

    public static final String REST_URL = "/meals";
    private final MealService service;

    public ProfileMealRestController(MealService service) {
        this.service = service;
    }

    @GetMapping
    public List<MealTo> getAll() {
        log.info("getAll");
        return MealsUtil.getTos(service.getAllByDate(LocalDate.now()));
    }

    @GetMapping(value = "/byRest")
    public List<MealTo> getByRest(
            @RequestParam int id) {
        log.info("getAll by restaurantId {}", id);
        return MealsUtil.getTos(service.getAllByRestaurantIdAndDate(id, LocalDate.now()));
    }
}
