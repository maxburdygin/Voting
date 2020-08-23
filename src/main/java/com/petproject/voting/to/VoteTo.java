package com.petproject.voting.to;

import java.time.LocalDate;

public class VoteTo {
    private final Integer id;

    private final LocalDate localDate;

    private final Integer restaurantId;

    private final Integer userId;

    public VoteTo(Integer id, LocalDate localDate, Integer restaurantId, Integer userId) {
        this.id = id;
        this.localDate = localDate;
        this.restaurantId = restaurantId;
        this.userId = userId;
    }

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

    @Override
    public String toString() {
        return "MealTo{" +
                "id=" + id +
                ", restaurantId=" + restaurantId +
                ", localDate=" + localDate +
                ", userId=" + userId +
                '}';
    }
}
