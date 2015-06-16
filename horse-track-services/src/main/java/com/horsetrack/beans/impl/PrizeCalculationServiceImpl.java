package com.horsetrack.beans.impl;

import com.horsetrack.beans.PrizeCalculationService;
import com.horsetrack.model.Horse;

/**
 * Created by sergii.shekenya on 6/16/2015.
 */

public class PrizeCalculationServiceImpl implements PrizeCalculationService {
    @Override
    public Long calculateWinningAmount(Horse horse, Long rate) {
        return horse.getOdds() * rate;
    }
}
