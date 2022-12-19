package br.com.standard.hexagonal_architecture.domain.dto;

public class UpdateProductPriceDto {
    private String sku;
    private Double price;
    
    public UpdateProductPriceDto(String sku, Double price) {
        this.sku = sku;
        this.price = price;
    }

    public String getSku() {
        return sku;
    }

    public Double getPrice() {
        return price;
    }
}
