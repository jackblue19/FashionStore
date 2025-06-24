package com.example.fashionstore.domain.usecase;

import com.example.fashionstore.domain.model.User;
import com.example.fashionstore.domain.iRepository.IUserRepository;

public class RegisterUseCase {
    private final IUserRepository repo;

    public RegisterUseCase(IUserRepository repo) {
        this.repo = repo;
    }

    public void register(User user) {
        repo.register(user);
    }
}
