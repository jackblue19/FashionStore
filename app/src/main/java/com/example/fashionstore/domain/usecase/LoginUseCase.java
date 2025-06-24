package com.example.fashionstore.domain.usecase;

import com.example.fashionstore.domain.iRepository.callback.OnUserFetchedCallback;
import com.example.fashionstore.domain.model.User;
import com.example.fashionstore.domain.iRepository.IUserRepository;

public class LoginUseCase {
    private final IUserRepository repo;

    public LoginUseCase(IUserRepository repo) {
        this.repo = repo;
    }

    public void login(String email, String password, OnUserFetchedCallback callback) {
        repo.getUserByEmail(email, user -> {
            if (user != null && user.getPassword().equals(password)) {
                callback.onResult(user);
            } else {
                callback.onResult(null);
            }
        });
    }

}
