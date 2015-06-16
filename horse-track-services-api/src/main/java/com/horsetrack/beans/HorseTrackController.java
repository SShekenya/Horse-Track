package com.horsetrack.beans;

/**
 * Created by sergii.shekenya on 16.06.2015.
 */
public interface HorseTrackController {

    public void restockPayouts();

    public void startRace(Long winningHorseId);

    public Long betOnHorse(Long horseId, Long amount);
}
