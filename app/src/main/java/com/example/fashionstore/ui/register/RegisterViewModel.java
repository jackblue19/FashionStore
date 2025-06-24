package com.example.fashionstore.ui.register;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.fashionstore.data.repository.user.UserRepositoryImpl;
import com.example.fashionstore.domain.model.User;
import com.example.fashionstore.domain.usecase.RegisterUseCase;

public class RegisterViewModel extends AndroidViewModel {

    private final RegisterUseCase registerUseCase;

    public RegisterViewModel(@NonNull Application application) {
        super(application);
        registerUseCase = new RegisterUseCase(new UserRepositoryImpl(application));
    }

    public void registerUser(User user) {
        registerUseCase.register(user);
    }
}
