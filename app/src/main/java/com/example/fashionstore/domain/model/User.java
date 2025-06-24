package com.example.fashionstore.domain.model;

public class User {
    private String userName;
    private String fullName;
    private String email;
    private String password;

    public User(String fullName,
                String email,
                String password,
                String userName) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.userName = userName;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }
}
