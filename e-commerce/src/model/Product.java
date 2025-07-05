package model;

public interface Product {
    String getName();
    double getPrice();
    int getQuantity();
    void updateQuantity(int boughtQuantity);
}
