package com.petproject.voting;

import com.petproject.voting.model.Meal;
import com.petproject.voting.model.Restaurant;
import com.petproject.voting.model.Role;
import com.petproject.voting.model.User;
import com.petproject.voting.repository.MealRepository;
import com.petproject.voting.repository.RestaurantRepository;
import com.petproject.voting.repository.UserRepository;
import com.petproject.voting.service.UserService;
import com.petproject.voting.web.MealRestController;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.LocalDate;
import java.util.Arrays;

public class SpringMain {
    public static void main(String[] args) {
        ConfigurableApplicationContext appCtx = new ClassPathXmlApplicationContext("spring/spring-app.xml", "spring/spring-db.xml");
        System.out.println("Bean definition names: " + Arrays.toString(appCtx.getBeanDefinitionNames()));

        MealRestController controller = (MealRestController) appCtx.getBean("mealRestController");
        controller.getAll().forEach((m) -> System.out.println(m.toString()));

        appCtx.close();
    }
}
