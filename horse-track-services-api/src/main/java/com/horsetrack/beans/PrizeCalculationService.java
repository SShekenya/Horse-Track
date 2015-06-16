package com.horsetrack.beans;

import com.horsetrack.model.Horse;

/**
 * Created by sergii.shekenya on 6/16/2015.
 */
public interface PrizeCalculationService {
    Long calculateWinningAmount(Horse horse, Long rate);
}
