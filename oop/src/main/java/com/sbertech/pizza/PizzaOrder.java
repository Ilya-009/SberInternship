package com.sbertech.pizza;

public class PizzaOrder {
    private String name;
    private PizzaSize size;
    private boolean souseRequired;
    private String deliveryAddress;
    private boolean orderAccepted;

    public PizzaOrder(String name, PizzaSize size, boolean souseRequired, String deliveryAddress) {
        this.name = name;
        this.size = size;
        this.souseRequired = souseRequired;
        this.deliveryAddress = deliveryAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PizzaSize getSize() {
        return size;
    }

    public void setSize(PizzaSize size) {
        this.size = size;
    }

    public boolean isSouseRequired() {
        return souseRequired;
    }

    public void setSouseRequired(boolean souseRequired) {
        this.souseRequired = souseRequired;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }


    public void order() {
        String souseExpression = souseRequired ? "с соусом" : "без соуса";

        System.out.printf("Заказ принят. %s пицца %s %s на адрес %s", size.getDescription(), name, souseExpression, deliveryAddress);
        orderAccepted = true;
    }

    public void cancel() {
        System.out.println(orderAccepted ? "Заказ отменен" : "Заказ не был принят");
    }


    @Override
    public String toString() {
        return "PizzaOrder{" +
                "name='" + name + '\'' +
                ", size=" + size +
                ", souseRequired=" + souseRequired +
                ", deliveryAddress='" + deliveryAddress + '\'' +
                ", orderAccepted=" + orderAccepted +
                '}';
    }
}
