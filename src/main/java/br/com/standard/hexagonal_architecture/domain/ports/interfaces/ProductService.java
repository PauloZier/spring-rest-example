package br.com.standard.hexagonal_architecture.domain.ports.interfaces;

import java.util.List;

import br.com.standard.hexagonal_architecture.domain.dto.ProductDto;
import br.com.standard.hexagonal_architecture.domain.dto.UpdateProductPriceDto;

public interface ProductService {
    void create(ProductDto productDto);
    List<ProductDto> getProducts();
    void updatePrice(UpdateProductPriceDto updatePrice);
    ProductDto getBySku(String sku);
    void update(String sku, ProductDto productDto);
    void delete(String sku);
}
