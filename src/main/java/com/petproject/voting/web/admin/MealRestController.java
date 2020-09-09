package com.petproject.voting.web.admin;

import com.petproject.voting.model.Meal;
import com.petproject.voting.service.MealService;
import com.petproject.voting.to.MealTo;
import com.petproject.voting.util.MealsUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;

import static com.petproject.voting.util.ValidationUtil.assureIdConsistent;
import static com.petproject.voting.util.ValidationUtil.checkNew;

@RestController
@RequestMapping(value = MealRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class MealRestController {
    private static final Logger log = LoggerFactory.getLogger(MealRestController.class);

    public static final String REST_URL = "/admin/meals";
    private final MealService service;

    public MealRestController(MealService service) {
        this.service = service;
    }


    @GetMapping("/{id}")
    public MealTo get(@PathVariable int id) {
        log.info("get meal {}", id);
        return MealsUtil.createTo(service.get(id));
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        log.info("delete meal {}", id);
        service.delete(id);
    }

    @GetMapping
    public List<MealTo> getAll() {
        log.info("getAll");
        return MealsUtil.getTos(service.getAll());
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Meal> create(@RequestBody MealTo mealTo) {
        Meal meal = MealsUtil.createFromTo(mealTo);
        checkNew(meal);
        log.info("create {} for restaurant {}", meal, mealTo.getRestaurantId());
        Meal created = service.create(meal, mealTo.getRestaurantId());

        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL + "/{id}")
                .buildAndExpand(created.getId()).toUri();

        return ResponseEntity.created(uriOfNewResource).body(created);
    }


    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void update(@RequestBody MealTo mealTo, @PathVariable int id) {
        Meal meal = MealsUtil.createFromTo(mealTo);
        assureIdConsistent(meal, id);
        log.info("update {} for id {}", meal, id);
        service.update(meal, mealTo.getRestaurantId());
    }

    @GetMapping(value = "/byRest")
    public List<MealTo> getByRest(
            @RequestParam int id) {
        log.info("getAll by restaurantId {}", id);
        return MealsUtil.getTos(service.getAllByRestaurantId(id));
    }

    @GetMapping(value = "/byDate")
    public List<MealTo> getByDate(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        log.info("getAll by date {}", date);
        return MealsUtil.getTos(service.getAllByDate(date));
    }

    @GetMapping(value = "/by")
    public List<MealTo> getByRestAndDate(
            @RequestParam int id,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        log.info("getAll by restaurantId {} and date {}", id, date);
        return MealsUtil.getTos(service.getAllByRestaurantIdAndDate(id, date));
    }
}
