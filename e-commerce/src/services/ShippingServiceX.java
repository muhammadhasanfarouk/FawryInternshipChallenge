package services;

import model.interfaces.Product;
import model.interfaces.Shippable;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

public class ShippingServiceX implements ShippingService {
    private String name;
    private double weight = 0;
    private List<AbstractMap.SimpleEntry<Product, Integer>> list = new ArrayList<>();

    public ShippingServiceX(String name, List<AbstractMap.SimpleEntry<Product, Integer>> list) {
        this.name = name;
        this.list = list;
        updateWeight();
    }


    private void updateWeight() {
        for (int i = 0; i < list.size(); i++) {
            weight += (((Shippable) list.get(i).getKey()).getWeight() * list.get(i).getValue());
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getWeight() {
        return weight;
    }
}
