package com.petproject.voting.web;


import com.petproject.voting.service.VoteService;
import com.petproject.voting.to.VoteTo;
import com.petproject.voting.util.NotFoundException;
import com.petproject.voting.util.VotesUtil;
import com.petproject.voting.web.admin.VoteRestController;
import com.petproject.voting.web.json.JsonUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.petproject.voting.testdata.VoteTestData.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class VoteRestControllerTest extends AbstractControllerTest {
    private static final String REST_URL = VoteRestController.REST_URL + '/';

    @Autowired
    private VoteService voteService;

    @Test
    void get() throws Exception {
        perform(MockMvcRequestBuilders.get(REST_URL + VOTE1_ID))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(VOTE_TO_MATCHER.contentJson(VOTE1_TO));
    }

    @Test
    void delete() throws Exception {
        perform(MockMvcRequestBuilders.delete(REST_URL + VOTE1_ID))
                .andExpect(status().isNoContent());
        assertThrows(NotFoundException.class, () -> voteService.get(VOTE1_ID));
    }

    @Test
    void update() throws Exception {
        VoteTo updated = getUpdatedVoteTo();
        perform(MockMvcRequestBuilders.put(REST_URL + VOTE1_ID).contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(updated)))
                .andExpect(status().isNoContent());

        VOTE_TO_MATCHER.assertMatch(VotesUtil.createTo(voteService.get(VOTE1_ID)), updated);
    }

    @Test
    void create() throws Exception {
        VoteTo newVote = getNewVoteTo();
        ResultActions action = perform(MockMvcRequestBuilders.post(REST_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(newVote)));

        /*int newId = readFromJson(action, VoteTo.class).getId();
        newVote.setId(newId);
        VOTE_TO_MATCHER.assertMatch(VotesUtil.createTo(voteService.get(newId)), newVote);*/
    }

    @Test
    void getAll() throws Exception {
        perform(MockMvcRequestBuilders.get(REST_URL))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(VOTE_TO_MATCHER.contentJson(VOTE5_TO, VOTE3_TO, VOTE4_TO, VOTE1_TO, VOTE2_TO));
    }

    @Test
    void getByRestId() throws Exception {
        perform(MockMvcRequestBuilders.get(REST_URL + "byRest?id=100003"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(VOTE_TO_MATCHER.contentJson(VOTE5_TO, VOTE4_TO, VOTE2_TO));
    }

    @Test
    void getByDate() throws Exception {
        perform(MockMvcRequestBuilders.get(REST_URL + "byDate?date=2020-08-22"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(VOTE_TO_MATCHER.contentJson(VOTE4_TO, VOTE3_TO));
    }

    @Test
    void getByUserId() throws Exception {
        perform(MockMvcRequestBuilders.get(REST_URL + "byUser?id=100001"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(VOTE_TO_MATCHER.contentJson(VOTE5_TO, VOTE4_TO, VOTE2_TO));
    }
}
