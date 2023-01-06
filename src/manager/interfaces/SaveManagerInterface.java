/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.interfaces;

import entity.Customer;
import entity.Shoe;
import entity.Purchase;
import java.util.List;

/**
 *
 * @author spetu
 */
public interface SaveManagerInterface {
    
    public void saveCustomers(List<Customer> customers);
    public List<Customer> loadCustomers();
    
    
    public void saveShoes(List<Shoe> products);
    public List<Shoe> loadShoes();
    
    
    public void savePurchases(List<Purchase> purchases);
    public List<Purchase> loadPurchases();
}
