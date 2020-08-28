package com.petproject.voting.util;

import com.petproject.voting.model.Meal;
import com.petproject.voting.model.Vote;
import com.petproject.voting.to.MealTo;
import com.petproject.voting.to.VoteTo;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class VotesUtil {
    public VotesUtil() {
    }
    public static List<VoteTo> getTos(Collection<Vote> votes) {
        return votes.stream()
                .map(VotesUtil::createTo)
                .collect(Collectors.toList());
    }

    public static VoteTo createTo(Vote vote) {
        return new VoteTo(vote.getId(), vote.getDate(), vote.getRestaurant().getId(), vote.getUser().getId());
    }

    public static Vote createFromTo(VoteTo voteTo) {
        return new Vote(voteTo.getId(), voteTo.getLocalDate());
    }
    public static boolean isVotedToday(VoteTo voteTo) {
        return voteTo.getLocalDate().isEqual(LocalDate.now());
    }
}
