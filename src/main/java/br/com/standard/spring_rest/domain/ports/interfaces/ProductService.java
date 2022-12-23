package br.com.standard.spring_rest.domain.ports.interfaces;

import java.util.List;

import br.com.standard.spring_rest.domain.dto.ProductDto;
import br.com.standard.spring_rest.domain.dto.UpdateProductPriceDto;

public interface ProductService {
    void create(ProductDto productDto);
    List<ProductDto> getProducts();
    void updatePrice(UpdateProductPriceDto updatePrice);
    ProductDto getBySku(String sku);
    void update(String sku, ProductDto productDto);
    void delete(String sku);
}
