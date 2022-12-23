package br.com.standard.spring_rest.infrastructure.adapter.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.standard.spring_rest.infrastructure.adapter.entity.ProductEntity;

public interface SpringProductRepository extends JpaRepository<ProductEntity, String> {
    Optional<ProductEntity> findBySku(String sku);
    void deleteBySku(String sku);
    boolean existsBySku(String sku);
}
