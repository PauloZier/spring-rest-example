package br.com.standard.spring_rest.api.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.standard.spring_rest.domain.dto.ProductDto;
import br.com.standard.spring_rest.domain.dto.UpdateProductPriceDto;
import br.com.standard.spring_rest.domain.ports.interfaces.ProductService;
import jakarta.transaction.Transactional;

import org.springframework.web.bind.annotation.ResponseStatus;


@RestController
@RequestMapping(ProductController.PATH)
public class ProductController {
    
    public static final String PATH = "/product";
    
    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<List<ProductDto>> getAll() {
        var list = service.getProducts();
        return ResponseEntity.ok(list);
    }

    @GetMapping(value="/{sku}")
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<ProductDto> getBySku(@PathVariable String sku) {
        var product = service.getBySku(sku);
        return ResponseEntity.ok(product);
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto product) {
        service.create(product);
        var uri = URI.create(PATH + "/" + product.getSku());
        return ResponseEntity.created(uri).body(product);
    }

    @PutMapping(value = "/{sku}")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public ResponseEntity<ProductDto> updateProduct(@PathVariable String sku, @RequestBody ProductDto product) {
        service.update(sku, product);
        return ResponseEntity.accepted().body(product);
    }

    @PatchMapping(value = "/{sku}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public ResponseEntity<Object> updateProductPrice(@PathVariable String sku, @RequestBody UpdateProductPriceDto product) {
        service.updatePrice(product);
        return ResponseEntity.noContent().build();
    }

    @Transactional
    @DeleteMapping(value = "/{sku}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public ResponseEntity<Object> deleteProduct(@PathVariable String sku) {
        service.delete(sku);
        return ResponseEntity.noContent().build();
    }
}
