package com.petproject.voting.web;

import com.petproject.voting.service.MealService;
import com.petproject.voting.to.MealTo;
import com.petproject.voting.util.MealsUtil;
import com.petproject.voting.util.NotFoundException;
import com.petproject.voting.web.admin.MealRestController;
import com.petproject.voting.web.json.JsonUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.petproject.voting.TestUtil.readFromJson;
import static com.petproject.voting.testdata.MealTestData.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class MealRestControllerTest extends AbstractControllerTest {
    private static final String REST_URL = MealRestController.REST_URL + '/';

    @Autowired
    private MealService mealService;

    @Test
    void get() throws Exception {
        perform(MockMvcRequestBuilders.get(REST_URL + MEAL1_ID))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(MEAL_TO_MATCHER.contentJson(MEAL1_TO));
    }

    @Test
    void delete() throws Exception {
        perform(MockMvcRequestBuilders.delete(REST_URL + MEAL1_ID))
                .andExpect(status().isNoContent());
        assertThrows(NotFoundException.class, () -> mealService.get(MEAL1_ID));
    }

    @Test
    void update() throws Exception {
        MealTo updated = getUpdatedTo();
        perform(MockMvcRequestBuilders.put(REST_URL + MEAL1_ID).contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(updated)))
                .andExpect(status().isNoContent());

        MEAL_TO_MATCHER.assertMatch(MealsUtil.createTo(mealService.get(MEAL1_ID)), updated);
    }

    @Test
    void createWithLocation() throws Exception {
        MealTo newMeal = getNewTo();
        ResultActions action = perform(MockMvcRequestBuilders.post(REST_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(newMeal)));

        MealTo created = readFromJson(action, MealTo.class);
        int newId = created.getId();
        newMeal.setId(newId);
        MEAL_TO_MATCHER.assertMatch(MealsUtil.createTo(mealService.get(newId)), newMeal);
    }

    @Test
    void getAll() throws Exception {
        perform(MockMvcRequestBuilders.get(REST_URL))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(MEAL_TO_MATCHER.contentJson(MEALS_TO));
    }

    @Test
    void getByRest() throws Exception {
        perform(MockMvcRequestBuilders.get(REST_URL + "byRest?id=100003"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(MEAL_TO_MATCHER.contentJson(MEAL5_TO, MEAL4_TO, MEAL6_TO));
    }

    @Test
    void getByDate() throws Exception {
        perform(MockMvcRequestBuilders.get(REST_URL + "byDate?date=2020-08-22"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(MEAL_TO_MATCHER.contentJson(MEAL1_TO, MEAL4_TO, MEAL7_TO));
    }

    @Test
    void getByRestAndDate() throws Exception {
        perform(MockMvcRequestBuilders.get(REST_URL + "by?id=100003&date=2020-08-22"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
                //.andExpect(MEAL_TO_MATCHER.contentJson(MEAL4_TO));
    }
}
