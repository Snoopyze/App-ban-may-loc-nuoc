package com.example.mtc;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.example.mtc.R; // Thay đổi tên gói nếu cần

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import java.util.HashMap;
import java.util.Map;

public class XinChao extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private Map<Integer, Fragment> fragmentMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xinchao);

        bottomNavigationView = findViewById(R.id.bottom_navigation);

        // Khởi tạo fragmentMap
        fragmentMap = new HashMap<>();
        fragmentMap.put(R.id.trangchu, new TrangChuFragment());
        fragmentMap.put(R.id.meohay, new MeoHayFragment());
        fragmentMap.put(R.id.taikhoan, new TaiKhoanFragment());

        // Thiết lập mặc định cho fragment hiển thị khi mở ứng dụng
        if (savedInstanceState == null) {
            bottomNavigationView.setSelectedItemId(R.id.trangchu);
            loadFragment(fragmentMap.get(R.id.trangchu));
        }

        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            Fragment selectedFragment = fragmentMap.get(item.getItemId());
            return loadFragment(selectedFragment);
        });
    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }
}
