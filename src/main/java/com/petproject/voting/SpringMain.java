package com.petproject.voting;

import com.petproject.voting.model.Meal;
import com.petproject.voting.repository.MealRepository;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.LocalDate;
import java.util.Arrays;

public class SpringMain {
    public static void main(String[] args) {
        ConfigurableApplicationContext appCtx = new ClassPathXmlApplicationContext("spring/spring-app.xml");
        System.out.println("Bean definition names: " + Arrays.toString(appCtx.getBeanDefinitionNames()));

        MealRepository mealRepository = (MealRepository) appCtx.getBean("inMemoryMealRepository");
        mealRepository.save(new Meal("Nice new meal", 3, 430d, LocalDate.of(2020, 07, 22)));
//        MealRepository mealRepository = appCtx.getBean(MealRepository.class);
        mealRepository.getAll().forEach((x) -> System.out.println(x.toString()));
        appCtx.close();
    }
}
