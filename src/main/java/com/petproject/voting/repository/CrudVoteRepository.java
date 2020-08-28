package com.petproject.voting.repository;

import com.petproject.voting.model.Meal;
import com.petproject.voting.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Transactional(readOnly = true)
public interface CrudVoteRepository extends JpaRepository<Vote, Integer> {

    @Modifying
    @Transactional
    @Query("DELETE FROM Vote v WHERE v.id=:id")
    int delete(@Param("id") int id);

    @Query("SELECT v FROM Vote v JOIN FETCH v.restaurant WHERE v.localDate=:localDate ORDER BY v.restaurant.id ASC")
    List<Vote> getAllByDate(@Param("localDate") LocalDate localDate);

    @Query("SELECT v FROM Vote v JOIN FETCH v.user WHERE v.user.id=:userId ORDER BY v.localDate DESC")
    List<Vote> getAllByUserId(@Param("userId") int userId);

    @Query("SELECT v FROM Vote v JOIN FETCH v.restaurant WHERE v.restaurant.id=:restaurantId" +
            " ORDER BY v.localDate DESC")
    List<Vote> getAllByRestaurantId(@Param("restaurantId") int restaurantId);

    @Query("SELECT v FROM Vote v JOIN FETCH v.restaurant JOIN FETCH v.user" +
            " ORDER BY v.localDate DESC")
    List<Vote> getAll();
}
