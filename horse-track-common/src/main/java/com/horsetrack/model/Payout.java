package com.horsetrack.model;

/**
 * Created by sergii.shekenya on 14.06.2015.
 */
public class Payout implements Comparable<Payout> {
    private Denomination denomination;
    private Integer inventory = 10;

    public Payout(Denomination denomination) {
        this.denomination = denomination;
    }

    public Denomination getDenomination() {
        return denomination;
    }

    public void setDenomination(Denomination denomination) {
        this.denomination = denomination;
    }

    public Integer getInventory() {
        return inventory;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }

    public void decreaseInventory() {
        inventory--;
    }

    @Override
    public int compareTo(Payout o) {
        return denomination.compareTo(o.denomination);
    }

    public static enum Denomination {
        ONE(1),
        FIVE(5),
        TEN(10),
        TWENTY(20),
        ONE_HUNDRED(100);

        Denomination(Integer value) {
            this.value = value;
        }

        private Integer value;
    }
}