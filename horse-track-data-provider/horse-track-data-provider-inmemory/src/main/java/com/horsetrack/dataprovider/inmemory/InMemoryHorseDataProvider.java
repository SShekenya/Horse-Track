package com.horsetrack.dataprovider.inmemory;

import com.horsetrack.dataprovider.HorseDataProvider;
import com.horsetrack.dataprovider.util.InMemoryDataUploadUtils;
import com.horsetrack.model.Horse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Default;
import javax.inject.Named;
import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by sergii.shekenya on 14.06.2015.
 */

@Named
@Default
public class InMemoryHorseDataProvider implements HorseDataProvider {
    private static final Logger LOGGER = LoggerFactory.getLogger(InMemoryHorseDataProvider.class);
    private Map<Long, Horse> horses = new TreeMap<Long, Horse>();

    @PostConstruct
    private void init() {
        try {
            horses = InMemoryDataUploadUtils.uploadEntryHorses();
        } catch (IOException e) {
            LOGGER.error("", e);
        }
    }

    @Override
    public void persist(Horse horse) {
        if (horse.getId() != null && horses.containsKey(horse.getId())) {
            throw new IllegalArgumentException("Horse with id " + horse.getId() +
                    "already exist");
        }

        horse.setId(((TreeMap<Long, Horse>) horses).lastKey() + 1);
        horses.put(horse.getId(), horse);
    }

    @Override
    public void update(Horse horse) {
        if (!horses.containsKey(horse.getId())) {
            throw new IllegalArgumentException("There is no horse with id: " + horse.getId());
        }

        horses.put(horse.getId(), horse);
    }

    @Override
    public void delete(Horse horse) {
        horses.remove(horse.getId());
    }

    @Override
    public Horse findById(Long id) {
        return horses.get(id);
    }

    @Override
    public Set<Horse> findAll() {
        return new HashSet<Horse>(horses.values());
    }
}
