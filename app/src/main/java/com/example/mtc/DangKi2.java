package com.example.mtc;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import com.google.firebase.FirebaseException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;


public class DangKi2 extends AppCompatActivity {

    private String phoneNumber;
    private FirebaseAuth mAuth;
    private String verificationCode;
    private PhoneAuthProvider.ForceResendingToken resendingToken;

    private long timeOutSeconds = 60L;

    private ImageView backBtn;
    private EditText otp1, otp2, otp3, otp4, otp5, otp6;
    private TextView countdownTxt,resendCodeDKTxt,phoneNumberTextView;
    private Button contBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangki2);

        verificationCode = getIntent().getStringExtra("OTP");
        phoneNumber = getIntent().getStringExtra("phoneNumber");
        resendingToken = getIntent().getParcelableExtra("resendToken");

        otp1 = findViewById(R.id.otp1);
        otp2 = findViewById(R.id.otp2);
        otp3 = findViewById(R.id.otp3);
        otp4 = findViewById(R.id.otp4);
        otp5 = findViewById(R.id.otp5);
        otp6 = findViewById(R.id.otp6);

        backBtn = findViewById(R.id.icBackDK2);
        phoneNumberTextView = findViewById(R.id.phoneNumber);
        countdownTxt = findViewById(R.id.countDownTxt);
        contBtn = findViewById(R.id.contBtn);
        resendCodeDKTxt = findViewById(R.id.resendCodeTxt);
        mAuth = FirebaseAuth.getInstance();


        backBtn.setOnClickListener(view ->  {
            Intent intent = new Intent(DangKi2.this, DangKi.class);
            startActivity(intent);
        });

        if (phoneNumber != null) {
            phoneNumberTextView.setText(phoneNumber);
        }

        contBtn.setOnClickListener(v -> {
            String otp = (otp1.getText().toString() + otp2.getText().toString() + otp3.getText().toString() +
                    otp4.getText().toString() + otp5.getText().toString() + otp6.getText().toString());

            if (otp.isEmpty()) {
                Toast.makeText(DangKi2.this, "Vui lòng nhập mã OTP", Toast.LENGTH_SHORT).show();
            }else {
                if (otp.length() == 6){
                    PhoneAuthCredential phoneAuthCredential = PhoneAuthProvider.getCredential(verificationCode, otp);
                    signIn(phoneAuthCredential);
                }else{
                    Toast.makeText(DangKi2.this, "Vui lòng nhập đầy đủ mã OTP", Toast.LENGTH_SHORT).show();
                }
            }
        });

        resendCodeDKTxt.setOnClickListener(view -> {
            resendVerificationCode();
        });

    }

    private void resendVerificationCode(){
        startResendTimerDK();
        PhoneAuthOptions.Builder builder =
                PhoneAuthOptions.newBuilder(mAuth)
                        .setPhoneNumber(phoneNumber)
                        .setTimeout(timeOutSeconds,TimeUnit.SECONDS)
                        .setActivity(this)
                        .setCallbacks(new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                            @Override
                            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                                signIn(phoneAuthCredential);
                            }

                            @Override
                            public void onVerificationFailed(@NonNull FirebaseException e) {
                                Toast.makeText(DangKi2.this, "Mã xác thực không đúng",Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onCodeSent(@NonNull String code, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                                super.onCodeSent(code, forceResendingToken);
                                verificationCode = code;
                                resendingToken = forceResendingToken;
                                Toast.makeText(DangKi2.this, "Mã xác thực đã được gửi",Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setForceResendingToken(resendingToken);
            PhoneAuthProvider.verifyPhoneNumber(builder.build());
    }

    private void signIn(PhoneAuthCredential phoneAuthCredential){
        mAuth.signInWithCredential(phoneAuthCredential).addOnCompleteListener(this, task -> {
            if (task.isSuccessful()){
                Intent intent = new Intent(DangKi2.this, DangKi3.class);
                intent.putExtra("phoneNumber",phoneNumber);
                startActivity(intent);
                finish();
            }else{
                Toast.makeText(DangKi2.this, "Mã xác thực không đúng",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void startResendTimerDK() {
        resendCodeDKTxt.setEnabled(false);
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                timeOutSeconds--;

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        countdownTxt.setText("Mã xác thực còn hiệu lực trong " + timeOutSeconds + " giây");
                    }
                });

                if (timeOutSeconds <= 0) {
                    timeOutSeconds = 60L;
                    timer.cancel();

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            resendCodeDKTxt.setVisibility(View.VISIBLE);
                            resendCodeDKTxt.setEnabled(true);
                        }
                    });
                }
            }
        }, 0, 1000);
    }

    private void addTextChangeListener() {
        otp1.addTextChangedListener(new EditTextWatcher(otp1));
        otp2.addTextChangedListener(new EditTextWatcher(otp2));
        otp3.addTextChangedListener(new EditTextWatcher(otp3));
        otp4.addTextChangedListener(new EditTextWatcher(otp4));
        otp5.addTextChangedListener(new EditTextWatcher(otp5));
        otp6.addTextChangedListener(new EditTextWatcher(otp6));
    }

    private class EditTextWatcher implements TextWatcher {
        private View v;

        private EditTextWatcher(View v){
            this.v = v;
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            String text = s.toString();

            if (v.getId() == R.id.otp1) {
                if (text.length() == 1) {
                    otp2.requestFocus(); // Move focus to otp2
                }
            } else if (v.getId() == R.id.otp2) {
                if (text.length() == 1) {
                    otp3.requestFocus(); // Move focus to otp3
                } else if (text.isEmpty()) {
                    otp1.requestFocus(); // If empty, move focus back to otp1
                }
            } else if (v.getId() == R.id.otp3) {
                if (text.length() == 1) {
                    otp4.requestFocus(); // Move focus to otp4
                } else if (text.isEmpty()) {
                    otp2.requestFocus(); // If empty, move focus back to otp2
                }
            } else if (v.getId() == R.id.otp4) {
                if (text.length() == 1) {
                    otp5.requestFocus(); // Move focus to otp5
                } else if (text.isEmpty()) {
                    otp3.requestFocus(); // If empty, move focus back to otp3
                }
            } else if (v.getId() == R.id.otp5) {
                if (text.length() == 1) {
                    otp6.requestFocus(); // Move focus to otp6
                } else if (text.isEmpty()) {
                    otp4.requestFocus(); // If empty, move focus back to otp4
                }
            } else if (v.getId() == R.id.otp6) {
                if (text.isEmpty()) {
                    otp5.requestFocus(); // If empty, move focus back to otp5
                }
            }
        }
    }
}
