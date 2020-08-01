package com.petproject.voting.model;

public abstract class AbstractNamedEntity {
    protected int id;
    protected String name;

    public AbstractNamedEntity(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public AbstractNamedEntity(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isNew() {
        return id==0;
    }
}
