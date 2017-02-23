package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/**
 * Created by stijnli on 23/02/2017.
 */
public class Customer {
    private UUID id;
    private String name;
    private LoyaltyCard card;
    private HashMap<Groceries, Integer> groceriesBought;

    public Customer(){
        id = UUID.randomUUID();
    }
    public Customer(String name){
        id = UUID.randomUUID();
        this.name = name;
    }
    public LoyaltyCard getCard(){
        return card;
    }

    public Groceries getMostBought(){
        Groceries mostBought=null;
        int amountBought=0;
        for (Groceries grocery : groceriesBought.keySet()){
            if(groceriesBought.get(grocery) > amountBought){
                amountBought = groceriesBought.get(grocery);
                mostBought=grocery;
            }
        }
        return mostBought;
    }

    public List<Groceries>  boughtOnce(){
        List<Groceries> boughtOnce = new ArrayList<>();
        for (Groceries grocery : groceriesBought.keySet()){
            if(groceriesBought.get(grocery) == 1){
                boughtOnce.add(grocery);
            }
        }
        return boughtOnce;
    }

}

