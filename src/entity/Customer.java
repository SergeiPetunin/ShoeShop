/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author pupil
 */
public class Customer {
    
    private String firstName;
    private String lastName;
    private String phone;
    private double cash;

    public Customer() {
    }

    public Customer(String firstName, String lastName, String phone, double cash) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.cash = cash;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }

    @Override
    public String toString() {
        return "Customer{" 
                + ", firstName=" + firstName 
                + ", lastName=" + lastName 
                + ", phone=" + phone 
                + ", cash=" + cash 
                + '}';
    }

    
    
    
}
