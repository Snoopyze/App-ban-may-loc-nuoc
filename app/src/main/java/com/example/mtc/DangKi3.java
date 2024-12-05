package com.example.mtc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DangKi3 extends AppCompatActivity {

    private TextView phoneNumberTxt;
    private Button signupBtn;
    private ImageView backBtn;

    private String phoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangki3);

        backBtn = findViewById(R.id.icBackDK3);
        phoneNumberTxt = findViewById(R.id.phoneNumber);
        signupBtn = findViewById(R.id.signupButton);

        phoneNumber = getIntent().getStringExtra("phoneNumber");

        backBtn.setOnClickListener(view -> {
            Intent intent = new Intent(DangKi3.this, DangKi2.class);
            startActivity(intent);
        });

        if (phoneNumber != null) {
            phoneNumberTxt.setText(phoneNumber);
        }

        signupBtn.setOnClickListener(view -> {
            Toast.makeText(DangKi3.this, "Đăng kí thành công",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(DangKi3.this, DangNhap.class);
            startActivity(intent);
        });
    }
}