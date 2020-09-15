package com.petproject.voting.to;

import com.petproject.voting.model.Dish;

import java.time.LocalDate;

public class DishTo {
    private Integer id;

    private String description;

    private Double price;

    private LocalDate localDate;

    private Integer restaurantId;

    private String restaurantName;

    public DishTo(Integer id, String description, Double price, LocalDate localDate, Integer restaurantId, String restaurantName) {
        this.id = id;
        this.description = description;
        this.price = price;
        this.localDate = localDate;
        this.restaurantId = restaurantId;
        this.restaurantName = restaurantName;
    }

    public DishTo(String description, Double price, LocalDate localDate, Integer restaurantId, String restaurantName) {
        this(null, description, price, localDate, restaurantId, restaurantName);
    }

    public DishTo(Dish dish, Integer restaurantId, String restaurantName) {
        this(dish.getId(), dish.getDescription(), dish.getPrice(), dish.getLocalDate(), restaurantId, restaurantName);
    }

    public DishTo() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public Integer getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    @Override
    public String toString() {
        return "DishTo{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", localDate=" + localDate +
                ", restaurantId=" + restaurantId +
                ", restaurantName='" + restaurantName + '\'' +
                '}';
    }
}
