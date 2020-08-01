package com.petproject.voting.to;

import com.petproject.voting.model.Meal;
import com.petproject.voting.model.User;

import java.time.LocalDateTime;

public class VoteTo {
    private Meal meal;
    private User user;
    private LocalDateTime localDateTime;

    public VoteTo(User user, Meal meal) {
        this.localDateTime = meal.getLocalDate().atTime(11, 00);
        this.user = user;
        this.meal = meal;
    }

    public Meal getMeal() {
        return meal;
    }

    public void setMeal(Meal meal) {
        this.meal = meal;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }
}
