package ru.netology.springbootrestauthorizationservice.repository;

import org.springframework.stereotype.Repository;
import ru.netology.springbootrestauthorizationservice.exception.InvalidCredentials;
import ru.netology.springbootrestauthorizationservice.model.Authorities;
import ru.netology.springbootrestauthorizationservice.model.User;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class UserRepository {
    private final Map<String, User> users;

    public UserRepository() {
        users = new ConcurrentHashMap<>();

        // for test
        registration("Anna", "123");
        users.get("Anna").addAuthoritiesToList(Authorities.READ);
        registration("Petr", "456");
    }

    public void registration(String name, String password) {
        User user = new User(name, password);
        users.put(user.getName(), user);
    }

    public List<Authorities> getUserAuthorities(String userName, String password) {


        if (users.containsKey(userName) && users.get(userName).getPassword().equals(password)) {
            return users.get(userName).getList();
        } else {
            throw new InvalidCredentials("Username or password invalid");
        }
    }
}
