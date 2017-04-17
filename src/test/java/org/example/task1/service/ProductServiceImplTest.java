package org.example.task1.service;

import org.example.task1.model.Product;
import org.example.task1.model.ProductCategory;
import org.example.task1.model.ProductType;
import org.example.task1.repository.ProductRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ProductServiceImplTest {

    private static final String EXPECTED = "EXPECTED";

    private ProductServiceImpl service;

    @Before
    public void setUp() throws Exception {
        ProductRepository repository = Mockito.mock(ProductRepository.class);
        Mockito.when(repository.getProducts()).thenReturn(getProducts());
        Mockito.when(repository.getProductsAsJson(Mockito.any())).thenReturn(EXPECTED);
        service = new ProductServiceImpl(repository);
    }

    @Test
    public void getGroupedProducts() throws Exception {
        Map<Integer, List<Product>> expected = new HashMap<>();
        List<Product> firstList = new ArrayList<>();
        firstList.add(new Product("1", ProductType.PANTS, new ProductCategory(1, "a"), BigDecimal.ZERO));
        expected.put(1, firstList);
        List<Product> secondList = new ArrayList<>();
        secondList.add(new Product("1", ProductType.PANTS, new ProductCategory(2, "a"), BigDecimal.ZERO));
        expected.put(2, secondList);

        Map<Integer, List<Product>> actual = service.getGroupedProducts();
        assertThat(actual, is(expected));
    }

    @Test
    public void getProductsAsJson() throws Exception {
        String actual = service.getProductsAsJson();
        assertThat(actual, is(EXPECTED));
    }


    private List<Product> getProducts() {
        List<Product> products = new ArrayList<>();
        products.add(new Product("1", ProductType.PANTS, new ProductCategory(1, "a"), BigDecimal.ZERO));
        products.add(new Product("1", ProductType.PANTS, new ProductCategory(2, "a"), BigDecimal.ZERO));
        return products;
    }
}