package com.petproject.voting.model;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;

public class Meal extends AbstractNamedEntity {
    private int restaurantId;
    private Double price;

    public AtomicInteger getVotes() {
        return votes;
    }

    private LocalDate localDate;
    private Restaurant restaurant;
    private AtomicInteger votes = new AtomicInteger(0);


    public Restaurant getRestaurant() {
        return restaurant;
    }

    public Meal(int id, String name, int restaurantId, Double price, LocalDate localDate) {
        super(id, name);
        this.restaurantId = restaurantId;
        this.price = price;
        this.localDate = localDate;
    }

    public Meal(String name, int restaurantId, Double price, LocalDate localDate) {
        super(name);
        this.restaurantId = restaurantId;
        this.price = price;
        this.localDate = localDate;
    }

    @Override
    public String toString() {
        return "Meal{" +
                "id=" + id +
                ", name=" + name +
                ", restaurantId=" + restaurantId +
                ", price=" + price +
                ", localDate=" + localDate +
                '}';
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public int addVote() {
        return this.votes.incrementAndGet();
    }

}
