package com.horsetrack.dataprovider.inmemory;

import com.horsetrack.dataprovider.PayoutDataProvider;
import com.horsetrack.model.Payout;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import javax.inject.Named;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by sergii.shekenya on 14.06.2015.
 */
@Named
@Default
public class InMemoryPayoutDataProvider implements PayoutDataProvider {

    private Set<Payout> payouts;

    @PostConstruct
    private void init() {
        restock();
    }

    @Override
    public Payout findByDenomination(Payout.Denomination denomination) {
        for (Payout payout : payouts) {
            if (payout.getDenomination() == denomination) {
                return payout;
            }
        }
        return null;
    }

    @Override
    public void restock() {
        payouts = new TreeSet<Payout>();
        payouts.add(new Payout(Payout.Denomination.ONE));
        payouts.add(new Payout(Payout.Denomination.FIVE));
        payouts.add(new Payout(Payout.Denomination.TEN));
        payouts.add(new Payout(Payout.Denomination.TWENTY));
        payouts.add(new Payout(Payout.Denomination.ONE_HUNDRED));
    }
}
