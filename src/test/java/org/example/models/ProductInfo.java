package org.example.models;

public class ProductInfo {

    private String name;
    private String price;
    private boolean imageVisible;

    public ProductInfo(String name, String price, boolean imageVisible) {
        this.name = name;
        this.price = price;
        this.imageVisible = imageVisible;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public boolean isImageVisible() {
        return imageVisible;
    }

    @Override
    public String toString() {
        return "ProductInfo{name='" + name + "', price='" + price + "', imageVisible=" + imageVisible + "}";
    }
}

