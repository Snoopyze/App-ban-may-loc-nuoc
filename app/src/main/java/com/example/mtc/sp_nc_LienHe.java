package com.example.mtc;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class sp_nc_LienHe extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sp_nc_lien_he);



        findViewById(R.id.sp_nc_btnTrolai).setOnClickListener(v -> {

//            sp_NhuCauFragment fragment = new sp_NhuCauFragment();
//
//
//            FragmentManager fragmentManager = getSupportFragmentManager();
//            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//
//            fragmentTransaction.setCustomAnimations(
//                    android.R.anim.slide_in_left,  // Hiệu ứng khi fragment vào
//                    android.R.anim.slide_out_right, // Hiệu ứng khi fragment ra
//                    android.R.anim.slide_in_left,  // Hiệu ứng khi quay lại fragment
//                    android.R.anim.slide_out_right // Hiệu ứng khi quay lại fragment cũ
//            );
////            fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
//            fragmentTransaction.replace(R.id.ac_sp_nc_lienhe, fragment);
//            fragmentTransaction.addToBackStack(null);
//            fragmentTransaction.commit();

            Intent intent = new Intent(sp_nc_LienHe.this, sp_NhuCauFragment.class);
            startActivity(intent);
        });
    }
}