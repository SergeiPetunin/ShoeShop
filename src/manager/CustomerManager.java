/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import entity.Customer;
import java.util.List;
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
        System.out.println("Введите номер телефона: ");
        customer.setPhone(scanner.nextLine());
        System.out.println("Ведите количество денег покупателя: ");
        customer.setCash(scanner.nextFloat());scanner.nextLine();
        
        return customer;
    }
    
    public void addMoney(List<Customer> customers) {
        
        System.out.println("Список покупателей.");
        printListCustomer(customers);
        System.out.println("Введите номер покупателя: ");
        int numberCustomer = scanner.nextInt(); scanner.nextLine();
        System.out.printf("У покупателя %s eur%n",customers.get(numberCustomer - 1).getCash());
        System.out.println("Введите сумму: ");
        double addM = scanner.nextDouble();scanner.nextLine();
//        customers[numberCustomer-1].setCash(customers[numberCustomer-1].getCash() + addM);
        customers.get(numberCustomer - 1).setCash(customers.get(numberCustomer - 1).getCash() + addM);
        
    }
    
//    public void printListCustomer(Customer[] customers) {
//        for(int i  = 0; i < customers.length; i++) { 
    public void printListCustomer(List<Customer> customers) {
        for (int i = 0; i < customers.size(); i++) {
            System.out.printf("%d. Имя: %s Фамилия: %s Телефон: %s Деньги: %s%n",
                    (i+1),
//                    ,customers[i].getFirstName()
//                    ,customers[i].getLastName()
//                    ,customers[i].getPhone()
//                    ,customers[i].getCash()
                    customers.get(i).getFirstName(),
                    customers.get(i).getLastName(),
                    customers.get(i).getPhone(),
                    customers.get(i).getCash()
            );
        }
    }
     
}
