package com.kodilla.good.patterns.challenges.food2door;

public class ExtraFoodShop implements Supplier {
    @Override
    public void process(Order order){
        System.out.println("Processing ExtraFoodShop");
    }
}
