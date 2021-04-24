package com.graphql.controller;

import com.graphql.domain.Address;
import com.graphql.service.AddressService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api")
public class AddressController {

    private static final Logger LOG = LoggerFactory.getLogger(AddressController.class);

    @Autowired
    AddressService addressService;

    @GetMapping(value = "address/{id}"
            , produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Address> getUserById(@PathVariable("id") Integer id) {
        return addressService.getAddressById(id);
    }
}
