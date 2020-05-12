package com.kodilla.good.patterns.challenges.food2door;

public class Application {
    public static void main(String[] args) {
        ExtraFoodShop extraFoodShop = new ExtraFoodShop();
        OrderProcessor orderProcessor = new OrderProcessor();
        Order order = new Order(13, 300);

        orderProcessor.process(extraFoodShop, order);
    }
}
