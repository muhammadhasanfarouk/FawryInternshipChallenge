public class ConsolePrint {
    public void printCheckoutDetails(Cart cart, double weight, double balance, double shippingPrice, double totalPrice) {
        printShipmentNotice(cart, weight);
        printCheckoutReceipt(cart, balance, shippingPrice, totalPrice);
    }

    private void printShipmentNotice(Cart cart, double weight) {
        System.out.println("** Shipment notice **");
        int totalWeight = 0;
        for (int i = 0; i < cart.list.size(); i++) {
            Product product = cart.list.get(i).getKey();
            int quantity = cart.list.get(i).getValue();
            if (product instanceof Shippable) {
//                System.out.println(quantity + "X" + product.getName() + "      " + (((Shippable) product).getWeight() * quantity) + "g");
                System.out.printf("%-20s %10.2fg%n", quantity + "x " + product.getName(), ((Shippable) product).getWeight() * quantity);
            }
        }
        System.out.println("Total package weight " + weight + "g");
    }

    private void printCheckoutReceipt(Cart cart, double balance, double shippingPrice, double totalPrice) {
        System.out.println("--------------------------------");
        System.out.println("** Checkout receipt **");
        for (int i = 0; i < cart.list.size(); i++) {
            Product product = cart.list.get(i).getKey();
            int quantity = cart.list.get(i).getValue();
            System.out.printf("%-20s %10.2f%n", quantity + "X " + product.getName(), product.getPrice() * quantity);
//            System.out.println(quantity + "X" + product.getName() + "      " + (product.getPrice() * quantity) + "g");
        }
        System.out.println("--------------------------------");
        System.out.printf("%-20s %10.2f%n","Subtotal" , totalPrice);
        System.out.printf("%-20s %10.2f%n", "Shipping" , shippingPrice);
        double total = (cart.totalPrice + shippingPrice);
        System.out.printf("%-20s %10.2f%n", "Amount" , total);
        System.out.printf("%-20s %10.2f%n", "Remaining balance" , balance);
    }
}
