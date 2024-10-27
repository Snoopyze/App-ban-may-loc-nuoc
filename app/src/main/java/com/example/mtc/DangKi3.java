package com.example.mtc;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DangKi3 extends AppCompatActivity {

    private TextView phoneNumberTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangki3);

        phoneNumberTxt = findViewById(R.id.phoneNumber);

        // Lấy số điện thoại từ Intent
        String phoneNumber = getIntent().getStringExtra("PHONE_NUMBER");

        // Hiển thị số điện thoại lên TextView
        if (phoneNumber != null) {
            phoneNumberTxt.setText(phoneNumber);
        }
    }
}