package model;

import model.interfaces.Shippable;

public class TV implements Shippable {
    private String name;
    private double price;
    private int quantity;
    private double weight;

    public TV(String name, double price, int quantity, int weight) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.weight = weight;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public int getQuantity() {
        return quantity;
    }

    @Override
    public void updateQuantity(int boughtQuantity) {
        quantity -= boughtQuantity;
    }
}
