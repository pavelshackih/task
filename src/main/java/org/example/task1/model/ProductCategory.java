package org.example.task1.model;

import javax.annotation.Nonnull;

public class ProductCategory {

    private final int id;
    private final String sub;

    public ProductCategory(int id, @Nonnull String sub) {
        this.id = id;
        this.sub = sub;
    }

    public ProductCategory(int id) {
        this(id, "");
    }

    public int getId() {
        return id;
    }

    public String getSub() {
        return sub;
    }

    public String getFull() {
        return Integer.toString(id) + getSub();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductCategory that = (ProductCategory) o;

        if (id != that.id) return false;
        return sub != null ? sub.equals(that.sub) : that.sub == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (sub != null ? sub.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ProductCategory{" +
                "id=" + id +
                ", sub='" + sub + '\'' +
                '}';
    }
}
