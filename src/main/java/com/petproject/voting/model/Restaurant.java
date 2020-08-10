package com.petproject.voting.model;

import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class Restaurant extends AbstractNamedEntity {
    private AtomicInteger votes = new AtomicInteger(0);

    private List<Meal> meals;

    public Restaurant(int id, String name) {
        super(id, name);
    }

    public Restaurant(String name) {
        super(name);
    }

    public int getVotes() {
        return votes.get();
    }

    public int addVote() {
        return votes.incrementAndGet();
    }

    public List<Meal> getMeals() {
        return meals;
    }

    public void setMeals(List<Meal> meals) {
        this.meals = meals;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "name=" + name +
/*                "id=" + id +
                "votes=" + votes +
                ", meals=" + meals +*/
                '}';
    }
}
