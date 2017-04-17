package org.example.task1.repository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.example.task1.model.Product;
import org.example.task1.model.ProductCategory;
import org.example.task1.model.ProductType;
import org.example.task1.repository.gson.CategoryDeserializer;
import org.example.task1.repository.gson.CategorySerializer;
import org.example.task1.repository.gson.ProductTypeSerializer;

import javax.annotation.Nonnull;
import java.lang.reflect.Type;
import java.util.List;

public class JsonRepositoryImpl implements ProductRepository {

    private static final String SAMPLE_JSON =
            "[{productId: '1234', type: 'Shirt', category: '3', price: 40},\n" +
                    "{productId: '2341', type: 'Pants', category: '3a', price: 15},\n" +
                    "{productId: '123', type: 'Shoe', category: '1', price: 20},\n" +
                    "{productId: '234', type: 'Socks', category: '1a', price: 5}]";
    private final Gson gson;
    private final Type listOfProducts;

    public JsonRepositoryImpl() {
        gson = new GsonBuilder()
                .registerTypeAdapter(ProductCategory.class, new CategoryDeserializer())
                .registerTypeAdapter(ProductCategory.class, new CategorySerializer())
                .registerTypeAdapter(ProductType.class, new ProductTypeSerializer())
                .create();
        listOfProducts = new TypeToken<List<Product>>() {
        }.getType();
    }

    @Nonnull
    @Override
    public List<Product> getProducts() {
        return gson.fromJson(SAMPLE_JSON, listOfProducts);
    }

    @Override
    public String getProductsAsJson(List<List<Product>> products) {
        return gson.toJson(products);
    }
}
