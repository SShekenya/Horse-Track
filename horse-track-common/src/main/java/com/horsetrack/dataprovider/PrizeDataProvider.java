package com.horsetrack.dataprovider;

import com.horsetrack.model.Prize;

/**
 * Created by sergii.shekenya on 6/16/2015.
 */
public interface PrizeDataProvider {
    Long persist(Prize prize);

    Prize findById(Long id);

}
