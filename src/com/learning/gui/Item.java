
package com.learning.gui;
/**
 *
 * @author Samah Mahdi (samah.mahdi.hassan@gmail.com)
 */

public class Item {
    
    public static int nextItemId = 0;
    private int itemId;
    private String name;
    private double price;
    private int quantity;
    private static int id;
    
    // Constructors
    public Item() {
        this.itemId = nextItemId++;
        this.name = "";
        this.price = 0.0;
        this.quantity = 0;
        id ++;
    }

    public Item(String name, double price, int quanity) {
        this.itemId = nextItemId++;
        this.name = name;
        this.price = price;
        this.quantity = quanity; 
        id ++;
    }

    // Accessor methods

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        if(price >= 0)
            this.price = price;
    }

    public void setQuantity(int quantity) {
        if(quantity>= 0)
            this.quantity = quantity;
    }    

    // Mutator methods
    public int getItemId() {
        return this.itemId;
    } 

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public boolean checkItemsAvailability(long requestedQuantity) {
        return this.quantity >= requestedQuantity;
    }

    @Override
    public String toString() {
        return "Item id: " + this.itemId +
               ", Item Name: " + this.name +
               ", Item Price: " + this.price +
               ", Item Quantity: " + this.quantity;
    }
}

