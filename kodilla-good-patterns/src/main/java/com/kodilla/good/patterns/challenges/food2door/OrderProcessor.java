package com.kodilla.good.patterns.challenges.food2door;

public class OrderProcessor {
    public void process(Supplier supplier, Order order) {
        supplier.process(order);
        System.out.println(order.getStatus().toString());
    }
}
