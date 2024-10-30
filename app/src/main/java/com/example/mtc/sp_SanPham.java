package com.example.mtc;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class sp_SanPham  extends AppCompatActivity {

    private ViewPager spViewPager;
    private BottomNavigationView spBNV;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sp_sanpham);

        spViewPager = findViewById(R.id.sp_view_pager);
        spBNV = findViewById(R.id.sp_bottom_navigation);

        sp_ViewPagerAdapterSanPham adapterSanPham = new sp_ViewPagerAdapterSanPham(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        spViewPager.setAdapter(adapterSanPham);

        spViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        spBNV.getMenu().findItem(R.id.sp_sanpham).setChecked(true);
                        break;
                    case 1:
                        spBNV.getMenu().findItem(R.id.sp_donhang).setChecked(true);
                        break;
                    case 2:
                        spBNV.getMenu().findItem(R.id.sp_nhucau).setChecked(true);
                        break;
                    case 3:
                        spBNV.getMenu().findItem(R.id.sp_yeuthich).setChecked(true);
                        break;

                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        }) ;

        spBNV.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();

                if (itemId == R.id.sp_sanpham) {
                    spViewPager.setCurrentItem(0,true);
                } else if (itemId == R.id.sp_donhang) {
                    spViewPager.setCurrentItem(1, true);
                } else if (itemId == R.id.sp_nhucau) {
                    spViewPager.setCurrentItem(2, true);
                } else if (itemId == R.id.sp_yeuthich) {
                    spViewPager.setCurrentItem(3, true);
                }

                return true;
            }
        });

    }
}
