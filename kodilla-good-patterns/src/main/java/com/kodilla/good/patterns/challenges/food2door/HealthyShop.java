package com.kodilla.good.patterns.challenges.food2door;

public class HealthyShop implements Supplier {
    @Override
    public void process(Order order) {
        System.out.println("Processing HealthyShop");
    }
}
