package com.petproject.voting.web;

import com.petproject.voting.service.DishService;
import com.petproject.voting.to.DishTo;
import com.petproject.voting.util.DishesUtil;
import com.petproject.voting.util.NotFoundException;
import com.petproject.voting.web.admin.DishRestController;
import com.petproject.voting.web.json.JsonUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.petproject.voting.TestUtil.readFromJson;
import static com.petproject.voting.testdata.DishTestData.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class DishRestControllerTest extends AbstractControllerTest {
    private static final String REST_URL = DishRestController.REST_URL + '/';

    @Autowired
    private DishService dishService;

    @Test
    void get() throws Exception {
        perform(MockMvcRequestBuilders.get(REST_URL + DISH1_ID))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(DISH_TO_MATCHER.contentJson(DISH1_TO));
    }

    @Test
    void delete() throws Exception {
        perform(MockMvcRequestBuilders.delete(REST_URL + DISH1_ID))
                .andExpect(status().isNoContent());
        assertThrows(NotFoundException.class, () -> dishService.get(DISH1_ID));
    }

    @Test
    void update() throws Exception {
        DishTo updated = getUpdatedTo();
        perform(MockMvcRequestBuilders.put(REST_URL + DISH1_ID).contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(updated)))
                .andExpect(status().isNoContent());

        DISH_TO_MATCHER.assertMatch(DishesUtil.createTo(dishService.get(DISH1_ID)), updated);
    }

    @Test
    void createWithLocation() throws Exception {
        DishTo newDish = getNewTo();
        ResultActions action = perform(MockMvcRequestBuilders.post(REST_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(newDish)));

        DishTo created = readFromJson(action, DishTo.class);
        int newId = created.getId();
        newDish.setId(newId);
        DISH_TO_MATCHER.assertMatch(DishesUtil.createTo(dishService.get(newId)), newDish);
    }

    @Test
    void getAll() throws Exception {
        perform(MockMvcRequestBuilders.get(REST_URL))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(DISH_TO_MATCHER.contentJson(DISHES_TO));
    }

    @Test
    void getByRest() throws Exception {
        perform(MockMvcRequestBuilders.get(REST_URL + "byRest?id=100003"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(DISH_TO_MATCHER.contentJson(DISH5_TO, DISH4_TO, DISH6_TO));
    }

    @Test
    void getByDate() throws Exception {
        perform(MockMvcRequestBuilders.get(REST_URL + "byDate?date=2020-08-22"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(DISH_TO_MATCHER.contentJson(DISH1_TO, DISH4_TO, DISH7_TO));
    }

    @Test
    void getByRestAndDate() throws Exception {
        perform(MockMvcRequestBuilders.get(REST_URL + "by?id=100003&date=2020-08-22"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
                //.andExpect(DISH_TO_MATCHER.contentJson(DISH4_TO));
    }
}
