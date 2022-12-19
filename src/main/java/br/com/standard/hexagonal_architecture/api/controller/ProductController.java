package br.com.standard.hexagonal_architecture.api.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.standard.hexagonal_architecture.domain.dto.ProductDto;
import br.com.standard.hexagonal_architecture.domain.dto.UpdateProductPriceDto;
import br.com.standard.hexagonal_architecture.domain.ports.interfaces.ProductService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;


@RestController
@RequestMapping(ProductController.PATH)
public class ProductController {
    
    private static final String PATH = "/product";

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProductDto>> getAll() {
        var list = service.getProducts();
        return ResponseEntity.ok(list);
    }

    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping(value="/{sku}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductDto> getBySku(@RequestParam String sku) {
        var product = service.getBySku(sku);
        return ResponseEntity.ok(product);
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto product) {
        service.create(product);
        var uri = URI.create(product.getSku());
        return ResponseEntity.created(uri).body(product);
    }

    @ResponseStatus(value = HttpStatus.ACCEPTED)
    @PutMapping(value = "/{sku}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductDto> updateProduct(@RequestParam String sku, @RequestBody ProductDto product) {
        service.update(sku, product);
        return ResponseEntity.accepted().body(product);
    }

    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @PatchMapping(value = "/{sku}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> updateProductPrice(@RequestParam String sku, @RequestBody UpdateProductPriceDto product) {
        service.updatePrice(product);
        return ResponseEntity.noContent().build();
    }

    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/{sku}")
    public ResponseEntity<Object> deleteProduct(@RequestParam String sku) {
        service.delete(sku);
        return ResponseEntity.noContent().build();
    }
}
