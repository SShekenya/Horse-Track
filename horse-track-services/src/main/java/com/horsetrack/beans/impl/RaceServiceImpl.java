package com.horsetrack.beans.impl;

import com.horsetrack.beans.RaceService;
import com.horsetrack.dataprovider.HorseDataProvider;
import com.horsetrack.dataprovider.RaceDataProvider;
import com.horsetrack.model.Horse;
import com.horsetrack.model.Race;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

/**
 * Created by sergii.shekenya on 16.06.2015.
 */
public class RaceServiceImpl implements RaceService {

    @Inject
    private RaceDataProvider raceDataProvider;

    @Inject
    private HorseDataProvider horseDataProvider;

    @PostConstruct
    private void init() {
        startRace(horseDataProvider.findById(1L));
    }

    @Override
    public void startRace(Horse winningHorse) {
        Race race = new Race();
        race.setWinningHorse(winningHorse);
        raceDataProvider.persist(race);
    }
}
