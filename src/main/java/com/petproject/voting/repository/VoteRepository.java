package com.petproject.voting.repository;

import com.petproject.voting.model.User;
import com.petproject.voting.model.Vote;

import java.time.LocalDate;
import java.util.List;

public interface VoteRepository {
    // null if not found, when updated
    Vote save(Vote vote, int restaurantId, int userId);

    // false if not found
    boolean delete(int id, int userId);

    // null if not found
    Vote get(int id, int userId);

    List<Vote> getAll();

    List<Vote> getAllByDate(LocalDate localDate);

    List<Vote> getAllByUserId(int userId);

    List<Vote> getAllByRestaurantId(int restaurantId);
}
