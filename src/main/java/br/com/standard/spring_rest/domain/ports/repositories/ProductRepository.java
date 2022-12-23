package br.com.standard.spring_rest.domain.ports.repositories;

import java.util.List;

import br.com.standard.spring_rest.domain.entity.Product;

public interface ProductRepository {
    List<Product> findAll();
    Product findBySku(String sku);
    Product save(Product product);
    void deleteBySku(String sku);
}
