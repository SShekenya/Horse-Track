package com.horsetrack.dataprovider.inmemory;

import com.horsetrack.dataprovider.PayoutDataProvider;
import com.horsetrack.model.Payout;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import javax.inject.Named;

/**
 * Created by sergii.shekenya on 14.06.2015.
 */
@Named
@ApplicationScoped
@Default
public class InMemoryPayoutDataProvider implements PayoutDataProvider {
    @Override
    public Payout findByDenomination(Payout.Denomination denomination) {
        return null;
    }

    @Override
    public void restock() {

    }
}
