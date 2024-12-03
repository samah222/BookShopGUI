
package com.learning.gui;

/**
 *
 * @author Samah Mahdi (samah.mahdi.hassan@gmail.com)
 */

public class Payment {
    // Attributes
    public static int lastPaymentId = 0;
    private int paymentId;
    private String paymentMethod;
    private double amount;
    private Order order;

    // constructors
    public Payment() {
        this.paymentId = 0;
        this.paymentMethod = "";
        this.amount = 0.0;
        this.order = null;
    }

    public Payment(String paymentMethod, double amount, Order order) {
        this.paymentId = lastPaymentId ++;
        this.paymentMethod = paymentMethod;
        this.amount = amount;
        this.order = order;
    }

    // Accessors methods
    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    // Mutators methods
    public int getPaymentId() {
        return this.paymentId;
    }

    public String getPaymentMethod() {
        return this.paymentMethod;
    }

    public double getAmount() {
        return this.amount;
    }

    public Order getOrder() {
        return this.order;
    }

    // Method to process the payment
    public boolean processPayment() {
        if (this.order != null && this.amount == order.getTotal()) {
            System.out.println("Payment processed successfully.");
            return true;
        }
        System.out.println("Payment failed. Order total does not match the payment amount.");
        return false;
    }

    // Method to cancel the payment
    public boolean cancelPayment() {
        if (this.order != null && this.amount == order.getTotal()) {
            this.amount = 0.0;
            System.out.println("Payment cancelled successfully.");
            return true;
        }
        System.out.println("Payment cancellation failed.");
        return false;
    }

    
    @Override
    public String toString() {
        return "Payment ID: " + this.paymentId +
               ", Payment Method: " + this.paymentMethod +
               ", Amount: " + this.amount +
               ", Order ID: " + (this.order != null ? this.order.getOrderId() : "No Order");
    }
}

