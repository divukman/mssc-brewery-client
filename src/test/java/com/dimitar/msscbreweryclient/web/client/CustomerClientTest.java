package com.dimitar.msscbreweryclient.web.client;

import com.dimitar.msscbreweryclient.web.model.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerClientTest {

    @Autowired
    CustomerClient customerClient;

    @Test
    void getCustomerById() {
        final CustomerDto customerDto = customerClient.getCustomerById(UUID.randomUUID());
        assertNotNull(customerDto);
    }

    @Test
    void createCustomer() {
        final CustomerDto customerDto = CustomerDto.builder()
                .id(UUID.randomUUID())
                .name("John")
                .build();

        final URI uri = customerClient.createCustomer(customerDto);
        assertNotNull(uri);
    }

    @Test
    void updateCustomer() {
        final CustomerDto customerDto = CustomerDto.builder()
                .id(UUID.randomUUID())
                .name("John")
                .build();

        customerClient.updateCustomer(customerDto.getId(), customerDto);
    }

    @Test
    void deleteCustomer() {
        customerClient.deleteCustomer(UUID.randomUUID());
    }
}