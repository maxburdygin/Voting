package com.petproject.voting.model;

import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "meals", uniqueConstraints = {@UniqueConstraint(columnNames = {"restaurant_id", "description", "local_date"}, name = "meals_unique_restaurant_date_name_idx")})
public class Meal extends AbstractBaseEntity {

    @Column(name = "description", nullable = false)
    @NotBlank
    @Size(min = 2, max = 120)
    private String description;

    @Column(name = "price", nullable = false)
    @Range(min = 1, max = 5000)
    private Double price;

    @Column(name = "local_date", nullable = false)
    @NotNull
    private LocalDate localDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id", nullable = false)
    @NotNull
    private Restaurant restaurant;

    public Meal() {
    }

    public Meal(Integer id, String description, Double price, LocalDate localDate) {
        super(id);
        this.description = description;
        this.price = price;
        this.localDate = localDate;
    }

    public Meal(String description, Double price, LocalDate localDate) {
        this(null, description, price, localDate);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public String toString() {
        return "\n" + "Meal{" +
                "description='" + description + '\'' +
                ", price=" + price +
                ", localDate=" + localDate +
                ", id=" + id +
                '}';
    }
}
