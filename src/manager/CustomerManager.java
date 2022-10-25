/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import entity.Customer;
import java.util.Scanner;

/**
 *
 * @author pupil
 */
public class CustomerManager {
     private final Scanner scanner;

    public CustomerManager() {
        scanner = new Scanner(System.in);
    }
    
    public Customer createCustomer() {
        Customer customer = new Customer();
        System.out.println("Введите имя покупателя: ");
        customer.setFirstName(scanner.nextLine());
        System.out.println("Введите фамилию покупателя: ");
        customer.setLastName(scanner.nextLine());
        System.out.println("Введите телефон покупателя: ");
        customer.setPhone(scanner.nextLine());
        System.out.println("Введите количество денег покупателя: ");
        customer.setCash(scanner.nextDouble());scanner.nextLine();
        
        return customer;
    }
    
    public void addMoney(Customer[] customers) {
        
        System.out.println("Список покупателей.");
        printListCustomer(customers);
        System.out.println("Введите номер покупателя из списка: ");
        int numberCustomer = scanner.nextInt(); scanner.nextLine();
        System.out.println("Введите сумму для добавления: ");
        double addM = scanner.nextDouble();scanner.nextLine();
        customers[numberCustomer-1].setCash(customers[numberCustomer-1].getCash() + addM);
        
    }
    
    public void printListCustomer(Customer[] customers) {
        for(int i  = 0; i < customers.length; i++) {
            System.out.printf("%d. Имя: %s Фамилия: %s Телефон: %s Наличные: %s%n"
                    ,(i+1)
                    ,customers[i].getFirstName()
                    ,customers[i].getLastName()
                    ,customers[i].getPhone()
                    ,customers[i].getCash()
                    
            );
        }
    }
     
}
