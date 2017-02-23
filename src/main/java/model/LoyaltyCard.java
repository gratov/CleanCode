package model;

import java.util.UUID;

/**
 * Created by stijnli on 23/02/2017.
 */
public class LoyaltyCard {
    private String barcode;
    private int bonusPoints;

    public LoyaltyCard(){
        bonusPoints = 0;
        barcode = UUID.randomUUID().toString();
    }

    public LoyaltyCard(String barcode) {
        this.barcode = barcode;
    }

    public String getBarcode(){
        return  barcode;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LoyaltyCard that = (LoyaltyCard) o;

        return barcode.equals(that.barcode);
    }

    @Override
    public int hashCode() {
        return barcode.hashCode();
    }
}
