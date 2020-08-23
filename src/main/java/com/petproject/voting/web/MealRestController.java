package com.petproject.voting.web;

import com.petproject.voting.model.Meal;
import com.petproject.voting.service.MealService;
import com.petproject.voting.to.MealTo;
import com.petproject.voting.util.MealsUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Objects;

import static com.petproject.voting.util.ValidationUtil.assureIdConsistent;
import static com.petproject.voting.util.ValidationUtil.checkNew;

@Controller
@RequestMapping(value = "/meals")
public class MealRestController {
    private static final Logger log = LoggerFactory.getLogger(MealRestController.class);

    private final MealService service;

    public MealRestController(MealService service) {
        this.service = service;
    }

    public Meal get(int id) {
        log.info("get meal {}", id);
        return service.get(id);
    }


    @GetMapping("/delete")
    public String delete(HttpServletRequest request) {
        log.info("delete meal {}", getId(request));
        service.delete(getId(request));
        return "redirect:/meals";
    }

    public List<Meal> getAll() {
        log.info("getAll");
        return service.getAll();
    }

    public Meal create(Meal meal, int restaurantId) {
        checkNew(meal);
        log.info("create {} for restaurant {}", meal, restaurantId);
        return service.create(meal, restaurantId);
    }

    public void update(Meal meal, int restaurantId) {
        assureIdConsistent(meal, restaurantId);
        log.info("update {} for restaurant {}", meal, restaurantId);
        service.update(meal, restaurantId);
    }

    private int getId(HttpServletRequest request) {
        String paramId = Objects.requireNonNull(request.getParameter("id"));
        return Integer.parseInt(paramId);
    }
}
