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

public class DangKi3 extends AppCompatActivity {

    private TextView phoneNumberTxt;
    private Button signupBtn;
    private ImageView backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangki3);

        backBtn = findViewById(R.id.icBackDK3);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DangKi3.this, DangKi2.class);
                startActivity(intent);
            }
        });
        phoneNumberTxt = findViewById(R.id.phoneNumber);

        String phoneNumber = getIntent().getStringExtra("PHONE_NUMBER");
        if (phoneNumber != null) {
            phoneNumberTxt.setText(phoneNumber);
        }
        signupBtn = findViewById(R.id.signupButton);
        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(DangKi3.this, DangNhap.class);
                startActivity(intent);
            }
        });
    }
}