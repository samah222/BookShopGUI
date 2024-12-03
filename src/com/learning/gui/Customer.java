
package com.learning.gui;

/**
 *
 * @author Samah Mahdi (samah.mahdi.hassan@gmail.com)
 */

public class Customer {
    
    private int customerId;
    private String name;
    private String phone;

    private int loyaltyPoints;
    
    //constructors      
    public Customer() {
        this.customerId = 0;
        this.name = "";
        this.loyaltyPoints = 0;
        this.phone = "";
    }
       
    public Customer(int customerId, String name, int loyaltyPoints, String phone) {
        this.customerId = customerId;
        this.name = name;
        this.loyaltyPoints = loyaltyPoints;
        this.phone = phone;
    }

    // Mutator methods
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public void setLoyaltyPoints(int loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }

    // Accessor methods
    public int getCustomerId() {
        return this.customerId;
    }

    public String getName() {
        return this.name;
    }

    public int getLoyaltyPoints() {
        return this.loyaltyPoints;
    }

     public String getPhone() {
        return phone;
    }
     
    @Override
    public String toString() {
        return "Customer ID: " + this.customerId +
               ", Name: " + this.name +
                "Phone:  " + this.phone +
               ", Loyalty Points: " + this.loyaltyPoints;
    }
}

