package com.example.mtc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DangKi extends AppCompatActivity {

    private EditText phoneNumberETxt;
    private Button signUpBtn;
    private TextView loginTxt;
    private ImageView backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dangki);

        backBtn = findViewById(R.id.icBackDK);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DangKi.this, DangNhap.class);
                startActivity(intent);
            }
        });

        phoneNumberETxt = findViewById(R.id.phoneNumber);

        signUpBtn = findViewById(R.id.signupBtn);
        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lấy số điện thoại người dùng nhập
                String phoneNumber = phoneNumberETxt.getText().toString();

                Intent intent = new Intent(DangKi.this, DangKi2.class);
                intent.putExtra("PHONE_NUMBER", phoneNumber);
                startActivity(intent);
            }
        });

        loginTxt = findViewById(R.id.logInTxt);
        loginTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(DangKi.this, DangNhap.class);
                startActivity(intent);
            }
        });
    }
}