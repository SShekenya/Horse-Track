package com.horsetrack.dataprovider.inmemory;

import com.horsetrack.dataprovider.PrizeDataProvider;
import com.horsetrack.model.Prize;

import javax.enterprise.inject.Default;
import javax.inject.Named;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by sergii.shekenya on 6/16/2015.
 */

@Named
@Default
public class InMemoryPrizeDataProvider implements PrizeDataProvider {
    private Map<Long, Prize> prizes = new LinkedHashMap<Long, Prize>();

    @Override
    public Long persist(Prize prize) {
        if (prize.getId() != null) {
            if (prizes.containsKey(prize.getId())) {
                throw new IllegalArgumentException("The race with id " + prize.getId() + " is already exist");
            }
        } else {
            prize.setId(getNextRaceId());
        }

        prizes.put(prize.getId(), prize);
        return prize.getId();
    }

    @Override
    public Prize findById(Long id) {
        return prizes.get(id);
    }

    private Long getNextRaceId() {
        return getLastRaceId() + 1;
    }

    private Long getLastRaceId() {
        Long lastRaceId;
        if (!prizes.isEmpty()) {
            Long[] temporaryList = (Long[]) prizes.keySet().toArray();
            lastRaceId = temporaryList[temporaryList.length - 1];
        } else {
            lastRaceId = 0L;
        }
        return lastRaceId;
    }
}
