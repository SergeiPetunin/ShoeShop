/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import entity.Shoe;
import java.util.List;
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
        System.out.println("Введите название обуви: ");
        shoe.setName(scanner.nextLine());
        System.out.println("Введите цену: ");
        shoe.setPrice(scanner.nextDouble());scanner.nextLine();
        System.out.println("Введите количество: ");
        shoe.setCountItem(scanner.nextInt());scanner.nextLine();
        
        return shoe;
    }
    
    public void printListShoes(List<Shoe> shoes) {
        for(int i  = 0; i < shoes.size(); i++) {
            System.out.printf("%d. Название: %s Цена: %s Количество: %s%n"
                    ,(i+1)
                    ,shoes.get(i).getName()
                    ,shoes.get(i).getPrice()
                    ,shoes.get(i).getCountItem()
                    
            );
        }
    }


    
}
