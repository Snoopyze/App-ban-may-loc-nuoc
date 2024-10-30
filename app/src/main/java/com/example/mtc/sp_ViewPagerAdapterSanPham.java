package com.example.mtc;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class sp_ViewPagerAdapterSanPham extends FragmentStatePagerAdapter {
    public sp_ViewPagerAdapterSanPham(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new sp_SanPhamFragment();
            case 1:
                return new sp_DonHangFragment();
            case 2:
                return new sp_NhuCauFragment();
            case 3:
                return new sp_YeuThichFragment();
            default:
                return new sp_SanPhamFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }
}
