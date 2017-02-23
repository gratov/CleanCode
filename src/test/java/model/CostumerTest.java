package model;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stijnli on 23/02/2017.
 */
public class CostumerTest {

    private Customer testCustomer;
    @Before
    public void setUp(){
        testCustomer = new Customer("aName");
    }

    @Test
    public void addCard_customerWithoutACard_ShouldBeAbleToAddANewCard(){

        LoyaltyCard testCard = new LoyaltyCard("123");
        testCustomer.addCard(testCard);
       Assertions.assertThat(testCustomer.getCard().getBarcode()).isEqualTo("123");
    }

    @Test
    public void addCard_customerWithACard_ShouldNotOverrideHisExistingCard(){
        LoyaltyCard presentCard = new LoyaltyCard("999");
        LoyaltyCard testCard = new LoyaltyCard("123");
        testCustomer.addCard(presentCard);
        testCustomer.addCard(testCard);
        Assertions.assertThat(testCustomer.getCard().getBarcode()).isEqualTo("999");
    }

    @Test
    public void boughtOnce_whenProductsAreBought_ShouldOnlyReturnThoseBoughtOnce(){
        Grocery grocery1 = new Grocery("test1");
        Grocery grocery2 = new Grocery("test2");
        Grocery grocery3 = new Grocery("test3");


        testCustomer.addGrocery(grocery1);
        testCustomer.addGrocery(grocery2);
        testCustomer.addGrocery(grocery3);

        Assertions.assertThat(testCustomer.boughtOnce()).contains(grocery1,grocery2,grocery3 );
    }

    @Test
    public void boughtOnce_oneProductBoughtTwiceAndOnceProductBoughtOnce_ShouldOnlyReturnOneProductBoughtOnce(){
        Grocery grocery1 = new Grocery("test1");
        Grocery grocery2 = new Grocery("test2");

        testCustomer.addGrocery(grocery1);
        testCustomer.addGrocery(grocery1);
        testCustomer.addGrocery(grocery2);

        Assertions.assertThat(testCustomer.boughtOnce()).contains(grocery2);
    }

    @Test
    public void boughtOnce_noProductsAreBoughtOnlyOnce_ShouldOnlyReturnEmptyList(){
        Grocery grocery1 = new Grocery("test1");
        Grocery grocery2 = new Grocery("test2");

        testCustomer.addGrocery(grocery1);
        testCustomer.addGrocery(grocery1);
        testCustomer.addGrocery(grocery2);
        testCustomer.addGrocery(grocery2);

        Assertions.assertThat(testCustomer.boughtOnce()).isEmpty();
    }

    @Test
    public void getMostBought_oneProductBoughtTwiceAndOnceProductBoughtOnce_ShouldOnlyReturnTheProductBoughtTwice(){
        Grocery grocery1 = new Grocery("test1");
        Grocery grocery2 = new Grocery("test2");

        testCustomer.addGrocery(grocery1);
        testCustomer.addGrocery(grocery1);
        testCustomer.addGrocery(grocery2);

        Assertions.assertThat(testCustomer.getMostBought()).isEqualTo(grocery1);
    }
    @Test
    public void getMostBought_twoProductsBoughtAnEqualAmountOfTimes_ShouldReturnBothItems(){
        Grocery grocery1 = new Grocery("test1");
        Grocery grocery2 = new Grocery("test2");

        testCustomer.addGrocery(grocery1);
        testCustomer.addGrocery(grocery2);

        Assertions.assertThat(testCustomer.getMostBought()).contains(grocery1,grocery2);
    }
//    @Test
//    public void getMostBought_oneProductBoughtTwiceAndOnceProductBoughtOnce_ShouldOnlyReturnTheProductBoughtTwice(){
//        Grocery grocery1 = new Grocery("test1");
//        Grocery grocery2 = new Grocery("test2");
//
//        testCustomer.addGrocery(grocery1);
//        testCustomer.addGrocery(grocery1);
//        testCustomer.addGrocery(grocery2);
//
//        Assertions.assertThat(testCustomer.getMostBought()).isEqualTo(grocery1);
//    }
}
