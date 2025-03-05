package com.example.changepassword2;

import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.example.changepassword2.R;


public class ChangePasswordActivity extends AppCompatActivity {

    private EditText etNewPassword, etConfirmPassword;
    private ImageView toggleNewPassword, toggleConfirmPassword;
    private boolean isPasswordVisible = false;
    private boolean isConfirmPasswordVisible = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        etNewPassword = findViewById(R.id.etNewPassword);
        etConfirmPassword = findViewById(R.id.etConfirmPassword);
        toggleNewPassword = findViewById(R.id.toggleNewPassword);
        toggleConfirmPassword = findViewById(R.id.toggleConfirmPassword);
        Button btnConfirm = findViewById(R.id.btnConfirm);
        ImageView btnBack = findViewById(R.id.btnBack);

        // Toggle visibility for new password
        toggleNewPassword.setOnClickListener(v -> {
            if (isPasswordVisible) {
                etNewPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                toggleNewPassword.setImageResource(android.R.drawable.ic_menu_view);
            } else {
                etNewPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                toggleNewPassword.setImageResource(android.R.drawable.ic_delete);
            }
            isPasswordVisible = !isPasswordVisible;
        });

        // Toggle visibility for confirm password
        toggleConfirmPassword.setOnClickListener(v -> {
            if (isConfirmPasswordVisible) {
                etConfirmPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                toggleConfirmPassword.setImageResource(android.R.drawable.ic_menu_view);
            } else {
                etConfirmPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                toggleConfirmPassword.setImageResource(android.R.drawable.ic_delete);
            }
            isConfirmPasswordVisible = !isConfirmPasswordVisible;
        });

        // Handle confirm button click
        btnConfirm.setOnClickListener(v -> {
            String newPassword = etNewPassword.getText().toString().trim();
            String confirmPassword = etConfirmPassword.getText().toString().trim();

            if (newPassword.isEmpty() || confirmPassword.isEmpty()) {
                Toast.makeText(ChangePasswordActivity.this, "Please enter both passwords", Toast.LENGTH_SHORT).show();
            } else if (!newPassword.equals(confirmPassword)) {
                Toast.makeText(ChangePasswordActivity.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
            } else if (newPassword.length() < 6) {
                Toast.makeText(ChangePasswordActivity.this, "Password must be at least 6 characters", Toast.LENGTH_SHORT).show();
            } else {
                // Handle password change logic (API call, save to database, etc.)
                Toast.makeText(ChangePasswordActivity.this, "Password changed successfully!", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        // Back button click event
        btnBack.setOnClickListener(v -> finish());
    }
}
