package com.example.mtc;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.FirebaseException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.firestore.FirebaseFirestore;
import com.hbb20.CountryCodePicker;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;


public class QuenMatKhau extends AppCompatActivity {

    private EditText phoneNumberETxt;
    private Button signUpBtn;
    private ImageView backBtn;
    private CountryCodePicker codePicker;

    private String phoneNumber, verificationCode;
    private FirebaseAuth mAuth;
    private PhoneAuthProvider.ForceResendingToken token;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_quenmatkhau);

        backBtn = findViewById(R.id.icBackQMK);
        phoneNumberETxt = findViewById(R.id.phoneNumberEdt);
        signUpBtn = findViewById(R.id.signupBtn);
        codePicker = findViewById(R.id.cpp);
        mAuth = FirebaseAuth.getInstance();

        codePicker.registerCarrierNumberEditText(phoneNumberETxt);

        Map<String, String> data = new HashMap<>();
        FirebaseFirestore.getInstance().collection("test").add(data);

        backBtn.setOnClickListener(view -> {
            Intent intent = new Intent(QuenMatKhau.this, DangNhap.class);
            startActivity(intent);
        });

        signUpBtn.setOnClickListener(view -> {

            phoneNumber = phoneNumberETxt.getText().toString().trim();

            if (phoneNumber.isEmpty()) {
                Toast.makeText(this, "Vui lòng nhập số điện thoại", Toast.LENGTH_SHORT).show();
            }else {
                PhoneAuthOptions.Builder builder =
                        PhoneAuthOptions.newBuilder(mAuth)
                                .setPhoneNumber(phoneNumber)
                                .setTimeout(60L, TimeUnit.SECONDS)
                                .setActivity(this)
                                .setCallbacks(new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                                    @Override
                                    public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                                    }

                                    @Override
                                    public void onVerificationFailed(@NonNull FirebaseException e) {
                                    }

                                    @Override
                                    public void onCodeSent(@NonNull String vcode, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                                        super.onCodeSent(vcode, forceResendingToken);
                                        verificationCode = vcode;
                                        token = forceResendingToken;

                                        Intent intent = new Intent(QuenMatKhau.this,QuenMatKhau2.class);
                                        intent.putExtra("OTP" , verificationCode);
                                        intent.putExtra("resendToken" , token);
                                        intent.putExtra("phoneNumber" , phoneNumber);
                                        startActivity(intent);
                                    }
                                });
                PhoneAuthProvider.verifyPhoneNumber(builder.build());
            }
        });
    }
}