package com.graphql.domain;

public class User {

    private Integer id;
    private String firstName;
    private Integer age;

    public User(Integer id, String firstName, Integer age) {
        this.id = id;
        this.firstName = firstName;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }


    public String getFirstName() {
        return firstName;
    }

    public Integer getAge() {
        return age;
    }

}
