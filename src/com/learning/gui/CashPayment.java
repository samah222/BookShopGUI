
package com.learning.gui;
/**
 *
 * @author Samah Mahdi (samah.mahdi.hassan@gmail.com)
 */

public class CashPayment extends Payment {
    // Attributes specific to CashPayment
    private double cashReceived;
    private double change;

    //  constructors
    public CashPayment() {
        super();  // Calls the Payment default constructor
        this.cashReceived = 0.0;
        this.change = 0.0;
    }
   
    public CashPayment(int paymentId, double amount, Order order, double cashReceived) {
        super("Cash", amount, order);  // Calls the Payment parameterized constructor
        this.cashReceived = cashReceived;
        this.change = calculateChange();  // Calculate the change when the payment is created
    }

    // Mutator methods
    public void setCashReceived(double cashReceived) {
        this.cashReceived = cashReceived;
    }

    public void setChange(double change) {
        this.change = change;
    }

    // Accessor methods
    public double getCashReceived() {
        return this.cashReceived;
    }

    public double getChange() {
        return this.change;
    }

    // Override the processPayment method to handle cash payments
    @Override
    public boolean processPayment() {
        if (super.getOrder() != null && this.cashReceived >= super.getAmount()) {
            this.change = calculateChange();  // Calculate the change
            System.out.println("Cash payment processed successfully. Change: " + this.change);
            return true;
        }
        System.out.println("Cash payment failed. Insufficient cash received.");
        return false;
    }

    // Method to calculate the change to return to the customer
    public double calculateChange() {
        if (this.cashReceived >= super.getAmount()) {
            return this.cashReceived - super.getAmount();
        }
        return 0.0;  // No change if cash received is less than the amount
    }

    
    @Override
    public String toString() {
        return super.toString() +  // Calls the toString method from the Payment class
               ", Cash Received: " + this.cashReceived +
               ", Change: " + this.change;
    }
}

