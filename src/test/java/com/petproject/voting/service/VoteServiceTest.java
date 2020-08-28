package com.petproject.voting.service;

import com.petproject.voting.TestMatcher;
import com.petproject.voting.model.Role;
import com.petproject.voting.model.User;
import com.petproject.voting.model.Vote;
import com.petproject.voting.util.NotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import javax.validation.ConstraintViolationException;
import java.time.LocalDate;
import java.util.List;

import static com.petproject.voting.testdata.RestaurantTestData.*;
import static com.petproject.voting.testdata.UserTestData.*;
import static com.petproject.voting.testdata.UserTestData.NOT_FOUND;
import static com.petproject.voting.testdata.VoteTestData.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class VoteServiceTest extends AbstractServiceTest {
    @Autowired
    protected VoteService service;

    @Test
    void create() throws Exception {
        Vote created = service.create(getNewVote(), MCD_ID, USER_ID);
        int newId = created.id();
        Vote newVote = getNewVote();
        newVote.setId(newId);
        VOTE_MATCHER.assertMatch(created, newVote);
        VOTE_MATCHER.assertMatch(service.get(newId), newVote);
    }

    @Test
    void notUniqueDateWithUser() throws Exception {
        assertThrows(DataAccessException.class, () ->
                service.create(new Vote(null, LocalDate.of(2020, 8, 23)), SUSHI_ID, ADMIN_ID));
    }

    @Test
    void delete() throws Exception {
        service.delete(VOTE1_ID);
        assertThrows(NotFoundException.class, () -> service.get(VOTE1_ID));
    }

    @Test
    void deletedNotFound() throws Exception {
        assertThrows(NotFoundException.class, () -> service.delete(NOT_FOUND));
    }

    @Test
    void get() throws Exception {
        Vote vote = service.get(100017);
        VOTE_MATCHER.assertMatch(vote, VOTE4);
    }

    @Test
    void getNotFound() throws Exception {
        assertThrows(NotFoundException.class, () -> service.get(NOT_FOUND));
    }


    @Test
    void update() throws Exception {
        Vote updated = getUpdatedVote();
        service.update(updated, KFC_ID, USER_ID);
        VOTE_MATCHER.assertMatch(service.get(VOTE1_ID), getUpdatedVote());
    }

    @Test
    void getAll() throws Exception {
        List<Vote> all = service.getAll();
        VOTE_MATCHER.assertMatch(all, VOTE5, VOTE3, VOTE4, VOTE1, VOTE2);
    }

    @Test
    void getAllByDate() throws Exception {
        List<Vote> all = service.getAllByDate(LocalDate.of(2020, 8, 22));
        VOTE_MATCHER.assertMatch(all, VOTE4, VOTE3);
    }

    @Test
    void getAllByUserId() throws Exception {
        List<Vote> all = service.getAllByUserId(USER_ID);
        VOTE_MATCHER.assertMatch(all, VOTE3, VOTE1);
    }

    @Test
    void getAllByRestaurantId() throws Exception {
        List<Vote> all = service.getAllByRestaurantId(KFC_ID);
        VOTE_MATCHER.assertMatch(all, VOTE5, VOTE4, VOTE2);
    }

    @Test
    void createWithException() throws Exception {
        validateRootCause(() -> service.create(new Vote(null, null), KFC_ID, USER_ID), ConstraintViolationException.class);
    }
}
