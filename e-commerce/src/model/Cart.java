package model;

import model.interfaces.Product;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

public class Cart {
    private double totalPrice = 0;
    private List<AbstractMap.SimpleEntry<Product, Integer>> list = new ArrayList<>();

    public void addProduct(Product product, int quantity) {
        list.add(new AbstractMap.SimpleEntry<>(product, quantity));
        totalPrice += product.getPrice();
        product.updateQuantity(quantity);
    }

    public List<AbstractMap.SimpleEntry<Product, Integer>> getList() {
        return list;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}
