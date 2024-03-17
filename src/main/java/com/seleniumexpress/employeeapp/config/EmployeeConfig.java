package com.seleniumexpress.employeeapp.config;

import com.seleniumexpress.employeeapp.feingclient.AddressClient;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class EmployeeConfig {

    @Value("${address.service.base.url}")
    private String addressBase;

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
