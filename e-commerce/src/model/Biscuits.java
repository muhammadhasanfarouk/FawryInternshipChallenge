package model;

import model.interfaces.Expirable;

import java.time.LocalDate;

public class Biscuits implements Expirable {
    private String name;
    private double price;
    private int quantity;
    private LocalDate expiryDate;

    public Biscuits(String name, double price, int quantity, LocalDate expiryDate) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
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
}
