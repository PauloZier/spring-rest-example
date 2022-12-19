package br.com.standard.hexagonal_architecture.domain.dto;

import br.com.standard.hexagonal_architecture.domain.entity.Product;

public class ProductDto {
    private String description;
    private String sku;
    private Double price;
    private Integer quantity;
    
    public ProductDto(String description, String sku, Double price, Integer quantity) {
        this.description = description;
        this.sku = sku;
        this.price = price;
        this.quantity = quantity;
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

    public ProductDto(Product product) {
        this.sku = product.getSku();
        this.description = product.getDescription();
        this.price = product.getPrice();
        this.quantity = product.getQuantity();
    }

    public Product toProduct() {
        return new Product(null, this.description, this.sku, this.price, this.quantity);
    }
}
