package br.com.standard.hexagonal_architecture.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.standard.hexagonal_architecture.domain.adapter.service.ProductServiceImpl;
import br.com.standard.hexagonal_architecture.domain.ports.interfaces.ProductService;
import br.com.standard.hexagonal_architecture.domain.ports.repositories.ProductRepository;

@Configuration
public class BeansConfiguration {

    @Bean 
    public ProductService getProductService(ProductRepository productRepository) {
        return new ProductServiceImpl(productRepository);
    }
}
