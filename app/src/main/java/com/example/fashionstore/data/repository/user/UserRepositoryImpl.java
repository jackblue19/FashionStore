package com.example.fashionstore.data.repository.user;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;

import com.example.fashionstore.data.local.AppDatabase;
import com.example.fashionstore.data.local.entity.UserEntity;
import com.example.fashionstore.domain.iRepository.IUserRepository;
import com.example.fashionstore.domain.model.User;
import com.example.fashionstore.domain.iRepository.callback.OnUserFetchedCallback;

import java.util.concurrent.Executors;

public class UserRepositoryImpl implements IUserRepository {
    private final AppDatabase db;

    public UserRepositoryImpl(Context context) {
        db = AppDatabase.getInstance(context);
    }

    @Override
    public void register(User user) {
        UserEntity entity = new UserEntity(
                user.getFullName(),
                user.getUserName(),
                user.getEmail(),
                user.getPassword()
        );
        Executors.newSingleThreadExecutor().execute(() -> db.userDao().insertUser(entity));
    }

    @Override
    public void getUserByEmail(String email, OnUserFetchedCallback callback) {
        Executors.newSingleThreadExecutor().execute(() -> {
            UserEntity entity = db.userDao().getUserByEmail(email);
            User user = (entity != null)
                    ? new User(entity.fullName, entity.username, entity.email, entity.password)
                    : null;
            new Handler(Looper.getMainLooper()).post(() -> callback.onResult(user));
        });
    }

    @Override
    public void getUserByUsn(String usn, OnUserFetchedCallback callback) {
        Executors.newSingleThreadExecutor().execute(() -> {
            UserEntity entity = db.userDao().getUserByUsn(usn);
            User user = (entity != null)
                    ? new User(entity.fullName, entity.username, entity.email, entity.password)
                    : null;
            new Handler(Looper.getMainLooper()).post(() -> callback.onResult(user));
        });
    }
}
