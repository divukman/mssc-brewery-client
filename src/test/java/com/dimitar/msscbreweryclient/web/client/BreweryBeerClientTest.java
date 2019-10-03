package com.dimitar.msscbreweryclient.web.client;

import com.dimitar.msscbreweryclient.web.model.BeerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BreweryBeerClientTest {

    @Autowired
    BreweryBeerClient breweryBeerClient;

    @Test
    void getBeerById() {
        BeerDto beerDto = breweryBeerClient.getBeerById(UUID.randomUUID());
        assertNotNull(beerDto);
    }

    @Test
    void saveNewBeer() {
        final BeerDto beerDto = BeerDto.builder()
                .beerName("Karlovacko")
                .id(UUID.randomUUID())
                .build();

        URI uri = breweryBeerClient.saveNewBeer(beerDto);
        assertNotNull(uri);
    }

    @Test
    void updateBeer() {
        final BeerDto beerDto = BeerDto.builder()
                .beerName("Karlovacko")
                .id(UUID.randomUUID())
                .build();

        breweryBeerClient.updateBeer(beerDto.getId(), beerDto);
    }

    @Test
    void deleteBeer() {
        breweryBeerClient.deleteBeer(UUID.randomUUID());
    }
}