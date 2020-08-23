package com.petproject.voting.repository;

import com.petproject.voting.model.User;
import com.petproject.voting.model.Vote;
import com.petproject.voting.util.NotFoundException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Repository
public class DataJpaVoteRepository implements VoteRepository {

    private static final Sort SORT_DATE_REST_USER = Sort.by(new Sort.Order(Sort.Direction.DESC, "localDate"),
            new Sort.Order(Sort.Direction.ASC, "restaurantId"),
            new Sort.Order(Sort.Direction.ASC, "userId"));

    private final CrudVoteRepository crudRepository;
    private final CrudUserRepository crudUserRepository;
    private final CrudRestaurantRepository crudRestaurantRepository;

    public DataJpaVoteRepository(CrudVoteRepository crudRepository, CrudUserRepository crudUserRepository, CrudRestaurantRepository crudRestaurantRepository) {
        this.crudRepository = crudRepository;
        this.crudUserRepository = crudUserRepository;
        this.crudRestaurantRepository = crudRestaurantRepository;
    }

    @Override
    public Vote save(Vote vote, int restaurantId, int userId) {
        if ((!vote.isNew() && get(vote.id(), userId) == null) ||
                crudRestaurantRepository.findById(restaurantId).orElse(null) == null) {
            return null;
        }
        vote.setUser(crudUserRepository.getOne(userId));
        vote.setRestaurant(crudRestaurantRepository.getOne(restaurantId));
        return crudRepository.save(vote);
    }

    @Override
    public boolean delete(int id, int userId) {
        return crudRepository.delete(id, userId) != 0;
    }

    @Override
    public Vote get(int id, int userId) {
        return crudRepository.findById(id)
                .filter(vote -> vote.getUser().getId() == userId)
                .orElse(null);
    }

    @Override
    public List<Vote> getAll() {
        return crudRepository.getAll();
    }

    @Override
    public List<Vote> getAllByDate(LocalDate localDate) {
        return crudRepository.getAllByDate(localDate);
    }

    @Override
    public List<Vote> getAllByUserId(int userId) {
        return crudRepository.getAllByUserId(userId);
    }

    @Override
    public List<Vote> getAllByRestaurantId(int restaurantId) {
        return crudRepository.getAllByRestaurantId(restaurantId);
    }
}