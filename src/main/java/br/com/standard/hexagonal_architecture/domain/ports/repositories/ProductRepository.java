package br.com.standard.hexagonal_architecture.domain.ports.repositories;

import java.util.List;

import br.com.standard.hexagonal_architecture.domain.entity.Product;

public interface ProductRepository {
    List<Product> findAll();
    Product findBySku(String sku);
    Product save(Product product);
    void deleteBySku(String sku);
}
