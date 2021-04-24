package com.graphql.service;

import com.graphql.domain.Address;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AddressService {

    private static Map<Integer, List<Address>> ADDRESS_USER_MAP = Collections.synchronizedMap(new HashMap<>());

    static {
        ADDRESS_USER_MAP = new HashMap<>() {{
            put(1, Arrays.asList(new Address(1, "A1", "A2"),
                    new Address(5, "A5", "A9")));
            put(2, Arrays.asList(new Address(2, "A2", "A6")));
            put(3, Arrays.asList(new Address(3, "A3", "A7")));
            put(4, Arrays.asList(new Address(4, "A4", "A8")));
            put(5, Arrays.asList(new Address(5, "A5", "A9")));
        }};
    }


    public List<Address> getAddressById(Integer id) {
        return ADDRESS_USER_MAP.get(id);
    }
}
