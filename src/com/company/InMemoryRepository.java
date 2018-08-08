package com.company;

import java.util.ArrayList;
import java.util.List;

public class InMemoryRepository implements Repository {

    private List<Order> orders = new ArrayList<>();
    int orderID = 0;


    public Order getOrder(int orderID, int customerID) {
        for (var order : orders) {
            if (order.customerID == customerID && order.orderID == orderID) {
                return order;
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
            if (order.customerID == customerID && order.orderID == orderID) {
                orders.remove(order);
                return;
            }
        }
    }


    public int createNewOrder(Order order) {
        orders.add(order);
        return order.orderID = ++orderID;

    }
}
