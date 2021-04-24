package com.graphql.service;

import com.graphql.domain.User;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class UserServiceTest {

    private UserService service = new UserService();

    @Test
    public void testGetUserById() {
        assertThat(service.getUserById(1)).isNotNull();
    }

    @Test
    public void testGetAllUsers() {
        assertThat(service.getAllUsers()).isNotNull();
//        assertThat(service.getAllUsers()).hasSize(5);
    }

    @Test
    public void testAddUser() {
        User xaq = new User(6, "XAQ", 12);
        assertThat(service.addUser(xaq)).isNotNull();
    }

}
