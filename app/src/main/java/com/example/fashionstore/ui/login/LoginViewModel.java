package com.example.fashionstore.ui.login;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.fashionstore.data.repository.user.UserRepositoryImpl;
import com.example.fashionstore.domain.model.User;
import com.example.fashionstore.domain.usecase.LoginUseCase;

public class LoginViewModel extends AndroidViewModel {

    private final LoginUseCase loginUseCase;

    public LoginViewModel(@NonNull Application application) {
        super(application);
        loginUseCase = new LoginUseCase(new UserRepositoryImpl(application));
    }

    public User login(String email, String password) {
        return loginUseCase.login(email, password);
    }
}
