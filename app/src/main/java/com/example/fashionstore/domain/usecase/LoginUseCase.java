package com.example.fashionstore.domain.usecase;

import com.example.fashionstore.domain.model.User;
import com.example.fashionstore.domain.iRepository.IUserRepository;

public class LoginUseCase {
    private final IUserRepository repo;

    public LoginUseCase(IUserRepository repo) {
        this.repo = repo;
    }

    public User login(String email, String password) {
        User user = repo.getUserByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }
}
