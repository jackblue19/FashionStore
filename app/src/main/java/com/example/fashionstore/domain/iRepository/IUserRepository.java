package com.example.fashionstore.domain.iRepository;

import com.example.fashionstore.data.local.entity.UserEntity;
import com.example.fashionstore.domain.model.User;

public interface IUserRepository {
    void register(User user);
    User getUserByEmail(String email);
    User getUserByUsn(String usn);
}
