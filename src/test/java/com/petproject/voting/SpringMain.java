package com.petproject.voting;

import com.petproject.voting.model.*;
import com.petproject.voting.repository.MealRepository;
import com.petproject.voting.repository.RestaurantRepository;
import com.petproject.voting.repository.UserRepository;
import com.petproject.voting.service.MealService;
import com.petproject.voting.service.UserService;
import com.petproject.voting.service.VoteService;
import com.petproject.voting.to.MealTo;
import com.petproject.voting.to.VoteTo;
import com.petproject.voting.util.MealsUtil;
import com.petproject.voting.util.VotesUtil;
import com.petproject.voting.web.MealRestController;
import com.petproject.voting.web.VoteRestController;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.LocalDate;
import java.util.Arrays;

import static com.petproject.voting.testdata.MealTestData.MEALS;

public class SpringMain {
    public static void main(String[] args) {
        /*ConfigurableApplicationContext appCtx = new ClassPathXmlApplicationContext("spring/spring-app.xml", "spring/spring-db.xml");
        System.out.println("Bean definition names: " + Arrays.toString(appCtx.getBeanDefinitionNames()));

        VoteRestController controller = (VoteRestController) appCtx.getBean("voteRestController");
        controller.getAll().forEach(m -> System.out.println(m.toString()));
        controller.create(new VoteTo(LocalDate.of(2020,8,25), 100003, 100000));
        controller.getAll().forEach(m -> System.out.println(m.toString()));*/


       /* Vote meal = new Vote(LocalDate.of(2020, 8, 25));
        System.out.println(meal.toString());

        Vote meal2 = VotesUtil.createFromTo(new VoteTo(LocalDate.of(2020,8,25), 100003, 100001));
        System.out.println(meal2.toString());*/

        /*VoteService service = (VoteService) appCtx.getBean("voteService");

        service.create(new VoteTo(LocalDate.of(2020,8,24), 100003, 100000));
        service.getAll().forEach(m -> System.out.println(m.toString()));
        controller.getAll().forEach(m -> System.out.println(m.toString()));*/

        //appCtx.close();
        
        MealsUtil.getTos(MEALS).forEach(mealTo -> System.out.println(mealTo.toString()));
    }
}
