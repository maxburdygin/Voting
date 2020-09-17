package com.petproject.voting.service;

import com.petproject.voting.model.Vote;
import com.petproject.voting.repository.RestaurantRepository;
import com.petproject.voting.repository.UserRepository;
import com.petproject.voting.repository.VoteRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.util.List;

import static com.petproject.voting.util.ValidationUtil.checkNotFoundWithId;

@Service
public class VoteService {

    private static final Sort SORT_DATE_REST_USER = Sort.by(new Sort.Order(Sort.Direction.DESC, "localDate"),
            new Sort.Order(Sort.Direction.ASC, "restaurantId"),
            new Sort.Order(Sort.Direction.ASC, "userId"));

    private final VoteRepository voteRepository;
    private final UserRepository userRepository;
    private final RestaurantRepository restaurantRepository;

    public VoteService(VoteRepository voteRepository, UserRepository userRepository, RestaurantRepository restaurantRepository) {
        this.voteRepository = voteRepository;
        this.userRepository = userRepository;
        this.restaurantRepository = restaurantRepository;
    }

    public Vote get(int id) {
        return checkNotFoundWithId(voteRepository.findById(id).orElse(null), id);
    }

    @CacheEvict(value = "votes", allEntries = true)
    public void delete(int id) {
        checkNotFoundWithId(voteRepository.delete(id) != 0, id);
    }

    @Cacheable("votes")
    public List<Vote> getAll() {
        return voteRepository.getAll();
    }

    @Cacheable("votes")
    public List<Vote> getAllByDate(LocalDate localDate) {
        return voteRepository.getAllByDate(localDate);
    }

    @Cacheable("votes")
    public List<Vote> getAllByUserId(int userId) {
        return voteRepository.getAllByUserId(userId);
    }

    @Cacheable("votes")
    public List<Vote> getAllByRestaurantId(int restaurantId) {
        return voteRepository.getAllByRestaurantId(restaurantId);
    }

    @CacheEvict(value = "votes", allEntries = true)
    public void update(Vote vote, int restaurantId, int userId) {
        Assert.notNull(vote, "vote must not be null");
        checkNotFoundWithId(save(vote, restaurantId, userId), vote.id());
    }

    @CacheEvict(value = "votes", allEntries = true)
    public Vote create(Vote vote, int restaurantId, int userId) {
        Assert.notNull(vote, "vote must not be null");
        return save(vote, restaurantId, userId);
    }

    @Transactional(readOnly = true)
    @CacheEvict(value = "votes", allEntries = true)
    public Vote save(Vote vote, int restaurantId, int userId) {
        if ((!vote.isNew() && get(vote.id()) == null) ||
                restaurantRepository.findById(restaurantId).isEmpty()) {
            return null;
        }
        vote.setUser(userRepository.getOne(userId));
        vote.setRestaurant(restaurantRepository.getOne(restaurantId));
        return voteRepository.save(vote);
    }
}
