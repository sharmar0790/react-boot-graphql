package com.graphql.service;

import com.graphql.domain.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private static List<User> USER_LIST = Collections.synchronizedList(new ArrayList<>());

    static {
        USER_LIST = new ArrayList<>() {{
            add(new User(1, "A", 12));
            add(new User(2, "B", 15));
            add(new User(3, "C", 23));
            add(new User(4, "D", 21));
            add(new User(5, "E", 65));
        }};
    }

    public User getUserById(final Integer id) {
        return USER_LIST
                .stream()
                .filter(l -> l.getId().equals(id))
                .collect(Collectors.toList()).get(0);
    }

    public List<User> getAllUsers() {
        return USER_LIST;
    }

    public User addUser(final User user) {
        int id = USER_LIST.size() + 1;
        USER_LIST.add(new User(id, user.getFirstName(), user.getAge()));
        System.out.println(USER_LIST.get(USER_LIST.size()-1));
        return USER_LIST.get(USER_LIST.size()-1);
    }
}
