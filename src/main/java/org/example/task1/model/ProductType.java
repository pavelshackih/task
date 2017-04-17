package org.example.task1.model;

import com.google.gson.annotations.SerializedName;

public enum ProductType {
    @SerializedName("Shirt")SHIRT,
    @SerializedName("Pants")PANTS,
    @SerializedName("Shoe")SHOE,
    @SerializedName("Socks")SOCKS
}
