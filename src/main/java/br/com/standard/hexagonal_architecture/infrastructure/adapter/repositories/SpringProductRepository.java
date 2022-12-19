package br.com.standard.hexagonal_architecture.infrastructure.adapter.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.standard.hexagonal_architecture.infrastructure.adapter.entity.ProductEntity;

@Repository
public interface SpringProductRepository extends JpaRepository<ProductEntity, String> {
    Optional<ProductEntity> findBySku(String sku);
    void deleteBySku(String sku);
    boolean existsBySku(String sku);
}
