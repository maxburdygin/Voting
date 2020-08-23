package com.petproject.voting.to;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class MealTo {
    private final Integer id;

    private final String description;

    private final Double price;

    private final LocalDate localDate;

    private final Integer restaurantId;

    private final String restaurantName;

    public MealTo(Integer id, String description, Double price, LocalDate localDate, Integer restaurantId, String restaurantName) {
        this.id = id;
        this.description = description;
        this.price = price;
        this.localDate = localDate;
        this.restaurantId = restaurantId;
        this.restaurantName = restaurantName;
    }

    public Integer getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public Integer getRestaurantId() {
        return restaurantId;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    @Override
    public String toString() {
        return "MealTo{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", localDate=" + localDate +
                ", restaurantId=" + restaurantId +
                ", restaurantName='" + restaurantName + '\'' +
                '}';
    }
}
