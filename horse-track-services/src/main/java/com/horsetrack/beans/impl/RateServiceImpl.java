package com.horsetrack.beans.impl;

import com.horsetrack.beans.PrizeCalculationService;
import com.horsetrack.beans.RateService;
import com.horsetrack.dataprovider.PrizeDataProvider;
import com.horsetrack.dataprovider.RaceDataProvider;
import com.horsetrack.model.Horse;
import com.horsetrack.model.Prize;
import com.horsetrack.model.Race;

import javax.inject.Inject;

/**
 * Created by sergii.shekenya on 16.06.2015.
 */
public class RateServiceImpl implements RateService {

    @Inject
    private PrizeCalculationService prizeCalculationService;

    @Inject
    private PrizeDataProvider prizeDataProvider;

    @Inject
    private RaceDataProvider raceDataProvider;

    @Override
    public Long rateHorse(Horse horse, Long amount) {
        Race race = raceDataProvider.findLatestRace();
        Long prizeAmount;
        if (race.getWinningHorse().equals(horse)) {
            prizeAmount = prizeCalculationService.calculateWinningAmount(horse, amount);
        } else {
            prizeAmount = 0L;
        }
        Prize prize = buildNewPrize(prizeAmount, horse);
        prizeDataProvider.persist(prize);
        return prize.getId();
    }

    private Prize buildNewPrize(Long amount, Horse horse) {
        Prize prize = new Prize();
        prize.setHorseId(horse.getId());
        prize.setAmount(amount);
        return prize;
    }
}