package com.petproject.voting.testdata;

import com.petproject.voting.TestMatcher;
import com.petproject.voting.model.Role;
import com.petproject.voting.model.User;
import com.petproject.voting.model.Vote;
import com.petproject.voting.to.DishTo;
import com.petproject.voting.to.VoteTo;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;

import static com.petproject.voting.model.AbstractBaseEntity.START_SEQ;
import static com.petproject.voting.testdata.RestaurantTestData.*;
import static com.petproject.voting.testdata.UserTestData.*;

public class VoteTestData {
    public static TestMatcher<Vote> VOTE_MATCHER = TestMatcher.usingFieldsWithIgnoringComparator(Vote.class, "user","restaurant");
    public static TestMatcher<VoteTo> VOTE_TO_MATCHER = TestMatcher.usingFieldsWithIgnoringComparator(VoteTo.class, "");

    public static final int VOTE1_ID = 100014;
    public static final int VOTE4_ID = 100017;

    public static final Vote VOTE1 = new Vote(100014, LocalDate.of(2020, 8, 21));
    public static final Vote VOTE2 = new Vote(100015, LocalDate.of(2020, 8, 21));
    public static final Vote VOTE3 = new Vote(100016, LocalDate.of(2020, 8, 22));
    public static final Vote VOTE4 = new Vote(100017, LocalDate.of(2020, 8, 22));
    public static final Vote VOTE5 = new Vote(100018, LocalDate.of(2020, 8, 23));

    public static final VoteTo VOTE1_TO = new VoteTo(VOTE1, 100002, 100000);
    public static final VoteTo VOTE2_TO = new VoteTo(VOTE2, 100003, 100001);
    public static final VoteTo VOTE3_TO = new VoteTo(VOTE3, 100004, 100000);
    public static final VoteTo VOTE4_TO = new VoteTo(VOTE4, 100003, 100001);
    public static final VoteTo VOTE5_TO = new VoteTo(VOTE5, 100003, 100001);

    public static Vote getNewVote() {
        Vote vote = new Vote(null, LocalDate.of(2020, 8, 23));
        return vote;
    }

    public static Vote getUpdatedVote() {
        Vote updated = new Vote(VOTE1);
        updated.setRestaurant(KFC);
        return updated;
    }

    public static VoteTo getNewVoteTo() {
        VoteTo vote = new VoteTo(null, LocalDate.of(2020, 8, 23), 100002, 100000);
        return vote;
    }

    public static VoteTo getUpdatedVoteTo() {
        VoteTo updated = new VoteTo(VOTE1, 100004, 100000);
        return updated;
    }
}
