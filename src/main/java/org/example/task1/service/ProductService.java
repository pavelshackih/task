package org.example.task1.service;

import org.example.task1.model.Product;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Map;

public interface ProductService {

    @Nonnull
    Map<Integer, List<Product>> getGroupedProducts();

    @Nonnull
    String getProductsAsJson();
}
