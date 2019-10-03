package com.dimitar.msscbreweryclient.web.client;

import com.dimitar.msscbreweryclient.web.model.BeerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@Component
public class BreweryBeerClient {
    private final RestTemplate restTemplate;
    private final RestClientConfig restClientConfig;

    @Autowired
    public BreweryBeerClient(RestTemplateBuilder restTemplateBuilder, RestClientConfig restClientConfig) {
        this.restTemplate = restTemplateBuilder.build();
        this.restClientConfig = restClientConfig;
    }

    public BeerDto getBeerById(UUID uuid) {
        return restTemplate.getForObject(restClientConfig.getApiHost() + RestClientConfig.BEER_PATH_V1 + uuid.toString(), BeerDto.class);
    }

    public URI saveNewBeer(final BeerDto beerDto) {
        return restTemplate.postForLocation(restClientConfig.getApiHost() + RestClientConfig.BEER_PATH_V1, beerDto);
    }

    public void updateBeer(UUID uuid, BeerDto beerDto) {
        restTemplate.put(restClientConfig.getApiHost() + RestClientConfig.BEER_PATH_V1 + uuid.toString(), beerDto);
    }

    public void deleteBeer(UUID uuid) {
        restTemplate.delete(restClientConfig.getApiHost() + RestClientConfig.BEER_PATH_V1 + uuid.toString());
    }
}
