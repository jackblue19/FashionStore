package com.example.fashionstore.domain.iRepository;

import com.example.fashionstore.domain.model.User;
import com.example.fashionstore.domain.iRepository.callback.OnUserFetchedCallback;

public interface IUserRepository {
    void register(User user);
    void getUserByEmail(String email, OnUserFetchedCallback callback);
    void getUserByUsn(String usn, OnUserFetchedCallback callback);
}
