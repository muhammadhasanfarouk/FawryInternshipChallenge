package model;

import model.interfaces.Expirable;
import model.interfaces.Product;
import services.Checkout;
import utils.ConsolePrint;

import java.time.LocalDate;

public class Customer {

    private String name;
    private double balance;
    private Cart cart = new Cart();
    private Checkout checkout;
    private ConsolePrint consolePrint = new ConsolePrint();

    public Customer(String name, int balance) {
        this.name = name;
        this.balance = balance;
    }

    public void addProduct(Product product, int quantity) {
        if (product.getQuantity() < quantity) {
            System.out.println("Error available " + product.getQuantity() + " .");
            return;
        }

        if (product instanceof Expirable) {
            LocalDate now = LocalDate.now();
            if (((Expirable) product).getExpiryDate().isBefore(now)) {
                System.out.println("Error product " + product.getName() + " is expired and was not added to the cart .");
                return;
            }
        }
        cart.addProduct(product, quantity);
    }

    public void checkout() {
        checkout = new Checkout(name, balance, cart, consolePrint);
        balance = checkout.checkoutNow();
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }
}
