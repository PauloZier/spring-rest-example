package br.com.standard.spring_rest.infrastructure.adapter.entity;

import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;

import br.com.standard.spring_rest.domain.entity.Product;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Products")
public class ProductEntity {
    @Id
    @Column(unique = true)
    @GenericGenerator(name = "uuid", strategy = "uuid4")
    private String id;

    @Column(length = 255, nullable = false)
    private String description;

    @Column(length = 50, nullable = false, unique = true)
    private String sku;

    private Double price;

    private Integer quantity;

    public ProductEntity() {
        
    }

    public ProductEntity(String id, String description, String sku, Double price, Integer quantity) {

        if (id.isEmpty() || id.isBlank())
            id = UUID.randomUUID().toString();

        this.id = id;
        this.description = description;
        this.sku = sku;
        this.price = price;
        this.quantity = quantity;
    }

    public String getId() {
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

    public ProductEntity(Product product) {

        if (product.getId() == null)
            this.id = UUID.randomUUID().toString();
        else
            this.id = product.getId().toString();

        this.sku = product.getSku();
        this.description = product.getDescription();
        this.price = product.getPrice();
        this.quantity = product.getQuantity();
    }

    public Product toProduct() {
        return new Product(UUID.fromString(this.id), this.description, this.sku, this.price, this.quantity);
    }
}
