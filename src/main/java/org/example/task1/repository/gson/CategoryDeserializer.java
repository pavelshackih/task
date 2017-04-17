package org.example.task1.repository.gson;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import org.example.task1.model.ProductCategory;

import java.lang.reflect.Type;

public class CategoryDeserializer implements JsonDeserializer<ProductCategory> {

    @Override
    public ProductCategory deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        String text = json.getAsString();
        StringBuilder number = new StringBuilder();
        StringBuilder sub = new StringBuilder("");
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (Character.isDigit(c)) {
                number.append(c);
            } else {
                sub.append(c);
            }
        }
        return new ProductCategory(Integer.parseInt(number.toString()), sub.toString());
    }
}
