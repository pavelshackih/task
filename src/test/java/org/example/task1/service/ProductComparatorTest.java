package org.example.task1.service;

import org.example.task1.model.Product;
import org.example.task1.model.ProductCategory;
import org.example.task1.model.ProductType;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;

public class ProductComparatorTest {

    private ProductComparator comparator;

    @Before
    public void setUp() throws Exception {
        comparator = new ProductComparator();
    }

    @Test
    public void compare() throws Exception {
        assertThat(comparator.compare(build(1), build(1)), is(0));
        assertThat(comparator.compare(build(1), build(2)), lessThan(0));
        assertThat(comparator.compare(build(2), build(1)), greaterThan(0));
        assertThat(comparator.compare(build(1, "a"), build(1, "b")), lessThan(0));
        assertThat(comparator.compare(build(1), build(1, "b")), lessThan(0));
    }

    private Product build(int categoryId) {
        return build(categoryId, "");
    }

    private Product build(int categoryId, String sub) {
        return new Product("1", ProductType.PANTS, new ProductCategory(categoryId, sub), BigDecimal.ZERO);
    }
}