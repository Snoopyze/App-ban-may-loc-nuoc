package com.example.mtc;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DetailSanPhamActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail_san_pham);

        Bundle bundle = getIntent().getExtras();
        if(bundle == null) {
            return;
        }

        SanPham sanPham = (SanPham) bundle.get("object_sanpham");

        ImageView imgSanPham = findViewById(R.id.detail_image_sanpham);
        imgSanPham.setImageResource(sanPham.getResourceID());


        TextView tvNameSanPham = findViewById(R.id.detail_tittle_sanpham);
        tvNameSanPham.setText(sanPham.getTittle());

        TextView tvPriceSanPham = findViewById(R.id.detail_price_sanpham);
        tvPriceSanPham.setText(sanPham.getPrice());

        TextView tvContentSanPham = findViewById(R.id.detail_content_sanpham);
        tvContentSanPham.setText(sanPham.getContent());



        ImageView btnTroVe = findViewById(R.id.btn_detailSP_trove);
        btnTroVe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Quay về Fragment trước đó
                onBackPressed();
            }
        });



    }



    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

}