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
    private HashMap<Grocery, Integer> groceriesBought = new HashMap<>();

    public Customer() {
        id = UUID.randomUUID();
    }

    public Customer(String name) {
        id = UUID.randomUUID();
        this.name = name;
    }

    public LoyaltyCard getCard() {
        return card;
    }

    public Grocery getMostBought() {
        Grocery mostBought = null;
        int maxAmountBought = 0;
        for (Grocery grocery : groceriesBought.keySet()) {
            if (groceriesBought.get(grocery) > maxAmountBought) {
                maxAmountBought = groceriesBought.get(grocery);
                mostBought = grocery;
            }
        }
        return mostBought;
    }

    public List<Grocery> boughtOnce() {
        List<Grocery> boughtOnce = new ArrayList<>();
        for (Grocery grocery : groceriesBought.keySet()) {
            if (groceriesBought.get(grocery) == 1) {
                boughtOnce.add(grocery);
            }
        }
        return boughtOnce;
    }

    public void addGrocery(Grocery grocery) {
        if (groceriesBought.containsKey(grocery)) {
            groceriesBought.put(grocery, groceriesBought.get(grocery) + 1);
        } else {
            groceriesBought.put(grocery,1);
        }
    }

}

