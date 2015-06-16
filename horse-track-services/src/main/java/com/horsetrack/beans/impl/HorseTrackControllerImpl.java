package com.horsetrack.beans.impl;

import com.horsetrack.beans.HorseTrackController;
import com.horsetrack.beans.RaceService;
import com.horsetrack.beans.RateService;
import com.horsetrack.dataprovider.HorseDataProvider;
import com.horsetrack.dataprovider.PayoutDataProvider;
import com.horsetrack.model.Horse;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by sergii.shekenya on 16.06.2015.
 */
@Named
@Default
public class HorseTrackControllerImpl implements HorseTrackController {
    @Inject
    private PayoutDataProvider payoutDataProvider;

    @Inject
    private HorseDataProvider horseDataProvider;

    @Inject
    private RaceService raceService;

    @Inject
    private RateService rateService;

    @Override
    public void restockPayouts() {
        payoutDataProvider.restock();
    }

    @Override
    public void startRace(Long winningHorseId) {
        Horse winningHorse = horseDataProvider.findById(winningHorseId);
        raceService.startRace(winningHorse);
    }

    @Override
    public Long betOnHorse(Long horseId, Long amount) {
        Horse horse = horseDataProvider.findById(horseId);
        return rateService.rateHorse(horse, amount);
    }
}
