package com.trendyol.shipment;

import java.util.List;

public class Basket {

    private List<Product> products;

    public ShipmentSize getShipmentSize() {
        return ShipmentSizeDeterminer.determineShipmentSize(products);
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
