/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import javax.persistence.EntityManager;
import javax.transaction.UserTransaction;
import entity.Product;

/**
 *
 * @author juanluis
 */
public class ProductModel {

    UserTransaction utx;
    EntityManager em;

    public ProductModel(EntityManager em, UserTransaction utx) {
        this.utx = utx;
        this.em = em;
    }
    public List<Product> retrieveAll(){
        Query q = em.createQuery("select o from Product as o");
        return q.getResultList();
    }
    public List<Product> retrieveByCategory(Category category){
        Query q = em.createQuery("select o from Product as o where o.category=:category");
        q.setParameter("category",category);
        return q.getResultList();

    public Product retrieve(int product_id) {

        return em.find (Product.class, product_id);
    }

}
