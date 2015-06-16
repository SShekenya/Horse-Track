package com.horsetrack.cli;

import com.horsetrack.beans.HorseTrackController;
import com.horsetrack.context.WeldContext;

/**
 * Created by sergii.shekenya on 16.06.2015.
 */
public class HorseTrackCliDriver {
    public static void main(String[] args) {
        HorseTrackController horseTrackController = WeldContext.INSTANCE.getBean(HorseTrackController.class);
        horseTrackController.restockPayouts();
        horseTrackController.startRace(5L);
        horseTrackController.betOnHorse(5L, 100L);
    }
}
