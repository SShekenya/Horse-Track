package com.horsetrack.dataprovider.inmemory;

import com.horsetrack.dataprovider.RaceDataProvider;
import com.horsetrack.model.Race;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import javax.inject.Named;
import java.util.List;

/**
 * Created by sergii.shekenya on 14.06.2015.
 */
@Named
@ApplicationScoped
@Default
public class InMemoryRaceDataProvider implements RaceDataProvider {
    @Override
    public void persist(Race race) {

    }

    @Override
    public Race findById(Long id) {
        return null;
    }

    @Override
    public Race findLatestRace() {
        return null;
    }

    @Override
    public List<Race> findAll() {
        return null;
    }
}
