/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import entity.Customer;
import entity.Purchase;
import entity.Shoe;
import java.util.Arrays;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 *
 * @author pupil
 */
public class PurchaseManager {
    private final ShoeManager shoeManager;
    private final CustomerManager customerManager;
    private final Scanner scanner;

    public PurchaseManager() {
        shoeManager = new ShoeManager();
        customerManager = new CustomerManager();
        scanner = new Scanner(System.in);
    }
    
    public Purchase createPurchase(List<Customer> customers, List<Shoe> shoes) {
        Purchase purchase = new Purchase();
        
        System.out.println("Список покупателелей.");
        customerManager.printListCustomer(customers);
        System.out.println("Выберете номер из списка: ");
        int numberCustomer = scanner.nextInt(); scanner.nextLine();
        
        System.out.println("Список обуви.");
        shoeManager.printListShoes(shoes);
        System.out.println("Выберете номер из списка: ");
        int numberShoe = scanner.nextInt(); scanner.nextLine();
        
        System.out.println("Введите количество");
        int itemQtty = scanner.nextInt(); scanner.nextLine();
        
//        purchase.setCustomer(customers[numberCustomer-1]);
        purchase.setCustomer(customers.get(numberCustomer - 1));
//        purchase.setShoe(shoes[numberShoe-1]);
        purchase.setShoe(shoes.get(numberShoe - 1));
        purchase.setQtty(itemQtty);
        purchase.setPurchaseDate(new GregorianCalendar().getTime());
//        shoes[numberShoe-1].setCountItem(shoes[numberShoe-1].getCountItem()-itemQtty);
        shoes.get(numberShoe - 1).setCountItem(shoes.get(numberShoe - 1).getCountItem() - itemQtty);
//        customers[numberCustomer - 1].setCash(customers[numberCustomer -1].getCash() - itemQtty * shoes[numberShoe - 1].getPrice());
        customers.get(numberCustomer - 1).setCash(customers.get(numberCustomer - 1).getCash() - itemQtty * shoes.get(numberShoe - 1).getPrice());
        
        return purchase;
    }
    
    public void PriceOfAllPurchase(List<Purchase>purchases) {
        double shopMoney = 0;
        for(int i = 0; i < purchases.size(); i++) {
            shopMoney += purchases.get(i).getQtty() * purchases.get(i).getShoe().getPrice();
        }
        System.out.println("Всего заработано" + shopMoney);
    }
    
    public void printHistoryPurchase(Purchase[] purchases) {
        for(int i  = 0; i < purchases.length; i++) {
            Purchase purchase = purchases[i];
            System.out.printf("%d. Покупатель: %s. Товар: %s Количество:  %s  Дата покупки: %s%n"
                ,i + 1
                ,purchase.getCustomer()
                ,purchase.getShoe()
                ,purchase.getQtty()
                ,purchase.getPurchaseDate()
            );
        }
    }  
}
