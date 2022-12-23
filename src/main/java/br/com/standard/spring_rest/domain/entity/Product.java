package br.com.standard.spring_rest.domain.entity;

import java.security.InvalidParameterException;
import java.util.UUID;

import br.com.standard.spring_rest.domain.dto.ProductDto;

public class Product {
    private UUID id;
    private String description;
    private String sku;
    private Double price;
    private Integer quantity;
    
    public Product(UUID id, String description, String sku, Double price, Integer quantity) {
        this.id = id;
        this.description = description;
        this.sku = sku;
        this.price = price;
        this.quantity = quantity;
    }

    public UUID getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getSku() {
        return sku;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Product(ProductDto product) {
        this.sku = product.getSku();
        this.description = product.getDescription();
        this.price = product.getPrice();
        this.quantity = product.getQuantity();
    }

    public ProductDto toProductDto() {
        return new ProductDto(this.description, this.sku, this.price, this.quantity);
    }

    public void updatePrice(Double price) {
        if (price == null || price <= 0)
            throw new InvalidParameterException("Invalid price.");

        this.price = price;
    }

    public void updateProduct(String description, String sku, Double price, Integer quantity) {
        this.description = description;
        this.sku = sku;
        this.price = price;
        this.quantity = quantity;
    }
}
