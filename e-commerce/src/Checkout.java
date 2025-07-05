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

    double checkoutNow() {
        if (cart.list.isEmpty()) {
            System.out.println("Error cart is empty.");
            return balance;
        }
        List<AbstractMap.SimpleEntry<Product, Integer>> shippingList = new ArrayList<>();
        for (int i = 0; i < cart.list.size(); i++) {
            if (cart.list.get(i).getKey() instanceof Shippable) {
                shippingList.add(new AbstractMap.SimpleEntry<>(cart.list.get(i).getKey(), cart.list.get(i).getValue()));
            }
        }

        if (!shippingList.isEmpty()) {
            shippingServiceX = new ShippingServiceX(name, shippingList);
            shippingPrice = (shippingServiceX.getWeight() * 0.5);
        }

        if (balance < (cart.totalPrice + shippingPrice)) {
            System.out.println("Error balance is insufficient.");
            return balance;
        }

        balance -= cart.totalPrice + shippingPrice;

        consolePrint.printCheckoutDetails(cart, shippingServiceX.getWeight(), balance, shippingPrice, cart.totalPrice);
        return balance;
    }
}
