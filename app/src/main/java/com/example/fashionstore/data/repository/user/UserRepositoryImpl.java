package com.example.fashionstore.data.repository.user;

import android.content.Context;

import com.example.fashionstore.data.local.AppDatabase;
import com.example.fashionstore.data.local.entity.UserEntity;
import com.example.fashionstore.domain.model.User;
import com.example.fashionstore.domain.iRepository.IUserRepository;

public class UserRepositoryImpl implements IUserRepository {
    private final AppDatabase db;

    public UserRepositoryImpl(Context context) {
        db = AppDatabase.getInstance(context);
    }

    @Override
    public void register(User user) {
        UserEntity entity = new UserEntity(user.getFullName(), user.getUserName(), user.getEmail(), user.getPassword());
        new Thread(() -> db.userDao().insertUser(entity)).start();
    }

    @Override
    public User getUserByEmail(String email) {
        UserEntity entity = db.userDao().getUserByEmail(email);
        return (entity != null)
                ? new User(entity.fullName, entity.username, entity.email, entity.password)
                : null;
    }

    @Override
    public User getUserByUsn(String usn) {
        UserEntity entity = db.userDao().getUserByUsn(usn);
        return (entity != null)
                ? new User(entity.fullName, entity.username, entity.email, entity.password)
                : null;
    }
}
