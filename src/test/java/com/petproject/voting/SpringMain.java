package com.petproject.voting;

import com.petproject.voting.util.DishesUtil;

import static com.petproject.voting.testdata.DishTestData.DISHES;

public class SpringMain {
    public static void main(String[] args) {
        /*ConfigurableApplicationContext appCtx = new ClassPathXmlApplicationContext("spring/spring-app.xml", "spring/spring-db.xml");
        System.out.println("Bean definition names: " + Arrays.toString(appCtx.getBeanDefinitionNames()));

        VoteRestController controller = (VoteRestController) appCtx.getBean("voteRestController");
        controller.getAll().forEach(m -> System.out.println(m.toString()));
        controller.create(new VoteTo(LocalDate.of(2020,8,25), 100003, 100000));
        controller.getAll().forEach(m -> System.out.println(m.toString()));*/
    }
}
