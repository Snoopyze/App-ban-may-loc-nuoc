package com.example.mtc;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
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

public class QuenMatKhau2 extends AppCompatActivity {

    private ImageView backBtn;
    private Button contBtn;
    private TextView countDownTxt, resendCodeTxt;
    private CountDownTimer countDownTimer;
    private static final int OTP_VALID_DURATION = 120000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_quenmatkhau2);

        backBtn = findViewById(R.id.icBackQMK2);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(QuenMatKhau2.this, QuenMatKhau.class);
                startActivity(intent);
            }
        });

        String phoneNumber = getIntent().getStringExtra("PHONE_NUMBER");

        // Hiển thị số điện thoại
        TextView phoneNumberTextView = findViewById(R.id.phoneNumber);
        if (phoneNumber != null) {
            phoneNumberTextView.setText(phoneNumber);
        }

        countDownTxt = findViewById(R.id.countDownTxt);
        resendCodeTxt = findViewById(R.id.resendCodeTxt);

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

        contBtn = findViewById(R.id.contBtnQMK);
        contBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(QuenMatKhau2.this, QuenMatKhau3.class);
                startActivity(intent);
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