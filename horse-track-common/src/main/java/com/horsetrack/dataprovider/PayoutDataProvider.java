package com.horsetrack.dataprovider;

import com.horsetrack.model.Payout;

/**
 * Created by sergii.shekenya on 14.06.2015.
 */
public interface PayoutDataProvider {
    Payout findByDenomination(Payout.Denomination denomination);

    void restock();
}
