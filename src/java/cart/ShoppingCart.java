package cart;

import entity.Product;
import java.text.NumberFormat;
import java.util.*;

/**
 *
 * @author juanluis
 */
public class ShoppingCart {
    //Global vatiable for the cart
    int numItems;
    //Set of current items of the cart
    List<ShoppingCartItem> shoppingCart;

    public ShoppingCart(){
        //Only variables initialization by now
        int numItems = 0;
        shoppingCart = new ArrayList();
    }
    public synchronized void addItem(Product product){
        // checks if item is not included
        boolean already_in = false;

        for (ShoppingCartItem shopItems : ShoppingList) {
            if (shopItems.getProduct().getId().equals(product.getId())) {
                already_in = true;
                shopItems.incrementQuantity();
            }
        }

        if (!already_in) {
            ShoppingCartItem shopItems = new ShoppingCartItem(product);
            ShoppingList.add(shopItems);

        }
        NumberOfItems++;
    }
    
    
    public synchronized void update(Product product, String quantity){
        int actualQuantity = Integer.parseInt(quantity);
        
        System.out.print("askdhfl");
        for(ShoppingCartItem thisItem : this.shoppingCart){
           if (thisItem.getProduct().getId() == product.getId()){
               int prevQ = thisItem.getQuantity();
               thisItem.setQuantity(actualQuantity);
               this.numItems = this.numItems + (actualQuantity-prevQ);
               if(thisItem.getQuantity() == 0){
                   this.shoppingCart.remove(thisItem);
               }
               return;
           }
       }
    }
    
    
    public synchronized List<ShoppingCartItem> getItems(){

        return this.shoppingCart;
    }
    
    
    public synchronized int getNumberOfItems(){

        return this.numItems;
    }


    public synchronized double getTotal() {

        double totalToPay = 0;

        for (int i = 0; i < this.shoppingCart.size(); i++) {
            totalToPay += this.shoppingCart.get(i).getTotal();
        }

        return totalToPay;
    }

    public synchronized void removeItemFromCart(ShoppingCartItem item) {

        this.ShoppingList.remove(item);
    }

    public synchronized void clear(){
        this.shoppingCart = new ArrayList();
        this.numItems = 0;
    }
}