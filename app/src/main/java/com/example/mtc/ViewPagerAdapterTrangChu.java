package com.example.mtc;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class ViewPagerAdapterTrangChu extends FragmentStatePagerAdapter {
    public ViewPagerAdapterTrangChu(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new TrangChuFragment();
            case 1:
                return new MeoHayFragment();
            case 2:
                return new TaiKhoanFragment();
            default:
                return new TrangChuFragment();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
