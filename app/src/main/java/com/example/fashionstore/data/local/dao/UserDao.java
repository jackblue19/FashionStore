package com.example.fashionstore.data.local.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import com.example.fashionstore.data.local.entity.UserEntity;

@Dao
public interface UserDao {

    @Insert
    void insertUser(UserEntity user);

    @Query("SELECT * FROM users WHERE email = :email LIMIT 1")
    UserEntity getUserByEmail(String email);

    @Query("SELECT * FROM users WHERE username = :usn LIMIT 1")
    UserEntity getUserByUsn(String usn);

    @Query("SELECT * FROM users WHERE email = :email AND password = :password LIMIT 1")
    UserEntity loginByEmail(String email, String password);

    @Query("SELECT * FROM users WHERE username = :usn AND password = :password LIMIT 1")
    UserEntity loginByUsn(String usn, String password);
}
