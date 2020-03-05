package com.taskplanner.taskplanner.domain;

public class Subtask {
    private String naam, description;

    public Subtask(String naam, String description) {
        this.naam = naam;
        this.description = description;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
