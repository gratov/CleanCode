package model;

import java.util.List;
import java.util.UUID;

/**
 * Created by stijnli on 23/02/2017.
 */
public class CostumerRepo {
    private List<Costumer> costumers;

    public  void addCostumer(Costumer costumer){
        costumers.add(costumer);
    }

    public Iterable<Costumer> getAllCostumers(){
        return costumers;
    }

    public Costumer findByBarcode(String barcode){
        for (Costumer costumer:costumers) {
            if(costumer.getCard().getBarcode().equals(barcode)){
                return costumer;
            }
        }
        return null;
    }

}
