package org.example.task1.repository;

import org.example.task1.model.Product;

import javax.annotation.Nonnull;
import java.util.List;

public interface ProductRepository {

    @Nonnull
    List<Product> getProducts();

    String getProductsAsJson(List<List<Product>> products);
}
