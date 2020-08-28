package com.petproject.voting.to;

import com.petproject.voting.model.Vote;

import java.time.LocalDate;

public class VoteTo {
    private Integer id;

    private LocalDate localDate;

    private Integer restaurantId;

    private Integer userId;

    public VoteTo(Integer id, LocalDate localDate, Integer restaurantId, Integer userId) {
        this.id = id;
        this.localDate = localDate;
        this.restaurantId = restaurantId;
        this.userId = userId;
    }

    public VoteTo(LocalDate localDate, Integer restaurantId, Integer userId) {
        this(null, localDate, restaurantId, userId);
    }

    public VoteTo(Vote vote, Integer restaurantId, Integer userId) {
        this(vote.id(), vote.getDate(), restaurantId, userId);
    }

    public VoteTo(){}

    public Integer getId() {
        return id;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public Integer getRestaurantId() {
        return restaurantId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public void setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "VoteTo{" +
                "id=" + id +
                ", localDate=" + localDate +
                ", restaurantId=" + restaurantId +
                ", userId=" + userId +
                '}';
    }
}
