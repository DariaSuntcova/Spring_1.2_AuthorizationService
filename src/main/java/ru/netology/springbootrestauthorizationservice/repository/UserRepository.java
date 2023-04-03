package ru.netology.springbootrestauthorizationservice.repository;

import org.springframework.stereotype.Repository;
import ru.netology.springbootrestauthorizationservice.exception.InvalidCredentials;
import ru.netology.springbootrestauthorizationservice.model.Authorities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepository {

    private List<Authorities> list;
    private Map<String, String> users;

    public UserRepository() {
        users = new HashMap<>();
        // for test
        users.put("Anna", "123");
        users.put("Petr", "456");
    }

    public List<Authorities> getUserAuthorities(String user, String password) {

        if (users.containsKey(user) && users.get(user).equals(password)) {
            list = new ArrayList<>();
            if (user.equals("Anna")) {
                list.add(Authorities.READ);
            }
        } else {
            throw new InvalidCredentials("Username or password invalid");
        }

        return list;
    }
}
