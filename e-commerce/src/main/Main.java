package main;

import model.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Customer Muhammad = new Customer("Muhammad", 30000);
        Cheese Cheddar = new Cheese("cheddar", 200, 400, 100, LocalDate.of(2025, 7, 25));
        Cheese Guda = new Cheese("Guda", 120, 300, 100, LocalDate.of(2025, 7, 22));
        TV oledTV = new TV("oled model.TV", 20000, 50, 750);
        MobileScratchcCard scratchcCard = new MobileScratchcCard("Fawry", 10, 100);
        Biscuits biscuits = new Biscuits("Bisco", 5, 136, LocalDate.of(2025, 9, 10));

        Muhammad.addProduct(Cheddar, 2);
        Muhammad.addProduct(Guda, 1);
        Muhammad.addProduct(biscuits, 10);
        Muhammad.addProduct(oledTV, 1);
        Muhammad.addProduct(scratchcCard, 1);

        Muhammad.checkout();
    }
}