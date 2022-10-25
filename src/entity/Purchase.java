/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Date;

/**
 *
 * @author pupil
 */
public class Purchase {
    
    private Customer customer;
    private Shoe shoe;
    private int Qtty;
    private Date purchaseDate;

    public Purchase() {
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Shoe getShoe() {
        return shoe;
    }

    public void setShoe(Shoe shoe) {
        this.shoe = shoe;
    }

    public int getQtty() {
        return Qtty;
    }

    public void setQtty(int Qtty) {
        this.Qtty = Qtty;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    @Override
    public String toString() {
        return "Purchase{" 
                + "customer=" + customer 
                + ", shoe=" + shoe 
                + ", Qtty=" + Qtty 
                + ", purchaseDate=" + purchaseDate 
                + '}';
    }

    
    
}
