package com.example.mtc;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class QuenMatKhau3 extends AppCompatActivity {

    private ImageView backBtn, showPass, showAppliedPass;
    private Button contBtn;
    private EditText passWord, appliedPassWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_quenmatkhau3);

        backBtn = findViewById(R.id.icBackQMK3);
        contBtn = findViewById(R.id.signupBtn);
        showPass = findViewById(R.id.eyeIc1);
        showAppliedPass = findViewById(R.id.eyeIc2);
        passWord = findViewById(R.id.passwordETxt);
        appliedPassWord = findViewById(R.id.acpPassETxt);

        backBtn.setOnClickListener(view -> {

            Intent intent = new Intent(QuenMatKhau3.this, QuenMatKhau2.class);
            startActivity(intent);
        });

        contBtn.setOnClickListener(view -> {
            Toast.makeText(this,"Đổi mật khẩu thành công",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(QuenMatKhau3.this, DangNhap.class);
            startActivity(intent);
        });

        showPass.setOnClickListener(v -> {

            if (passWord.getTransformationMethod() instanceof PasswordTransformationMethod) {

                passWord.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                showPass.setImageResource(R.drawable.icon_eye_open_c);
            } else {

                passWord.setTransformationMethod(PasswordTransformationMethod.getInstance());
                showPass.setImageResource(R.drawable.icon_eye_c);
            }
        });
        showAppliedPass.setOnClickListener(v -> {

            if (appliedPassWord.getTransformationMethod() instanceof PasswordTransformationMethod) {
                appliedPassWord.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                showAppliedPass.setImageResource(R.drawable.icon_eye_open_c);
            } else {
                appliedPassWord.setTransformationMethod(PasswordTransformationMethod.getInstance());
                showAppliedPass.setImageResource(R.drawable.icon_eye_c);
            }
        });
    }
}