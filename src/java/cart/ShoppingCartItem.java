/*
 * Copyright (c) 2010, Oracle and/or its affiliates. All rights reserved.
 *
 * You may not modify, use, reproduce, or distribute this software
 * except in compliance with the terms of the license at:
 * http://developer.sun.com/berkeley_license.html
 */

package cart;

import entity.Product;

/**
 *
 * @author juanluis
 */
public class ShoppingCartItem {
    
    Product currentProduct;
    int numElements;
    
    public ShoppingCartItem(Product product){
        this.currentProduct = product;
        int numElements = 1;
    }
    
    
    public Product getProduct(){

        return this.currentProduct;
    }
    
    
    public int getQuantity(){

        return this.numElements;
    }
    
    
    public void setQuantity(int quantity){

        this.numElements = quantity;
    }
    
    
    public double getTotal(){
        double result = this.numElements * this.currentProduct.getPrice();
        return  result;
              
    }
}