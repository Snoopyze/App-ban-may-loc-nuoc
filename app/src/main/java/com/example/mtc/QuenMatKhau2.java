package com.example.mtc;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class QuenMatKhau2 extends AppCompatActivity {

    private ImageView backBtn;
    private EditText otp1, otp2, otp3, otp4, otp5, otp6;
    private Button contBtn;
    private TextView phoneNumeberTxt, countDownTxt, resendCodeQMKTxt;

    private long timeOutSeconds = 60L;

    private FirebaseAuth mAuth;
    private String verificationCode;
    private String phoneNumber;
    private PhoneAuthProvider.ForceResendingToken resendingToken;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_quenmatkhau2);

        otp1 = findViewById(R.id.otp1QMK);
        otp2 = findViewById(R.id.otp2QMK);
        otp3 = findViewById(R.id.otp3QMK);
        otp4 = findViewById(R.id.otp4QMK);
        otp5 = findViewById(R.id.otp5QMK);
        otp6 = findViewById(R.id.otp6QMK);
        backBtn = findViewById(R.id.icBackQMK2);
        phoneNumeberTxt = findViewById(R.id.phoneNumberTxt);
        countDownTxt = findViewById(R.id.countDownTxt);
        resendCodeQMKTxt = findViewById(R.id.resendCodeTxt);
        contBtn = findViewById(R.id.contBtnQMK);
        mAuth = FirebaseAuth.getInstance();

        backBtn.setOnClickListener(view -> {
            Intent intent = new Intent(QuenMatKhau2.this, QuenMatKhau.class);
            startActivity(intent);
        });

        verificationCode = getIntent().getStringExtra("OTP");
        phoneNumber = getIntent().getStringExtra("phoneNumber");
        resendingToken = getIntent().getParcelableExtra("resendToken");

        if (phoneNumber != null) {
            phoneNumeberTxt.setText(phoneNumber);
        }

        contBtn.setOnClickListener(v -> {
            String otp = otp1.getText().toString() + otp2.getText().toString() + otp3.getText().toString() +
                    otp4.getText().toString() + otp5.getText().toString() + otp6.getText().toString();
            PhoneAuthCredential phoneAuthCredential = PhoneAuthProvider.getCredential(verificationCode, otp);
            signIn(phoneAuthCredential);

            if (otp.length() < 6) {
                Toast.makeText(QuenMatKhau2.this, "Vui lòng nhập đầy đủ mã OTP", Toast.LENGTH_SHORT).show();
            }
        });

        resendCodeQMKTxt.setOnClickListener(view -> {
            resendOtpQMK();
        });
    }

    private void resendOtpQMK() {
        startResendTimerQMK();
        PhoneAuthOptions.Builder builder =
                PhoneAuthOptions.newBuilder(mAuth)
                        .setPhoneNumber(phoneNumber)
                        .setTimeout(timeOutSeconds, TimeUnit.SECONDS)
                        .setActivity(this)
                        .setCallbacks(new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                            @Override
                            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                                signIn(phoneAuthCredential);
                            }

                            @Override
                            public void onVerificationFailed(@NonNull FirebaseException e) {
                                Toast.makeText(QuenMatKhau2.this, "Mã xác thực không đúng", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onCodeSent(@NonNull String code, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                                super.onCodeSent(code, forceResendingToken);
                                verificationCode = code;
                                resendingToken = forceResendingToken;
                                Toast.makeText(QuenMatKhau2.this, "Mã xác thực đã được gửi", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setForceResendingToken(resendingToken);
            PhoneAuthProvider.verifyPhoneNumber(builder.build());
    }

    private void signIn(PhoneAuthCredential phoneAuthCredential) {
        mAuth.signInWithCredential(phoneAuthCredential).addOnCompleteListener(this, task -> {
            if (task.isSuccessful()) {
                Intent intent = new Intent(QuenMatKhau2.this, QuenMatKhau3.class);
                intent.putExtra("phoneNumber", phoneNumber);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(QuenMatKhau2.this, "Mã xác thực không đúng", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void startResendTimerQMK() {
        resendCodeQMKTxt.setEnabled(false);
        resendCodeQMKTxt.setVisibility(View.GONE);
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                timeOutSeconds--;

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        countDownTxt.setText("Mã xác thực còn hiệu lực trong " + timeOutSeconds + " giây");
                    }
                });

                if (timeOutSeconds <= 0) {
                    timeOutSeconds = 60L;
                    timer.cancel();

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            // Bật lại nút
                            resendCodeQMKTxt.setEnabled(true);
                            resendCodeQMKTxt.setVisibility(View.GONE);
                        }
                    });
                }
            }
        }, 0, 1000);
    }

}

