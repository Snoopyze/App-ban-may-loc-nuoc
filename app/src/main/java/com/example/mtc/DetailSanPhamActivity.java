package com.example.mtc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Context;
import android.content.Intent;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;
import com.example.mtc.activity.GioHangActivity;

public class DetailSanPhamActivity extends AppCompatActivity {

    private Context mContext;
    private ImageView imgSanPham;
    private TextView tvNameSanPham;
    private TextView tvPriceSanPham;
    private TextView tvContentSanPham;
    private TextView tvSub;
    private TextView tvAdd;
    private TextView tvCount;
    private TextView tvTotal;
    private TextView btnAddOrder;
    private ImageView btnTroVe;


    private void initUi() {
        imgSanPham = findViewById(R.id.detail_image_sanpham);
        tvNameSanPham = findViewById(R.id.detail_tittle_sanpham);
        tvPriceSanPham = findViewById(R.id.detail_price_sanpham);
        tvContentSanPham = findViewById(R.id.detail_content_sanpham);
        tvSub = findViewById(R.id.tv_sub);
        tvAdd = findViewById(R.id.tv_add);
        tvCount = findViewById(R.id.tv_count);
        tvTotal = findViewById(R.id.tv_total);
        btnAddOrder = findViewById(R.id.btn_add_order);
        btnTroVe = findViewById(R.id.btn_detailSP_trove);

    }

    private void calculatorTotalPrice() {
        int count = Integer.parseInt(tvCount.getText().toString().trim());
        int priceOneProduct = Integer.parseInt(tvPriceSanPham.getText().toString().trim());
        int totalPrice = priceOneProduct * count;
        String strTotalPrice = totalPrice + "VND";
        tvTotal.setText(strTotalPrice);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail_san_pham);

        Bundle bundle = getIntent().getExtras();
        if(bundle == null) {
            return;
        }

        initUi();

        SanPham sanPham = (SanPham) bundle.get("object_sanpham");


//        imgSanPham.setImageResource(sanPham.getResourceID());
        Glide.with(this) .load(sanPham.getIgmPath()).into(imgSanPham);


//        TextView tvNameSanPham = findViewById(R.id.detail_tittle_sanpham);
        tvNameSanPham.setText(sanPham.getTittle());

//        TextView tvPriceSanPham = findViewById(R.id.detail_price_sanpham);
        tvPriceSanPham.setText(String.valueOf(sanPham.getPrice()));

//        TextView tvContentSanPham = findViewById(R.id.detail_content_sanpham);
        tvContentSanPham.setText(sanPham.getContent());




        tvTotal.setText(String.valueOf(sanPham.getPrice()));


        tvSub.setOnClickListener(v -> {
            int count = Integer.parseInt(tvCount.getText().toString());
            if (count <= 1) {
                return;
            }
            int newCount = Integer.parseInt(tvCount.getText().toString()) - 1;
            tvCount.setText(String.valueOf(newCount));

            calculatorTotalPrice();
        });

        tvAdd.setOnClickListener(v -> {
            int newCount = Integer.parseInt(tvCount.getText().toString()) + 1;
            tvCount.setText(String.valueOf(newCount));

            calculatorTotalPrice();
        });




        btnTroVe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                onBackPressed();
            }
        });

        btnAddOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailSanPhamActivity.this, GioHangActivity.class);
                startActivity(intent);
            }
        });

    }



    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }





}