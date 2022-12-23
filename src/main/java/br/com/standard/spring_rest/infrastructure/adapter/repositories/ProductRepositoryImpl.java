package br.com.standard.spring_rest.infrastructure.adapter.repositories;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import br.com.standard.spring_rest.domain.entity.Product;
import br.com.standard.spring_rest.domain.exception.NotFoundException;
import br.com.standard.spring_rest.domain.ports.repositories.ProductRepository;
import br.com.standard.spring_rest.infrastructure.adapter.entity.ProductEntity;

@Component
public class ProductRepositoryImpl implements ProductRepository {
    
    private final SpringProductRepository repository;

    public ProductRepositoryImpl(SpringProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Product> findAll() {
        return repository.findAll()
            .stream()
            .map(ProductEntity::toProduct)
            .collect(Collectors.toList());
    }

    @Override
    public Product findBySku(String sku) {
        return repository
            .findBySku(sku)
            .map(ProductEntity::toProduct)
            .orElseThrow(NotFoundException::new);
    }

    @Override
    public Product save(Product product) {
        var entity = new ProductEntity(product);
        repository.saveAndFlush(entity);
        return entity.toProduct();
    }

    @Override
    public void deleteBySku(String sku) {
        if (repository.existsBySku(sku) == false)
            throw new NotFoundException();
            
        repository.deleteBySku(sku);
    }
}
