
package com.learning.gui;

import java.util.Date;

/**
 *
 * @author Samah Mahdi (samah.mahdi.hassan@gmail.com)
 */

public class CardPayment extends Payment {
    private String cardNumber;
    private String cardHolderName;
    private Date expirationDate;
    private String cvv;

    // Constructors
    public CardPayment() {
        super();  // Calls the Payment default constructor
        this.cardNumber = "";
        this.cardHolderName = "";
        this.expirationDate = null;
        this.cvv = "";
    }

    public CardPayment( double amount, Order order, String cardNumber, String cardHolderName, Date expirationDate, String cvv) {
        super("Card", amount, order);  // Calls the Payment constructor
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.expirationDate = expirationDate;
        this.cvv = cvv;
    }

    // Mutator methods
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    // Accessors methods
    public String getCardNumber() {
        return this.cardNumber;
    }

    public String getCardHolderName() {
        return this.cardHolderName;
    }

    public Date getExpirationDate() {
        return this.expirationDate;
    }

    // Override processPayment to handle card validation and processing
    @Override
    public boolean processPayment() {
        // Basic validation for card expiration date and card details
        Date today = new Date();
        if (this.expirationDate.after(today) && this.cardNumber.length() == 16 && this.cvv.length() == 3) {
            System.out.println("Card payment processed successfully.");
            return true;
        }
        System.out.println("Card payment failed. Invalid card details.");
        return false;
    }
    
    public double calculateChange() {
        return 0.0;  // No change is given for card payments
    }

    @Override
    public String toString() {
        return super.toString() +  // Calls the toString method from the Payment class
               ", Card Number: " + "**** **** **** " + this.cardNumber.substring(this.cardNumber.length() - 4) +  // Mask the card number
               ", Card Holder: " + this.cardHolderName +
               ", Expiration Date: " + this.expirationDate;
    }
}

