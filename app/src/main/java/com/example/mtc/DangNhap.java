package com.example.mtc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DangNhap extends AppCompatActivity {

    private TextView signupTxt, forgotPWTxt;
    private Button loginBtn;
    private ImageView backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dangnhap);

        backBtn = findViewById(R.id.icBack);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DangNhap.this, XinChao.class);
                startActivity(intent);
            }
        });

        forgotPWTxt = findViewById(R.id.forgotPassword);
        forgotPWTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DangNhap.this, QuenMatKhau.class);
                startActivity(intent);
            }
        });

        loginBtn = findViewById(R.id.loginButton);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(DangNhap.this, TrangChu.class);
                startActivity(intent);

//                Intent intent = new Intent(DangNhap.this, TrangChu.class);
//                startActivity(intent);
            }
        });
        signupTxt = findViewById(R.id.singupTxt);

        signupTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(DangNhap.this, DangKi.class);
                startActivity(intent);
            }
        });
    }
}