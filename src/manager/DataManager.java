/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import entity.Customer;
import entity.Purchase;
import entity.Shoe;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import manager.interfaces.SaveManagerInterface;

/**
 *
 * @author spetu
 */
public class DataManager implements SaveManagerInterface{
    
    private final String FILENAME_CUSTOMERS = "files/MyCustomers";
    private final String FILENAME_PRODUCTS = "files/MyProducts";
    private final String FILENAME_PURCHASES = "files/MyPurchases";
    private final File file;
    
    public DataManager() {
        file = new File("files");
        file.mkdirs();
    }
    
    @Override
    public List<Purchase> loadPurchases() {
        List<Purchase>  purchases = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(FILENAME_PURCHASES);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            purchases = (List<Purchase>) objectInputStream.readObject();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, "Нет такого файла", ex);
        } catch (IOException ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, "Ошибка ввода/вывода", ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, "Нет такого класса", ex);
        }
        return purchases;
    }
    
    @Override
    public List<Customer> loadCustomers() {
        List<Customer>  customers = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(FILENAME_CUSTOMERS);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            customers = (List<Customer>) objectInputStream.readObject();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, "Нет такого файла", ex);
        } catch (IOException ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, "Ошибка ввода/вывода", ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, "Нет такого класса", ex);
        }
        return customers;
    }
    
    @Override
    public List<Shoe> loadShoes() {
        List<Shoe> shoes = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(FILENAME_PRODUCTS);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            shoes = (List<Shoe>) objectInputStream.readObject();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, "Нет такого файла", ex);
        } catch (IOException ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, "Ошибка ввода/вывода", ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, "Нет такого класса", ex);
        }
        return shoes;
    }
    
    @Override
    public void saveShoes(List<Shoe> shoes) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(FILENAME_PRODUCTS);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(shoes);
            objectOutputStream.flush();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, "Нет такого файла", ex);
        } catch (IOException ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, "Ошибка ввода / вывода", ex);
        }
    }
    
    @Override
    public void saveCustomers(List<Customer> customers) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(FILENAME_CUSTOMERS);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(customers);
            objectOutputStream.flush();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, "Нет такого файла", ex);
        } catch (IOException ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, "Ошибка ввода / вывода", ex);
        }
    }
    
    @Override
    public void savePurchases(List<Purchase> purchases) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(FILENAME_PURCHASES);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(purchases);
            objectOutputStream.flush();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, "Нет такого файла", ex);
        } catch (IOException ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, "Ошибка ввода / вывода", ex);
        }
    }
    
}
