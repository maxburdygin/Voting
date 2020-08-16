package com.petproject.voting.repository;

import com.petproject.voting.model.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Transactional(readOnly = true)
public interface CrudMealRepository extends JpaRepository<Meal, Integer> {

    @Query("SELECT m FROM Meal m JOIN FETCH m.restaurant WHERE m.restaurant.id=:restaurantId ORDER BY m.id ASC")
    List<Meal> getAllByRestaurantId(@Param("restaurantId") int restaurantId);

    @Query("SELECT m FROM Meal m JOIN FETCH m.restaurant WHERE m.localDate=:today ORDER BY m.id ASC")
    List<Meal> getAllForToday(@Param("today") LocalDate today);

    @Query("SELECT m FROM Meal m JOIN FETCH m.restaurant ORDER BY m.localDate DESC")
    List<Meal> getAll();

    @Query("SELECT m FROM Meal m JOIN FETCH m.restaurant WHERE m.restaurant.id=:restaurantId AND m.localDate=:today ORDER BY m.id ASC")
    List<Meal> getAllByRestaurantIdForToday(@Param("restaurantId") int restaurantId, @Param("today") LocalDate today);

    @Transactional
    @Modifying
    @Query("DELETE FROM Meal m WHERE m.id=:id")
    int delete(@Param("id") int id);
}
