package com.company;

import org.joda.money.Money;

public class OrderLine {
    public String productName;
    public int quantity;
    public Money price;


    public OrderLine(String productName, int quantity, Money price) {
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    @Override
    public String toString() {
        return productName + ", " + quantity + " items" + ", price per item " + price;
    }

    public Money getOrderLineTotalValue() {
        return price.multipliedBy(quantity);

    }

}
