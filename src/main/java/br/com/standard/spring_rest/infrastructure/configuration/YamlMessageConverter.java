package br.com.standard.spring_rest.infrastructure.configuration;

import org.springframework.http.MediaType;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;

import com.fasterxml.jackson.databind.ObjectMapper;

public class YamlMessageConverter extends AbstractJackson2HttpMessageConverter {

    public YamlMessageConverter(ObjectMapper objectMapper) {
        super(objectMapper, MediaType.parseMediaType("application/x-yaml"));
    }
    
}
