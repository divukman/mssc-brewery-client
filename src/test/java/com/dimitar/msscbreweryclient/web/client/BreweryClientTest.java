package com.dimitar.msscbreweryclient.web.client;

import com.dimitar.msscbreweryclient.web.model.BeerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BreweryClientTest {

    @Autowired
    BreweryClient breweryClient;

    @Test
    void getBeerById() {
        BeerDto beerDto = breweryClient.getBeerById(UUID.randomUUID());
        assertNotNull(beerDto);
    }

    @Test
    void saveNewBeer() {
        final BeerDto beerDto = BeerDto.builder()
                .beerName("Karlovacko")
                .id(UUID.randomUUID())
                .build();

        URI uri = breweryClient.saveNewBeer(beerDto);
        assertNotNull(uri);
    }

    @Test
    void updateBeer() {
        final BeerDto beerDto = BeerDto.builder()
                .beerName("Karlovacko")
                .id(UUID.randomUUID())
                .build();

        breweryClient.updateBeer(beerDto.getId(), beerDto);
    }

    @Test
    void deleteBeer() {
        breweryClient.deleteBeer(UUID.randomUUID());
    }
}