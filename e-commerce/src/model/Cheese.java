package model;

import model.interfaces.Expirable;
import model.interfaces.Shippable;

import java.time.LocalDate;

public class Cheese implements Expirable, Shippable {
    private String name;
    private double price;
    private int quantity;
    private double weight;
    private LocalDate expiryDate;

    public Cheese(String name, double price, int quantity, int weight, LocalDate expiryDate) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.weight = weight;
        this.expiryDate = expiryDate;
    }

    @Override
    public LocalDate getExpiryDate() {
        return expiryDate;
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

    @Override
    public double getWeight() {
        return weight;
    }
}
