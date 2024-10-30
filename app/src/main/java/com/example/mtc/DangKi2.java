package com.example.mtc;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DangKi2 extends AppCompatActivity {

    private TextView countDownTxt, resendCodeTxt;
    private CountDownTimer countDownTimer;
    private ImageView backBtn;
    private static final int OTP_VALID_DURATION = 120000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangki2);

        backBtn = findViewById(R.id.icBackDK2);
        countDownTxt = findViewById(R.id.countDownTxt);
        resendCodeTxt = findViewById(R.id.resendCodeTxt);
        Button contBtn = findViewById(R.id.contBtn);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DangKi2.this, DangKi.class);
                startActivity(intent);
            }
        });
        String phoneNumber = getIntent().getStringExtra("PHONE_NUMBER");

        // Hiển thị số điện thoại
        TextView phoneNumberTextView = findViewById(R.id.phoneNumber);
        if (phoneNumber != null) {
            phoneNumberTextView.setText(phoneNumber);
        }

        contBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String phoneNumber = getIntent().getStringExtra("PHONE_NUMBER");

                Intent intent = new Intent(DangKi2.this, DangKi3.class);
                intent.putExtra("PHONE_NUMBER", phoneNumber);
                startActivity(intent);
            }
        });
        // Bắt đầu đếm ngược
        startCountdown();

        // Sự kiện khi nhấn vào nút "Gửi lại mã"
        resendCodeTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Khởi động lại đếm ngược khi gửi lại mã
                startCountdown();
                // Thực hiện gửi lại mã OTP
            }
        });
    }

    private void startCountdown() {
        if (countDownTimer != null) {
            countDownTimer.cancel(); // Hủy bỏ đếm ngược cũ nếu có
        }

        countDownTimer = new CountDownTimer(OTP_VALID_DURATION, 1000) {

            public void onTick(long millisUntilFinished) {
                // Cập nhật số giây còn lại vào TextView
                long secondsRemaining = millisUntilFinished / 1000;
                countDownTxt.setText("Mã xác thực (OTP) có hiệu lực trong " + secondsRemaining + "s đã được gửi đến SMS của số ");
            }

            public void onFinish() {
                // Hành động khi kết thúc đếm ngược
                countDownTxt.setText("Mã xác thực đã hết hiệu lực.");
            }
        }.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }
}