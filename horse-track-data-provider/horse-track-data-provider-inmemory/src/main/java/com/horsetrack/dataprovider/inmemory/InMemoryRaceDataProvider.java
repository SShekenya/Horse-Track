package com.horsetrack.dataprovider.inmemory;

import com.horsetrack.dataprovider.RaceDataProvider;
import com.horsetrack.model.Race;

import javax.enterprise.inject.Default;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sergii.shekenya on 14.06.2015.
 */

@Named
@Default
public class InMemoryRaceDataProvider implements RaceDataProvider {
    private Map<Long, Race> races = new LinkedHashMap<Long, Race>();

    @Override
    public void persist(Race race) {
        if (race.getRaceId() != null) {
            if (races.containsKey(race.getRaceId())) {
                throw new IllegalArgumentException("The race with id " + race.getRaceId() + " is already exist");
            }
        } else {
            race.setRaceId(getNextRaceId());
        }

        races.put(race.getRaceId(), race);
    }

    @Override
    public Race findById(Long id) {
        return races.get(id);
    }

    @Override
    public Race findLatestRace() {
        return races.get(getLastRaceId());
    }

    @Override
    public List<Race> findAll() {
        return new ArrayList<Race>(races.values());
    }

    private Long getNextRaceId() {
        return getLastRaceId() + 1;
    }

    private Long getLastRaceId() {
        Long lastRaceId;
        if (!races.isEmpty()) {
            Long[] temporaryList = (Long[]) races.keySet().toArray();
            lastRaceId = temporaryList[temporaryList.length - 1];
        } else {
            lastRaceId = 0L;
        }
        return lastRaceId;
    }
}
