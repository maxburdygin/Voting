package com.petproject.voting;

import com.petproject.voting.model.Meal;
import com.petproject.voting.model.Restaurant;
import com.petproject.voting.model.Role;
import com.petproject.voting.model.User;
import com.petproject.voting.repository.MealRepository;
import com.petproject.voting.repository.RestaurantRepository;
import com.petproject.voting.repository.UserRepository;
import com.petproject.voting.service.UserService;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.LocalDate;
import java.util.Arrays;

public class SpringMain {
    public static void main(String[] args) {
        ConfigurableApplicationContext appCtx = new ClassPathXmlApplicationContext("spring/spring-app.xml", "spring/spring-db.xml");
        System.out.println("Bean definition names: " + Arrays.toString(appCtx.getBeanDefinitionNames()));

/*        MealRepository mealRepository = (MealRepository) appCtx.getBean("dataJpaMealRepository");

        mealRepository.getAll().forEach((m) -> System.out.println(m.toString()));
        System.out.println("+++++++++++++++");
        mealRepository.save(new Meal(100005, "Шляпа а не хеппи мил", 150D, LocalDate.now()),100004);
        System.out.println("+++++++++++++++");
        mealRepository.getAllByRestaurantId(100004).forEach((m) -> System.out.println(m.toString()));
        System.out.println("+++++++++++++++");
        mealRepository.getAllByRestaurantId(100004).forEach((m) -> System.out.println(m.toString()));
        System.out.println("+++++++++++d++++");
        mealRepository.getAllForToday().forEach((m) -> System.out.println(m.toString()));
        System.out.println("+++++++++++d++++");
        mealRepository.getAllByRestaurantIdForToday(100003).forEach((m) -> System.out.println(m.toString()));
        System.out.println("+++++++++++d++++");
        mealRepository.delete(100005);
        System.out.println("+++++++++++d++++");
        System.out.println(mealRepository.get(100005).toString());
        System.out.println("+++++++++++d++++");*/


/*        RestaurantRepository restaurantRepository = (RestaurantRepository) appCtx.getBean("dataJpaRestaurantRepository");
        restaurantRepository.getAll().forEach((m) -> System.out.println(m.toString()));
        System.out.println("+++++++++++++++");
        System.out.println(restaurantRepository.get(100003).toString());
        System.out.println("+++++++++++d++++");
        restaurantRepository.save(new Restaurant(null, "Самый лучший ресторан", 1));
        System.out.println("+++++++++++d++++");
        restaurantRepository.getAll().forEach((m) -> System.out.println(m.toString()));
        System.out.println("+++++++++++++++");
        restaurantRepository.delete(100004);
        System.out.println("+++++++++++++++");
        restaurantRepository.getAll().forEach((m) -> System.out.println(m.toString()));
        System.out.println("+++++++++++d++++");
        restaurantRepository.save(new Restaurant(100002, "Хуйня а не макдональдс", 1));
        System.out.println("+++++++++++++++");
        restaurantRepository.getAll().forEach((m) -> System.out.println(m.toString()));
        System.out.println("+++++++++++d++++");*/

        /*UserRepository userRepository = (UserRepository) appCtx.getBean("dataJpaUserRepository");
        userRepository.getAll().forEach((m) -> System.out.println(m.toString()));
        System.out.println("+++++++++++++++");
        System.out.println(userRepository.get(100000).toString());
        System.out.println("+++++++++++++++");
        User user = new User(null, "Max", "max@mail.com", "123123", Role.ADMIN);
        userRepository.save(user);
        System.out.println("+++++++++++++++");
        userRepository.delete(100001);
        userRepository.getAll().forEach(u -> System.out.println(u.toString()));*/

        UserService userRepository = (UserService) appCtx.getBean("userService");
        userRepository.getAll().forEach((m) -> System.out.println(m.toString()));
        System.out.println("+++++++++++++++");
        System.out.println(userRepository.get(100000).toString());
        System.out.println("+++++++++++++++");
        User user = new User(null, "Max", "max@mail.com", "123123", Role.ADMIN);
        userRepository.update(user);
        System.out.println("+++++++++++++++");
        userRepository.delete(100001);
        userRepository.getAll().forEach(u -> System.out.println(u.toString()));

        appCtx.close();
    }
}
