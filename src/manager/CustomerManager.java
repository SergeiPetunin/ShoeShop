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
        System.out.println("������� ��� ����������: ");
        customer.setFirstName(scanner.nextLine());
        System.out.println("������� ������� ����������: ");
        customer.setLastName(scanner.nextLine());
        System.out.println("������� ������� ����������: ");
        customer.setPhone(scanner.nextLine());
        System.out.println("������� ���������� ����� ����������: ");
        customer.setCash(scanner.nextDouble());scanner.nextLine();
        
        return customer;
    }
    
    public void addMoney(Customer[] customers) {
        
        System.out.println("������ �����������.");
        printListCustomer(customers);
        System.out.println("������� ����� ���������� �� ������: ");
        int numberCustomer = scanner.nextInt(); scanner.nextLine();
        System.out.println("������� ����� ��� ����������: ");
        double addM = scanner.nextDouble();scanner.nextLine();
        customers[numberCustomer-1].setCash(customers[numberCustomer-1].getCash() + addM);
        
    }
    
    public void printListCustomer(Customer[] customers) {
        for(int i  = 0; i < customers.length; i++) {
            System.out.printf("%d. ���: %s �������: %s �������: %s ��������: %s%n"
                    ,(i+1)
                    ,customers[i].getFirstName()
                    ,customers[i].getLastName()
                    ,customers[i].getPhone()
                    ,customers[i].getCash()
                    
            );
        }
    }
     
}
