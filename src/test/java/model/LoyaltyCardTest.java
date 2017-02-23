package model;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by stijnli on 23/02/2017.
 */
public class LoyaltyCardTest {
    @Test
    public void getBarcode_ReturnsBarcode() throws Exception {
        LoyaltyCard card = new LoyaltyCard("123456789");
        Assert.assertEquals("123456789",card.getBarcode());

    }

}