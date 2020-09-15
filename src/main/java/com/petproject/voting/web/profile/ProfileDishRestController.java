package com.petproject.voting.web.profile;

import com.petproject.voting.service.DishService;
import com.petproject.voting.to.DishTo;
import com.petproject.voting.util.DishesUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = ProfileDishRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class ProfileDishRestController {
    public static final String REST_URL = "/dishes";
    private static final Logger log = LoggerFactory.getLogger(ProfileDishRestController.class);
    private final DishService service;

    public ProfileDishRestController(DishService service) {
        this.service = service;
    }

    @GetMapping
    public List<DishTo> getAll() {
        log.info("getAll");
        return DishesUtil.getTos(service.getAllByDate(LocalDate.now()));
    }

    @GetMapping(value = "/byRest")
    public List<DishTo> getByRest(
            @RequestParam int id) {
        log.info("getAll by restaurantId {}", id);
        return DishesUtil.getTos(service.getAllByRestaurantIdAndDate(id, LocalDate.now()));
    }
}
