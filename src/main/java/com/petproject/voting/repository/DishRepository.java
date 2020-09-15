package com.petproject.voting.repository;


import com.petproject.voting.model.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public interface DishRepository extends JpaRepository<Dish, Integer> {

    @Query("SELECT d FROM Dish d JOIN FETCH d.restaurant WHERE d.restaurant.id=:restaurantId ORDER BY d.localDate DESC")
    List<Dish> getAllByRestaurantId(@Param("restaurantId") int restaurantId);

    @Query("SELECT d FROM Dish d JOIN FETCH d.restaurant WHERE d.id=:id")
    Dish get(@Param("id") int id);

    @Query("SELECT d FROM Dish d JOIN FETCH d.restaurant ORDER BY d.localDate DESC")
    List<Dish> getAll();

    @Query("SELECT d FROM Dish d JOIN FETCH d.restaurant WHERE d.restaurant.id=:restaurantId AND d.localDate=:localDate ORDER BY d.id ASC")
    List<Dish> getAllByRestaurantIdAndDate(@Param("restaurantId") int restaurantId, @Param("localDate") LocalDate localDate);

    @Query("SELECT d FROM Dish d JOIN FETCH d.restaurant WHERE d.localDate=:localDate ORDER BY d.restaurant.id ASC")
    List<Dish> getAllByDate(@Param("localDate") LocalDate localDate);

    @Transactional
    @Modifying
    @Query("DELETE FROM Dish d WHERE d.id=:id")
    int delete(@Param("id") int id);
}
