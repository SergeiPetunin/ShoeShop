/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import entity.Customer;
import entity.Purchase;
import entity.Shoe;
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
    
    public Purchase createPurchase(Customer[] customers, Shoe[] shoes) {
        Purchase purchase = new Purchase();
        
        System.out.println("������ �����������.");
        customerManager.printListCustomer(customers);
        System.out.println("������� ����� ���������� �� ������: ");
        int numberCustomer = scanner.nextInt(); scanner.nextLine();
        
        System.out.println("������ �����.");
        shoeManager.printListShoes(shoes);
        System.out.println("������� ����� ����� �� ������: ");
        int numberShoe = scanner.nextInt(); scanner.nextLine();
        
        System.out.println("������� ����������");
        int itemQtty = scanner.nextInt(); scanner.nextLine();
        
        purchase.setCustomer(customers[numberCustomer-1]);
        purchase.setShoe(shoes[numberShoe-1]);
        purchase.setQtty(itemQtty);
        purchase.setPurchaseDate(new GregorianCalendar().getTime());
        shoes[numberShoe-1].setCountItem(shoes[numberShoe-1].getCountItem()-itemQtty);
        customers[numberCustomer - 1].setCash(customers[numberCustomer -1].getCash() - itemQtty * shoes[numberShoe - 1].getPrice());
        
        return purchase;
    }
    
    public void PriceOfAllPurchase(Purchase[] purchases) {
        double shopMoney = 0;
        for(int i = 0; i < purchases.length; i++) {
            shopMoney += purchases[i].getQtty() * purchases[i].getShoe().getPrice();
        }
        System.out.println("����� �������� �� ��� ����� ������" + shopMoney);
    }
    
    public void printHistoryPurchase(Purchase[] purchases) {
        for(int i  = 0; i < purchases.length; i++) {
            Purchase purchase = purchases[i];
            System.out.printf("%d. ����������: %s. �����: %s ����������:  %s  ���� �������: %s%n"
                ,i + 1
                ,purchase.getCustomer()
                ,purchase.getShoe()
                ,purchase.getQtty()
                ,purchase.getPurchaseDate()
            );
        }
    }  
}
