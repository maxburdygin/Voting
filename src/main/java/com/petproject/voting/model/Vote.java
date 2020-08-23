package com.petproject.voting.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "votes", uniqueConstraints = {@UniqueConstraint(columnNames =
        {"user_id", "local_date"}, name = "votes_unique_user_date_idx")})
public class Vote extends AbstractBaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Restaurant restaurant;

    @Column(name = "local_date", nullable = false)
    @NotNull
    private LocalDate localDate;

    public Vote() {
    }

    public Vote(Integer id, LocalDate date) {
        super(id);
        this.localDate = date;
    }

    public Vote(Integer id, LocalDate date, User user, Restaurant restaurant) {
        super(id);
        this.localDate = date;
        this.user = user;
        this.restaurant = restaurant;
    }

    public Vote(LocalDate date) {
        this(null, date);
    }

    public Vote(Vote vote) {
        this(vote.id, vote.localDate, vote.user, vote.restaurant);
    }

    public User getUser() {
        return user;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public LocalDate getDate() {
        return localDate;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public void setDate(LocalDate date) {
        this.localDate = date;
    }

    @Override
    public String toString() {
        return "Vote{" +
                ", localDate=" + localDate +
                ", id=" + id +
                '}';
    }
}
