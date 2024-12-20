package com.example.mtc.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mtc.DetailSanPhamActivity;
import com.example.mtc.R;

public class GioHangActivity extends AppCompatActivity {

    private ImageView btnBack;

    private void initUI() {
        btnBack = findViewById(R.id.btn_cart_trove);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_giohang);

        Bundle bundle = getIntent().getExtras();
        if(bundle == null) {
            return;
        }

        initUI();

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
