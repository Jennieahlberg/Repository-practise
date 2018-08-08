package com.company;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private List<OrderLine> orderlines;
    public String customerName;

    public int orderID;
    public int customerID;



    public Order(String customerName, int customerID) {
        this.orderlines = new ArrayList<>();
        this.customerName = customerName;
        this.customerID = customerID;
    }

    public void addOrderLine(OrderLine orderLine) {
        orderlines.add(orderLine);
    }


    public Money getOrderTotal() {
        Money sum = Money.of(CurrencyUnit.EUR, 0);

        for (OrderLine line : orderlines) {
            sum = sum.plus(line.getOrderLineTotalValue());
        }
        return sum;
    }

    @Override
    public String toString() {
        String result = customerName;

        for (OrderLine line : orderlines) {
            result = result + "\r\n" + line;
        }
        return result;
    }
}
