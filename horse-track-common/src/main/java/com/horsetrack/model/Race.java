package com.horsetrack.model;

/**
 * Created by sergii.shekenya on 14.06.2015.
 */
public class Race {
    private Long raceId;
    private Horse winningHorse;

    public Long getRaceId() {
        return raceId;
    }

    public void setRaceId(Long raceId) {
        this.raceId = raceId;
    }

    public Horse getWinningHorse() {
        return winningHorse;
    }

    public void setWinningHorse(Horse winningHorse) {
        this.winningHorse = winningHorse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Race race = (Race) o;

        if (raceId != null ? !raceId.equals(race.raceId) : race.raceId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return raceId != null ? raceId.hashCode() : 0;
    }
}
