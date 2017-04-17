package org.example.task1.repository.gson;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import org.example.task1.model.ProductCategory;

import java.lang.reflect.Type;

public class CategorySerializer implements JsonSerializer<ProductCategory> {

    @Override
    public JsonElement serialize(ProductCategory src, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(src.getFull());
    }
}
