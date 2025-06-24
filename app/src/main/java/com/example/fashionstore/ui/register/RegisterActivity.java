package com.example.fashionstore.ui.register;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.fashionstore.R;
import com.example.fashionstore.domain.model.User;
import com.example.fashionstore.ui.login.LoginActivity;

public class RegisterActivity extends AppCompatActivity {

    private EditText edtUsername, edtEmail, edtPassword, edtConfirmPassword, edtFullname;
    private Button btnRegister;
    private TextView goToLogin;
    private RegisterViewModel registerViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

//        edtUsername = findViewById(R.id.fullNameEditText);
        edtFullname = findViewById(R.id.fullNameEditText);
        edtEmail = findViewById(R.id.emailEditText);
        edtPassword = findViewById(R.id.passwordEditText);
        edtConfirmPassword = findViewById(R.id.confirmPasswordEditText);
        btnRegister = findViewById(R.id.registerButton);
        goToLogin = findViewById(R.id.goToLogin);

        registerViewModel = new ViewModelProvider(this).get(RegisterViewModel.class);

        btnRegister.setOnClickListener(v -> {
            String username = edtFullname.getText().toString().trim();
            String fullname = edtFullname.getText().toString().trim();
            String email = edtEmail.getText().toString().trim();
            String password = edtPassword.getText().toString().trim();
            String confirm = edtConfirmPassword.getText().toString().trim();

            if (/*username.isEmpty() ||*/ email.isEmpty() || password.isEmpty() || confirm.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            if (!password.equals(confirm)) {
                Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                return;
            }

            User user = new User("fullname", email, password, username);
            registerViewModel.registerUser(user);
            Toast.makeText(this, "Registered successfully", Toast.LENGTH_SHORT).show();

            startActivity(new Intent(this, LoginActivity.class));
            finish();
        });

        goToLogin.setOnClickListener(v -> {
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        });
    }
}
