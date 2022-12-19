package br.com.standard.hexagonal_architecture.domain.adapter.service;

import java.util.List;
import java.util.stream.Collectors;

import br.com.standard.hexagonal_architecture.domain.entity.Product;
import br.com.standard.hexagonal_architecture.domain.dto.ProductDto;
import br.com.standard.hexagonal_architecture.domain.dto.UpdateProductPriceDto;
import br.com.standard.hexagonal_architecture.domain.ports.interfaces.ProductService;
import br.com.standard.hexagonal_architecture.domain.ports.repositories.ProductRepository;

public class ProductServiceImpl implements ProductService {
    
    private final ProductRepository repository;

    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public void create(ProductDto productDto) {
        repository.save(productDto.toProduct());
    }

    @Override
    public List<ProductDto> getProducts() {
        return repository
            .findAll()
            .stream()
            .map(Product::toProductDto)
            .collect(Collectors.toList());
    }

    @Override
    public void updatePrice(UpdateProductPriceDto updatePrice) {
        var product = repository.findBySku(updatePrice.getSku());
        product.updatePrice(updatePrice.getPrice());
        repository.save(product);
    }

    @Override
    public ProductDto getBySku(String sku) {
        var product = repository.findBySku(sku);
        return product.toProductDto();
    }

    @Override
    public void update(String sku, ProductDto productDto) {
        var product = repository.findBySku(sku);
        product.updateProduct(productDto.getDescription(), productDto.getSku(), productDto.getPrice(), productDto.getQuantity());
        repository.save(product);
    }

    @Override
    public void delete(String sku) {
        repository.deleteBySku(sku);
    }
}
