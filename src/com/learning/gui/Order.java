
package com.learning.gui;

import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author Samah Mahdi (samah.mahdi.hassan@gmail.com)
 */

public class Order {
    // Attributes
    private long orderId;
    private static long lastOrderId =1;
    private List<Item> items;
    private double total;
    private String state;  // Can be "NEW", "IN_PROGRESS", "COMPLETED", "CANCELLED"
    private Customer customer;
    private LocalDateTime date;

    // Order State options
    public static final String NEW = "NEW";
    public static final String IN_PROGRESS = "IN_PROGRESS";
    public static final String COMPLETED = "COMPLETED";
    public static final String CANCELLED = "CANCELLED";

    //  constructors
    public Order() {
        this.orderId = lastOrderId++;
        this.items = null;
        this.total = 0.0;
        this.state = NEW;
        this.customer = null;
        this.date = LocalDateTime.now();
        this.state = NEW;
    }
   
    public Order(List<Item> items, double total, Customer customer, LocalDateTime date) {
        this.orderId = lastOrderId++;
        this.items = items;
        this.total = total;
        this.state = IN_PROGRESS;
        this.customer = customer;
        this.date = date;
    }

    // Final setter for orderId
    public final void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    // Mutator methods
    public void setItems(List<Item> items) {
        this.items = items;
        computeTotal();  // Recompute total when items are updated
    }

    public void setTotal() {
        double total = 0;
        for(int i=0; i<items.size(); i++){
            total += items.get(i).getPrice();
        }           
        this.total = total;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setState(String state) {
        this.state = state;
    }

    // Accessor methods
    public long getOrderId() {
        return this.orderId;
    }

    public List<Item> getItems() {
        return this.items;
    }

    public double getTotal() {
        return this.total;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public LocalDateTime getDate() {
        return this.date;
    }

    public String getState() {
        return this.state;
    }

    // Compute the total cost of the order
    public final double computeTotal() {
        this.total = 0.0;
        if (items != null) {
            for (Item item : items) {
                this.total += item.getPrice() * item.getQuantity();
            }
        }
        return this.total;
    }

    // Method to cancel the order
    public boolean cancelOrder(long orderId) {
        if (this.orderId == orderId && !this.state.equals(COMPLETED)) {
            this.state = CANCELLED;
            return true;
        }
        return false;
    }

    // Method to update the order
    public boolean updateOrder(long orderId) {
        if (this.orderId == orderId && this.state.equals(NEW)) {
            this.state = IN_PROGRESS;
            return true;
        }
        return false;
    }

    // Method to delete the order
    public boolean deleteOrder(long orderId) {
        if (this.orderId == orderId) {
            this.items.clear();
            this.total = 0.0;
            return true;
        }
        return false;
    }

    // Add an item to the order
    public boolean addItem(Item item) {
        if (this.items != null) {
            this.items.add(item);
            computeTotal();  // Recompute the total
            return true;
        }
        return false;
    }

    // Update an item in the order
    public boolean updateItem(Item updatedItem) {
        if (this.items != null) {
            for (Item item : items) {
                if (item.getItemId() == updatedItem.getItemId()) {
                    item.setQuantity(updatedItem.getQuantity());
                    computeTotal();  // Recompute the total
                    return true;
                }
            }
        }
        return false;
    }

    // Delete an item by item object
    public boolean deleteItem(Item item) {
        if (this.items != null && this.items.contains(item)) {
            this.items.remove(item);
            computeTotal();  // Recompute the total
            return true;
        }
        return false;
    }

    // Delete an item by itemId
    public boolean deleteItem(long itemId) {
        if (this.items != null) {
            for (Item item : items) {
                if (item.getItemId() == itemId) {
                    this.items.remove(item);
                    computeTotal();  // Recompute the total
                    return true;
                }
            }
        }
        return false;
    }

    // Check if items in the order are available
    public boolean checkItemsAvailability(long requestedQuantity) {
        if (this.items != null) {
            for (Item item : items) {
                if (!item.checkItemsAvailability(requestedQuantity)) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return "Order ID: " + this.orderId +
               ", Items: " + this.items +
               ", Total: " + this.total +
               ", State: " + this.state +
               ", Customer: " + this.customer +
               ", Date: " + this.date;
    }
}

