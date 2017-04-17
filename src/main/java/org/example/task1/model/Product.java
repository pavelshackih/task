package org.example.task1.model;

import java.math.BigDecimal;

public class Product {

    private String productId;
    private ProductType type;
    private ProductCategory category;
    private BigDecimal price;

    public Product(String productId,
                   ProductType type,
                   ProductCategory category,
                   BigDecimal price) {
        this.productId = productId;
        this.type = type;
        this.category = category;
        this.price = price;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public ProductType getType() {
        return type;
    }

    public void setType(ProductType type) {
        this.type = type;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        return productId != null ? productId.equals(product.productId) : product.productId == null;
    }

    @Override
    public int hashCode() {
        return productId != null ? productId.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", productType=" + type +
                ", category='" + category + '\'' +
                ", price=" + price +
                '}';
    }
}
