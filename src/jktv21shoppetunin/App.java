/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jktv21shoppetunin;

import entity.Customer;
import entity.Purchase;
import java.util.Scanner;
import entity.Shoe;
import java.util.Arrays;
import manager.CustomerManager;
import manager.PurchaseManager;
import manager.ShoeManager;

/**
 *
 * @author pupil
 */
public class App {
    private final PurchaseManager pm;
    private final CustomerManager cm;
    private final ShoeManager sm;
    private final Scanner scanner;
    private Shoe[] shoes;
    private Customer[] customers;
    private Purchase[] purchases;

    public App() {
        scanner = new Scanner(System.in);
        pm = new PurchaseManager();
        cm = new CustomerManager();
        sm = new ShoeManager();
        shoes = new Shoe[0];
        customers = new Customer[0];
        purchases = new Purchase[0];
        
        testShoe();
        testCustomer();
    }
    
    public void run(){
        
        boolean repeat = true;
        do{
            System.out.println("������� ����������:");
            System.out.println("0. ����� �� ���������");
            System.out.println("1. �������� �������" );
            System.out.println("2. ������ ����������� ���������");
            System.out.println("3. �������� ����������");
            System.out.println("4. ������ ������������������ �����������");
            System.out.println("5. ������� ����������� ��������");
            System.out.println("6. ����� �������� �� ��� ����� ������");
            System.out.println("7. �������� ����� ����������");
            System.out.print("�������� �������:");
            int task = scanner.nextInt();
            scanner.nextLine();
            switch (task){
                case 0:
                    repeat = false;
                    break;
                case 1:
                    addShoe(sm.createShoe());
                    break;
                case 2:
                    sm.printListShoes(shoes);
                    break;
                case 3:
                    addCustomer(cm.createCustomer());
                    break;
                case 4:
                    cm.printListCustomer(customers);
                    break;
                case 5:
                    addPurchase(pm.createPurchase(customers, shoes));
                    break;
                case 6:
                    pm.PriceOfAllPurchase(purchases);
                    break;
                case 7:
                    cm.addMoney(customers);
                    break;

            }
        }while(repeat);
        System.out.println("����!");
    }
    
    
    public void addShoe(Shoe shoe){
        shoes = Arrays.copyOf(shoes, shoes.length + 1);
        shoes[shoes.length - 1] = shoe;
        
    }
    
    public void addCustomer(Customer customer){
        customers = Arrays.copyOf(customers, customers.length + 1);
        customers[customers.length - 1] = customer;
        
    }
    
    public void addPurchase(Purchase purchase) {
        purchases = Arrays.copyOf(purchases, purchases.length + 1);
        purchases[purchases.length - 1] = purchase;
    }
    
    private void testShoe() {
        Shoe shoe = new Shoe();
        shoe.setName("������");
        shoe.setPrice(1500);
        shoe.setCountItem(10);
        addShoe(shoe);
    }
    private void testCustomer() {
        Customer customer = new Customer();
        customer.setFirstName("Alewa");
        customer.setLastName("Popovich");
        customer.setPhone("4442141");
        customer.setCash(5000);
        
        addCustomer(customer);
    }
    
}
