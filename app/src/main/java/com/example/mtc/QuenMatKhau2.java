package com.example.mtc;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class QuenMatKhau2 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_quenmatkhau2);

        String phoneNumber = getIntent().getStringExtra("PHONE_NUMBER");

        // Hiển thị số điện thoại
        TextView phoneNumberTextView = findViewById(R.id.phoneNumber);
        if (phoneNumber != null) {
            phoneNumberTextView.setText(phoneNumber);
        }
    }
}