package model;

import java.util.UUID;

/**
 * Created by stijnli on 23/02/2017.
 */
public class Costumer {
    private UUID id;
    private String name;
    private LoyaltyCard card;

    public Costumer(){
        id = UUID.randomUUID();
    }
    public Costumer(String name){
        id = UUID.randomUUID();
        this.name = name;
    }
    public LoyaltyCard getCard(){
        return card;
    }


}

