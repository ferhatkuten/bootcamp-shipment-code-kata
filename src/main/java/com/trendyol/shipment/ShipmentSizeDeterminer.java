package com.trendyol.shipment;

import java.util.List;

public class ShipmentSizeDeterminer {

    private static final int SHIPMENT_SIZE_THRESHOLD = 3;

    public static ShipmentSize determineShipmentSize(List<Product> products) {

        for (ShipmentSize size : ShipmentSize.values()) {
            int specificSizeTotalProductCount = (int) products.stream().filter(p -> p.getSize() == size).count();
            if (specificSizeTotalProductCount >= SHIPMENT_SIZE_THRESHOLD) {
                return getNextSize(size);
            }
        }

        return findLargestSizeInProducts(products);
    }

    private static ShipmentSize getNextSize(ShipmentSize currentSize) {
        int nextSizeIndex = currentSize.ordinal() + 1;
        int maxSizeIndex = ShipmentSize.values().length;
        if (nextSizeIndex < maxSizeIndex) {
            return ShipmentSize.values()[nextSizeIndex];
        }
        return currentSize;
    }

    private static ShipmentSize findLargestSizeInProducts(List<Product> products) {
        return products.stream()
                .map(Product::getSize)
                .max(Enum::compareTo)
                .orElse(ShipmentSize.SMALL);
    }
}
