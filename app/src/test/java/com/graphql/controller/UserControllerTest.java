package com.graphql.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.graphql.domain.User;
import com.graphql.service.UserService;
import com.graphql.util.TestUtil;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = UserController.class)
public class UserControllerTest {

    private static List<User> USER_LIST = Collections.synchronizedList(new ArrayList<>());

    static {
        USER_LIST = new ArrayList<>() {{
            add(new User(1, "A", 12));
            add(new User(3, "C", 23));
            add(new User(2, "B", 15));
            add(new User(4, "D", 21));
            add(new User(5, "E", 65));
        }};
    }

    @Autowired
    private MockMvc mvc;
    @Autowired
    private ObjectMapper objMapper;
    @MockBean
    private UserService service;

    @Test
    public void testGetUserById() throws Exception {

        User u = new User(1, "A", 12);
        when(service.getUserById(u.getId())).thenReturn(u);
        mvc.perform(
                get("/api/users/{id}", u.getId())
                        .contentType("application/json"))
                .andExpect(status().isOk());

    }

    @Test
    public void testGetAllUsers() throws Exception {
        when(service.getAllUsers()).thenReturn(USER_LIST);

        mvc.perform(
                get("/api/users")
                        .contentType("application/json"))
                .andExpect(jsonPath("$", hasSize(5)));

    }

    @Test
    @Disabled
    public void testAddUser() throws Exception {
        User u = new User(1, "A", 12);
        when(service.addUser(u)).thenReturn(u);
        System.out.println("Adding user");
        mvc.perform(
                post("/api/users")
                        .content(TestUtil.convertObjectToJsonBytes(u))
                        .contentType("application/json")
                        .accept("application/json"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(jsonPath("$[0].age", equalTo(12)));

    }
}
