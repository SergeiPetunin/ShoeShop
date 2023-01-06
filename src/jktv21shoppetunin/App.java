/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jktv21shoppetunin;

import java.util.Scanner;
import entity.Customer;
import entity.Purchase;
import java.util.List;
import entity.Shoe;
import java.util.Arrays;
import manager.CustomerManager;
import manager.PurchaseManager;
import manager.ShoeManager;

import manager.DataManager;
import manager.BaseManager;
import manager.interfaces.SaveManagerInterface;

/**
 *
 * @author pupil
 */
public class App {
    public static boolean saveToBase;
    private final PurchaseManager pm;
    private final CustomerManager cm;
    private final ShoeManager sm;
    private final Scanner scanner;
//    private Shoe[] shoes;
//    private Customer[] customers;
//    private Purchase[] purchases;
//    private final DataManager dataManager;
    private final SaveManagerInterface saveManager;
    private List<Purchase>purchases;
    private List<Customer>customers;
    private List<Shoe>shoes;

    public App() {
        scanner = new Scanner(System.in);
        pm = new PurchaseManager();
        cm = new CustomerManager();
        sm = new ShoeManager();
//        dataManager = new DataManager();
        if(App.saveToBase){
            saveManager = new BaseManager();
        }else{
            saveManager = new DataManager();
        }
        
//        shoes = new Shoe[0];
//        customers = new Customer[0];
//        purchases = new Purchase[0];
        
//        purchases= dataManager.loadPurchases();
//        customers = dataManager.loadCustomers();
//        shoes = dataManager.loadShoes();
        customers = saveManager.loadCustomers();
        shoes = saveManager.loadShoes();
        purchases = saveManager.loadPurchases();
        
    }
    
    public void run(){
        
        boolean repeat = true;
        do{
            System.out.println("Функции приложения:");
            System.out.println("0. Выход из программы");
            System.out.println("1. Добавить обувь на склад" );
            System.out.println("2. Список обуви");
            System.out.println("3. Добавить покупателя");
            System.out.println("4. Список покупателей");
            System.out.println("5. Добавить покупку");
            System.out.println("6. Сколько денег заработал магазин");
            System.out.println("7. Добавить деньги на счёт покупателя");
            System.out.print("Выберите номер функцию:");
            int task = scanner.nextInt();
            scanner.nextLine();
            switch (task){
                case 0:
                    repeat = false;
                    break;
                case 1:
//                    addShoe(sm.createShoe());
//                    shoes.add(sm.createShoe());
//                    dataManager.saveShoes(shoes);
                    shoes.add(sm.createShoe());
                    saveManager.saveShoes(shoes);
                    break;
                case 2:
                    sm.printListShoes(shoes);
                    break;
                case 3:
//                    addCustomer(cm.createCustomer());
//                    customers.add(cm.createCustomer());
//                    dataManager.saveCustomers(customers);
                    customers.add(cm.createCustomer());
                    saveManager.saveCustomers(customers);
                    break;
                case 4:
                    cm.printListCustomer(customers);
                    break;
                case 5:
//                    addPurchase(pm.createPurchase(customers, shoes));
                    purchases.add(pm.createPurchase(customers, shoes));
//                    dataManager.savePurchases(purchases);
//                    dataManager.saveCustomers(customers);
//                    dataManager.saveShoes(shoes);
                    saveManager.savePurchases(purchases);
                    saveManager.saveCustomers(customers);
                    saveManager.saveShoes(shoes);
                    break;
                case 6:
//                    pm.PriceOfAllPurchase(purchases);
                    pm.PriceOfAllPurchase(purchases);
                    break;
                case 7:
                    cm.addMoney(customers);
//                    dataManager.saveCustomers(customers);
                    
                    saveManager.saveCustomers(customers);
                    break;

            }
        }while(repeat);
        System.out.println("Пока!");
    }
    
    
//    public void addShoe(Shoe shoe){
//        shoes = Arrays.copyOf(shoes, shoes.length + 1);
//        shoes[shoes.length - 1] = shoe;
//        
//    }
//    
//    public void addCustomer(Customer customer){
//        customers = Arrays.copyOf(customers, customers.length + 1);
//        customers[customers.length - 1] = customer;
//        
//    }
//    
//    public void addPurchase(Purchase purchase) {
//        purchases = Arrays.copyOf(purchases, purchases.length + 1);
//        purchases[purchases.length - 1] = purchase;
//    }
//    
//    private void testShoe() {
//        Shoe shoe = new Shoe();
//        shoe.setName("Boots 1");
//        shoe.setPrice(1500);
//        shoe.setCountItem(10);
//        addShoe(shoe);
//    }
//    private void testCustomer() {
//        Customer customer = new Customer();
//        customer.setFirstName("Alewa2");
//        customer.setLastName("Popovich");
//        customer.setPhone("4442141");
//        customer.setCash(5000);
//        
//        addCustomer(customer);
//    }
    
}
