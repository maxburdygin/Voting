package com.petproject.voting.web.admin;

import com.petproject.voting.model.Dish;
import com.petproject.voting.service.DishService;
import com.petproject.voting.to.DishTo;
import com.petproject.voting.util.DishesUtil;
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
@RequestMapping(value = DishRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class DishRestController {
    public static final String REST_URL = "/admin/dishes";
    private static final Logger log = LoggerFactory.getLogger(DishRestController.class);
    private final DishService service;

    public DishRestController(DishService service) {
        this.service = service;
    }


    @GetMapping("/{id}")
    public DishTo get(@PathVariable int id) {
        log.info("get dish {}", id);
        return DishesUtil.createTo(service.get(id));
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        log.info("delete dish {}", id);
        service.delete(id);
    }

    @GetMapping
    public List<DishTo> getAll() {
        log.info("getAll");
        return DishesUtil.getTos(service.getAll());
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Dish> create(@RequestBody DishTo dishTo) {
        Dish dish = DishesUtil.createFromTo(dishTo);
        checkNew(dish);
        log.info("create {} for restaurant {}", dish, dishTo.getRestaurantId());
        Dish created = service.create(dish, dishTo.getRestaurantId());

        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL + "/{id}")
                .buildAndExpand(created.getId()).toUri();

        return ResponseEntity.created(uriOfNewResource).body(created);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void update(@RequestBody DishTo dishTo, @PathVariable int id) {
        Dish dish = DishesUtil.createFromTo(dishTo);
        assureIdConsistent(dish, id);
        log.info("update {} for id {}", dish, id);
        service.update(dish, dishTo.getRestaurantId());
    }

    @GetMapping(value = "/byRest")
    public List<DishTo> getByRest(
            @RequestParam int id) {
        log.info("getAll by restaurantId {}", id);
        return DishesUtil.getTos(service.getAllByRestaurantId(id));
    }

    @GetMapping(value = "/byDate")
    public List<DishTo> getByDate(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        log.info("getAll by date {}", date);
        return DishesUtil.getTos(service.getAllByDate(date));
    }

    @GetMapping(value = "/by")
    public List<DishTo> getByRestAndDate(
            @RequestParam int id,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        log.info("getAll by restaurantId {} and date {}", id, date);
        return DishesUtil.getTos(service.getAllByRestaurantIdAndDate(id, date));
    }
}
