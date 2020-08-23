package com.petproject.voting;

import com.petproject.voting.model.*;
import com.petproject.voting.repository.MealRepository;
import com.petproject.voting.repository.RestaurantRepository;
import com.petproject.voting.repository.UserRepository;
import com.petproject.voting.service.MealService;
import com.petproject.voting.service.UserService;
import com.petproject.voting.service.VoteService;
import com.petproject.voting.web.MealRestController;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.LocalDate;
import java.util.Arrays;

public class SpringMain {
    public static void main(String[] args) {
        ConfigurableApplicationContext appCtx = new ClassPathXmlApplicationContext("spring/spring-app.xml", "spring/spring-db.xml");
        System.out.println("Bean definition names: " + Arrays.toString(appCtx.getBeanDefinitionNames()));

        VoteService service = (VoteService) appCtx.getBean("voteService");
        service.getAll().forEach((m) -> System.out.println(m.toString()));
        service.create(new Vote(LocalDate.of(2020, 8, 23)), 100002, 100000);
        service.getAll().forEach((m) -> System.out.println(m.toString()));

        appCtx.close();
    }
}
