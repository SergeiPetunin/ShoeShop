/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import entity.Shoe;
import java.util.Scanner;

/**
 *
 * @author pupil
 */
public class ShoeManager {
    private final Scanner scanner;
    
    public ShoeManager() {
        scanner = new Scanner(System.in);
    }
    
    public Shoe createShoe() {
        Shoe shoe = new Shoe();
        System.out.println("������� �������� ��������: ");
        shoe.setName(scanner.nextLine());
        System.out.println("������� ����: ");
        shoe.setPrice(scanner.nextDouble());scanner.nextLine();
        System.out.println("������� ����������: ");
        shoe.setCountItem(scanner.nextInt());scanner.nextLine();
        
        return shoe;
    }
    
    public void printListShoes(Shoe[] shoes) {
        for(int i  = 0; i < shoes.length; i++) {
            System.out.printf("%d. �����: %s ����: %s ����������: %s%n"
                    ,(i+1)
                    ,shoes[i].getName()
                    ,shoes[i].getPrice()
                    ,shoes[i].getCountItem()
                    
            );
        }
    }
    
}
