package com.kodilla.kodillapatterns2.facade;

public class Item {

    public Long getProductId() {
        return productId;
    }

    public double getQty() {
        return qty;
    }

    private final Long productId;
    private final double qty;


    public Item(Long productId, double qty) {
        this.productId = productId;
        this.qty = qty;
    }
}
