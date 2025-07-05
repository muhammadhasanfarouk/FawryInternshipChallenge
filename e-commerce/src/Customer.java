import java.time.LocalDate;

public class Customer {
    String name;
    private double balance;
    private Cart cart = new Cart();
    Checkout checkout;
    ConsolePrint consolePrint = new ConsolePrint();

    public Customer(String name, int balance) {
        this.balance = balance;
    }

    void addProduct(Product product, int quantity) {
        if (product.getQuantity() < quantity) {
            System.out.println("Error available " + product.getQuantity() + " .");
            return;
        }

        if (product instanceof Expirable) {
            LocalDate now = LocalDate.now();
            if (((Expirable) product).getExpiryDate().isBefore(now)) {
                System.out.println("Error product "+ product.getName() +" is expired and was not added to the cart .");
                return;
            }
        }
        cart.addProduct(product, quantity);
    }

    public void checkout(){
        checkout = new Checkout(name, balance, cart, consolePrint);
        balance = checkout.checkoutNow();
    }
}


//    void checkout() {
//        if (cart.list.isEmpty()) {
//            System.out.println("Error cart is empty.");
//            return;
//        }
//        List<AbstractMap.SimpleEntry<Product, Integer>> shippingList = new ArrayList<>();
//        for (int i = 0; i < cart.list.size(); i++) {
//            if (cart.list.get(i).getKey() instanceof Shipable) {
//                shippingList.add(new AbstractMap.SimpleEntry<>(cart.list.get(i).getKey(), cart.list.get(i).getValue()));
//            }
//        }
//
//        if (!shippingList.isEmpty())
//            shippingServiceX = new ShippingServiceX(name, shippingList);
//
//        double shippingPrice = shippingServiceX.getWeight() * 0.5;
//        if (balance < cart.totalPrice + shippingPrice) {
//            System.out.println("Error balance is insufficient.");
//            return;
//        }
//
//        balance -= cart.totalPrice + (shippingServiceX.getWeight() * 0.5);
//
//
//        consolePrint.printCheckoutDetails(cart, shippingServiceX, balance, shippingPrice,cart.totalPrice);
//    }


