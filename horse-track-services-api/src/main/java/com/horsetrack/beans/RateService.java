package com.horsetrack.beans;

import com.horsetrack.model.Horse;

/**
 * Created by sergii.shekenya on 16.06.2015.
 */
public interface RateService {
    Long rateHorse(Horse horse, Long amount);
}
