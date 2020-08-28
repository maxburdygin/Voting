package com.petproject.voting.web;

import com.petproject.voting.service.MealService;
import com.petproject.voting.service.RestaurantService;
import com.petproject.voting.service.UserService;
import com.petproject.voting.service.VoteService;
import com.petproject.voting.util.MealsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RootController {

    @Autowired
    private UserService userService;

    @Autowired
    private MealService mealService;

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private VoteService voteService;

    @GetMapping("/")
    public String root() {
        return "index";
    }

    @GetMapping("/vovo/users")
    public String getUsers(Model model) {
        model.addAttribute("users", userService.getAll());
        return "users";
    }

    @PostMapping("/vovo/users")
    public String setUser(HttpServletRequest request) {
        int userId = Integer.parseInt(request.getParameter("userId"));
        //SecurityUtil.setAuthUserId(userId);
        return "redirect:meals";
    }

    @GetMapping("/vovo/meals")
    public String getMeals(Model model) {
        model.addAttribute("meals",
                MealsUtil.getTos(mealService.getAll()));
        return "meals";
    }

    @GetMapping("/vovo/restaurants")
    public String getRestaurants(Model model) {
        model.addAttribute("restaurants",
                restaurantService.getAll());
        return "restaurants";
    }
}
