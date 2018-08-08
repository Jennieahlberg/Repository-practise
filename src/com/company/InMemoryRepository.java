package com.company;

import java.util.ArrayList;
import java.util.List;

public class InMemoryRepository implements Repository {

    private List<Order> orders = new ArrayList<>();
    int orderID = 0;


    public Order getOrder(int orderID, int customerID) {
        for (var order : orders) {

            try {
                if (order.customerID == customerID && order.orderID == orderID) {
                    return order;
                }
            } catch (IllegalArgumentException e) {
                System.out.println("OrderID: " + orderID + " for CustomerID: " + customerID + " was not found");
            }
        }
        return null;
    }


    public List<Order> getAllOrderForCustomer(int customerID) {
        List<Order> list = new ArrayList<>();

        for (var order : orders) {
            if (order.customerID == customerID) {
                list.add(order);
            }
        }
        return list;
    }


    public void deleteOrder(int orderID, int customerID) {
        for (var order : orders) {
            try {
                if (order.customerID == customerID && order.orderID == orderID) {
                    orders.remove(order);
                    return;
                }

            } catch (IllegalArgumentException e) {
                System.out.println("Order: " + orderID + " was not found.");
            }
        }
    }


    public int createNewOrder(Order order) {
        if(order.customerName.isEmpty() || order.customerName == null){
            throw new IllegalArgumentException("Name is required.");
        }
        if(order.customerID <= 0 ){
            throw new IllegalArgumentException("Customer-ID has to be greater than zero.");
        }
        if(order.orderID != 0){
            throw new IllegalArgumentException(("Order-ID already excists."));
        }

        orders.add(order);
        return order.orderID = ++orderID;

    }
}
