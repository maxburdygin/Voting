package com.petproject.voting.model;

import java.util.Set;

public class Restaurant extends AbstractNamedEntity {
    private int votes;

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
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }

    public Set<Meal> getMeals() {
        return meals;
    }

    public void setMeals(Set<Meal> meals) {
        this.meals = meals;
    }

}
