package com.horsetrack.dataprovider;

import com.horsetrack.model.Horse;

import java.util.Set;

/**
 * Created by sergii.shekenya on 14.06.2015.
 */
public interface HorseDataProvider {
    void persist(Horse horse);

    void update(Horse horse);

    void delete(Horse horse);

    Horse findById(Long id);

    Set<Horse> findAll();
}
