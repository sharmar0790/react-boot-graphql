package com.graphql.domain;

public class Address {

    private Integer id;
    private String address1;
    private String address2;

    public Address(Integer id, String address1, String address2) {
        this.id = id;
        this.address1 = address1;
        this.address2 = address2;
    }

    public Integer getId() {
        return id;
    }

    public String getAddress1() {
        return address1;
    }

    public String getAddress2() {
        return address2;
    }

}