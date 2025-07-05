package model;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

public class Cart {
    double totalPrice = 0;
    List<AbstractMap.SimpleEntry<Product, Integer>> list = new ArrayList<>();

    void addProduct(Product product, int quantity) {
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
