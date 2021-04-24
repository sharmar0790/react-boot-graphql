package com.graphql.service;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AddressServiceTest {

    private AddressService service = new AddressService();

    @Test
    public void testGetAddressById() {
        assertThat(service.getAddressById(5)).isNotNull();
    }


}
