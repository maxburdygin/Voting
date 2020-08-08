package com.petproject.voting.model;

import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class Restaurant extends AbstractNamedEntity {
    private AtomicInteger votes = new AtomicInteger(0);

    private Set<Meal> meals;

    public Restaurant(int id, String name) {
        super(id, name);
    }

    public Restaurant(String name) {
        super(name);
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

    public int getVotes() {
        return votes.get();
    }

    public int addVote() {
        return votes.incrementAndGet();
    }

    public Set<Meal> getMeals() {
        return meals;
    }

    public void setMeals(Set<Meal> meals) {
        this.meals = meals;
    }

}
