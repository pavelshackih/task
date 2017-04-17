package org.example.task1.repository.gson;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import org.example.task1.model.ProductType;
import org.example.util.StringUtils;

import java.lang.reflect.Type;

public class ProductTypeSerializer implements JsonSerializer<ProductType> {

    @Override
    public JsonElement serialize(ProductType src, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(StringUtils.capitalize(src.name()));
    }
}
