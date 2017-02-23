package model;

import java.util.List;

/**
 * Created by stijnli on 23/02/2017.
 */
public class CustomerRepo {
    private List<Customer> customers;

    public  void addCustomer (Customer costumer){
        customers.add(costumer);
    }

    public Iterable<Customer> getAllCostumers(){
        return customers;
    }

    public Customer findByBarcode(String barcode){
        for (Customer costumer: customers) {
            if(costumer.getCard().getBarcode().equals(barcode)){
                return costumer;
            }
        }
        return null;
    }

}
