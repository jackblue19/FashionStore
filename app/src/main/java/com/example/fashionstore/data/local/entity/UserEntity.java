package com.example.fashionstore.data.local.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "users")
public class UserEntity {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "username")
    @NonNull
    public String username;
    @ColumnInfo(name = "name")
    @NonNull
    public String fullName;
    @ColumnInfo(name = "email")
    @NonNull
    public String email;
    @ColumnInfo(name = "password")
    @NonNull
    public String password;

    public UserEntity(@NonNull String fullName,
                      @NonNull String email,
                      @NonNull String password,
                      @NonNull String usn) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        username = usn;
    }
    public UserEntity() {}
}
