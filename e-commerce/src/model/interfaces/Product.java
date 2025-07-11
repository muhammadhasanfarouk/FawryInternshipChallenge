package model.interfaces;

public interface Product {
    String getName();
    double getPrice();
    int getQuantity();
    void updateQuantity(int boughtQuantity);
}
