package com.horsetrack.dataprovider;

import com.horsetrack.model.Race;

import java.util.List;

/**
 * Created by sergii.shekenya on 14.06.2015.
 */
public interface RaceDataProvider {
    void persist(Race race);

    Race findById(Long id);

    Race findLatestRace();

    List<Race> findAll();
}
