package com.petproject.voting.service;

import com.petproject.voting.model.Vote;
import com.petproject.voting.repository.VoteRepository;
import com.petproject.voting.to.VoteTo;
import com.petproject.voting.util.VotesUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.util.List;

import static com.petproject.voting.util.ValidationUtil.checkNotFoundWithId;

@Service
public class VoteService {
    private final VoteRepository repository;

    public VoteService(VoteRepository repository) {
        this.repository = repository;
    }

    public Vote get(int id) {
        return checkNotFoundWithId(repository.get(id), id);
    }

    public void delete(int id) {
        checkNotFoundWithId(repository.delete(id), id);
    }

    public List<Vote> getAll() {
        return repository.getAll();
    }

    public List<Vote> getAllByDate(LocalDate localDate) {
        return repository.getAllByDate(localDate);
    }

    public List<Vote> getAllByUserId(int userId) {
        return repository.getAllByUserId(userId);
    }

    public List<Vote> getAllByRestaurantId(int restaurantId) {
        return repository.getAllByRestaurantId(restaurantId);
    }

    public void update(Vote vote, int restaurantId, int userId) {
        Assert.notNull(vote, "vote must not be null");
        checkNotFoundWithId(repository.save(vote, restaurantId, userId), vote.id());
    }

    public Vote create(Vote vote, int restaurantId, int userId) {
        Assert.notNull(vote, "vote must not be null");
        return repository.save(vote, restaurantId, userId);
    }
}
