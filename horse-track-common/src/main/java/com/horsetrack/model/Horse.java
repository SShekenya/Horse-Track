package com.horsetrack.model;

/**
 * Created by sergii.shekenya on 14.06.2015.
 */
public class Horse {
    private Long id;
    private String name;
    private Long odds;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getOdds() {
        return odds;
    }

    public void setOdds(Long odds) {
        this.odds = odds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Horse horse = (Horse) o;

        if (id != null ? !id.equals(horse.id) : horse.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
