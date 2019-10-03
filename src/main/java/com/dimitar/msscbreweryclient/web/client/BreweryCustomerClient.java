package com.dimitar.msscbreweryclient.web.client;

import com.dimitar.msscbreweryclient.web.model.CustomerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@Component
public class BreweryCustomerClient {
    private final RestTemplate restTemplate;
    private final RestClientConfig restClientConfig;

    @Autowired
    public BreweryCustomerClient(RestTemplateBuilder restTemplateBuilder, RestClientConfig restClientConfig) {
        this.restTemplate = restTemplateBuilder.build();
        this.restClientConfig = restClientConfig;
    }

    public CustomerDto getCustomerById(final UUID uuid) {
        return this.restTemplate.getForObject(restClientConfig.getApiHost() + RestClientConfig.CUSTOMER_PATH_V1 + uuid.toString(), CustomerDto.class);
    }

    public URI createCustomer(final CustomerDto customerDto) {
        return this.restTemplate.postForLocation(restClientConfig.getApiHost() + RestClientConfig.CUSTOMER_PATH_V1, customerDto);
    }

    public void updateCustomer(UUID uuid, CustomerDto customerDto) {
        this.restTemplate.put(restClientConfig.getApiHost() + RestClientConfig.CUSTOMER_PATH_V1 + uuid.toString(), customerDto);
    }

    public void deleteCustomer(UUID uuid) {
        this.restTemplate.delete(restClientConfig.getApiHost() + RestClientConfig.CUSTOMER_PATH_V1 + uuid.toString());
    }

}
