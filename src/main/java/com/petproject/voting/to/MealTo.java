package com.petproject.voting.to;

import com.petproject.voting.model.Meal;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class MealTo {
    private Integer id;

    private String description;

    private Double price;

    private LocalDate localDate;

    private Integer restaurantId;

    private String restaurantName;

    public MealTo(Integer id, String description, Double price, LocalDate localDate, Integer restaurantId, String restaurantName) {
        this.id = id;
        this.description = description;
        this.price = price;
        this.localDate = localDate;
        this.restaurantId = restaurantId;
        this.restaurantName = restaurantName;
    }

    public MealTo(String description, Double price, LocalDate localDate, Integer restaurantId, String restaurantName) {
        this(null, description, price, localDate, restaurantId, restaurantName);
    }

    public MealTo(Meal meal, Integer restaurantId, String restaurantName) {
        this(meal.getId(), meal.getDescription(), meal.getPrice(), meal.getLocalDate(), restaurantId, restaurantName);
    }

    public MealTo(){}

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

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public void setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
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
