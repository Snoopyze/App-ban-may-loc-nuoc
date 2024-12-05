package com.example.mtc;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class XinChao extends AppCompatActivity {

    private ImageView icLogIn;
    private FirebaseAuth mAuth;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_xinchao);

        mAuth = FirebaseAuth.getInstance();
        icLogIn = findViewById(R.id.icLogIn);

        icLogIn.setOnClickListener(view -> {
            Intent intent = new Intent(XinChao.this, DangNhap.class);
            startActivity(intent);
        });
    }

    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
    }
}
