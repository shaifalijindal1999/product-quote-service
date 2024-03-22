package com.productquoteservice.models.common.ProductModels;

import java.util.HashMap;


public class Product {

    private String id;
    private String name;
    private String description;
    private float price;

    private int requestedQuantity;

    public int getRequestedQuantity() {
        return requestedQuantity;
    }

    public void setRequestedQuantity(int requestedQuantity) {
        this.requestedQuantity = requestedQuantity;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    public void setAttributes(HashMap<String, String> attributes) {
        this.attributes = attributes;
    }

    private HashMap<String, String> attributes;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public float getPrice() {
        return price;
    }

    public HashMap<String, String> getAttributes() {
        return attributes;
    }

    public static class ProductInnerClass {
        Product productInfo = new Product();

        public ProductInnerClass setId(String id) {
            this.productInfo.setId(id);
            return this;
        }

        public ProductInnerClass setName(String name) {
            this.productInfo.setName(name);
            return this;
        }

        public ProductInnerClass setPrice(float price) {
            this.productInfo.setPrice(price);
            return this;
        }

        public ProductInnerClass setRequestedQuantity(int requestedQuantity) {
            this.productInfo.setRequestedQuantity(requestedQuantity);
            return this;
        }

        public Product build() {
            return productInfo;
        }

    }
    public static ProductInnerClass builder() {
        return new ProductInnerClass();
    }
}
