package org.example.task1;

import org.example.task1.repository.JsonRepositoryImpl;
import org.example.task1.repository.ProductRepository;
import org.example.task1.service.ProductService;
import org.example.task1.service.ProductServiceImpl;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class Tests {

    // in task JSON has a invalid format (invalid nested object)
    private static final String EXPECTED_JSON = "[[{\"productId\":\"123\",\"type\":\"Shoe\",\"category\":\"1\",\"price\":20}," +
            "{\"productId\":\"234\",\"type\":\"Socks\",\"category\":\"1a\",\"price\":5}]," +
            "[{\"productId\":\"1234\",\"type\":\"Shirt\",\"category\":\"3\",\"price\":40}," +
            "{\"productId\":\"2341\",\"type\":\"Pants\",\"category\":\"3a\",\"price\":15}]]";

    private ProductService productService;

    @Before
    public void setUp() throws Exception {
        ProductRepository productRepository = new JsonRepositoryImpl();
        productService = new ProductServiceImpl(productRepository);
    }

    @Test
    public void sortingAndSerialize() {
        String actual = productService.getProductsAsJson();
        assertThat(actual, is(EXPECTED_JSON));
    }
}
