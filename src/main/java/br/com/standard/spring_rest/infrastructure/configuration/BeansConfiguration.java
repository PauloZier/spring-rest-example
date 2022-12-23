package br.com.standard.spring_rest.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.standard.spring_rest.domain.adapter.service.ProductServiceImpl;
import br.com.standard.spring_rest.domain.ports.interfaces.ProductService;
import br.com.standard.spring_rest.domain.ports.repositories.ProductRepository;

@Configuration
public class BeansConfiguration {

    @Bean 
    public ProductService getProductService(ProductRepository productRepository) {
        return new ProductServiceImpl(productRepository);
    }
}
