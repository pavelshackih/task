package org.example.task1.service;

import org.example.task1.model.Product;

import java.util.Comparator;

public class ProductComparator implements Comparator<Product> {

    private static int compareProducts(Product p1, Product p2) {
        int i = Integer.compare(p1.getCategory().getId(), p2.getCategory().getId());
        if (i != 0) {
            return i;
        }
        return p1.getCategory().getSub().compareToIgnoreCase(p2.getCategory().getSub());
    }

    @Override
    public int compare(Product p1, Product p2) {
        return compareProducts(p1, p2);
    }
}
