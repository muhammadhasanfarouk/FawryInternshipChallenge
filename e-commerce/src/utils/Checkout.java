package utils;

import model.Cart;
import model.Product;
import model.Shippable;
import services.ShippingService;
import services.ShippingServiceX;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

public class Checkout {
    double balance;
    double shippingPrice = 0;
    ShippingService shippingServiceX;
    Cart cart;
    String name;
    ConsolePrint consolePrint;

    public Checkout(String name, double balance, Cart cart, ConsolePrint consolePrint) {
        this.name = name;
        this.balance = balance;
        this.cart = cart;
        this.consolePrint = consolePrint;
    }

    public double checkoutNow() {
        if (cart.getList().isEmpty()) {
            System.out.println("Error cart is empty.");
            return balance;
        }
        List<AbstractMap.SimpleEntry<Product, Integer>> shippingList = new ArrayList<>();
        for (int i = 0; i < cart.getList().size(); i++) {
            if (cart.getList().get(i).getKey() instanceof Shippable) {
                shippingList.add(new AbstractMap.SimpleEntry<>(cart.getList().get(i).getKey(), cart.getList().get(i).getValue()));
            }
        }

        if (!shippingList.isEmpty()) {
            shippingServiceX = new ShippingServiceX(name, shippingList);
            shippingPrice = (shippingServiceX.getWeight() * 0.5);
        }

        if (balance < (cart.getTotalPrice() + shippingPrice)) {
            System.out.println("Error balance is insufficient.");
            return balance;
        }

        balance -= cart.getTotalPrice() + shippingPrice;

        consolePrint.printCheckoutDetails(cart, shippingServiceX.getWeight(), balance, shippingPrice, cart.getTotalPrice());
        return balance;
    }
}
