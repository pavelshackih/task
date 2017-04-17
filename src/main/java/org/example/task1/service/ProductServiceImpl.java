package org.example.task1.service;

import org.example.task1.model.Product;
import org.example.task1.repository.ProductRepository;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;

    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Nonnull
    @Override
    public Map<Integer, List<Product>> getGroupedProducts() {
        final Map<Integer, List<Product>> map = repository.getProducts().stream()
                .collect(Collectors.groupingBy(p -> p.getCategory().getId()));
        final Comparator<Product> comparator = new ProductComparator();
        map.values().forEach(list -> list.sort(comparator));
        return map;
    }

    @Nonnull
    @Override
    public String getProductsAsJson() {
        Map<Integer, List<Product>> map = getGroupedProducts();
        return repository.getProductsAsJson(new ArrayList<>(map.values()));
    }
}
