package ru.netology.springbootrestauthorizationservice.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

public class User {
    @NotBlank
    @Size(min = 2, max = 20)
    private String name;
    @Min(3)
    private String password;

    private List<Authorities> list;

    public User() {
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
        list = new ArrayList<>();
    }

    public String getName() {
        return name;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Authorities> getList() {
        return list;
    }

    public void addAuthoritiesToList(Authorities authorities) {
        list.add(authorities);
    }

}
