package com.graphql.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.graphql.domain.Address;
import com.graphql.service.AddressService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = AddressController.class)
public class AddressControllerTest {

    @Autowired
    private MockMvc mvc;
    @Autowired
    private ObjectMapper objMapper;
    @MockBean
    private AddressService service;


    @Test
    public void testGetAddressById() throws Exception {
        Address address = new Address(1, "A", "B");
        when(service.getAddressById(address.getId())).thenReturn(Arrays.asList(address));
        mvc.perform(
                get("/api/address/{id}", address.getId())
                        .contentType("application/json"))
                .andExpect(status().isOk());
    }


}
