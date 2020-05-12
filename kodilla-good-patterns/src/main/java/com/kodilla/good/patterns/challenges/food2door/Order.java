package com.kodilla.good.patterns.challenges.food2door;

class Order {

    public enum Status {
        ACCEPTED,
        IN_PROGRESS,
        REJECTED,
        FINALIZED
    }

    private int productId;
    private int quantity;
    private Status status;


    public Order(int productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public int getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public Status getStatus() {

        if (status == null) {
            throw new StatusException();
        }

        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}