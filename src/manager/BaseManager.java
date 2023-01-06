/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import entity.Customer;
import entity.Shoe;
import entity.Purchase;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import manager.interfaces.SaveManagerInterface;

/**
 *
 * @author spetu
 */
public class BaseManager implements SaveManagerInterface{
    private EntityManagerFactory emf;
    private EntityManager em;

    public BaseManager() {
        emf = Persistence.createEntityManagerFactory("ShoeShopPU");
        em = emf.createEntityManager();
    }
    
    @Override
   public void saveCustomers(List<Customer> customers) {
       em.getTransaction().begin();
       for (int i = 0; i < customers.size(); i++) {
           Customer customer = customers.get(i);
           if(customer.getId() == null){
                em.persist(customer);
            }else{
                em.merge(customer);
            }
       }
       em.getTransaction().commit();
   }
   
    @Override
   public List<Customer> loadCustomers() {
       return em.createQuery("SELECT c FROM Customer c").getResultList();
   }

    @Override
   public void saveShoes(List<Shoe> shoes) {
       em.getTransaction().begin();
       for (int i = 0; i < shoes.size(); i++) {
           Shoe shoe = shoes.get(i);
           if(shoe.getId() == null){
                em.persist(shoe);
            }else{
                em.merge(shoe);
            }
       }
       em.getTransaction().commit();
   }
   
    @Override
   public List<Shoe> loadShoes() {
       return em.createQuery("SELECT sh FROM Shoe sh").getResultList();
   }
   
   @Override
   public void savePurchases(List<Purchase> purchases) {
        em.getTransaction().begin();
       for (int i = 0; i < purchases.size(); i++) {
           Purchase purchase = purchases.get(i);
           if(purchase.getId() == null){
                em.persist(purchase);
            }else{
                em.merge(purchase);
            }
       }
       em.getTransaction().commit();
   }

    @Override
   public List<Purchase> loadPurchases() {
       return em.createQuery("SELECT pu FROM Purchase pu").getResultList();
   }
}
