package com.example.mtc;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class sp_yt_ViewPagerAdapter extends FragmentStateAdapter {

    public sp_yt_ViewPagerAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }



    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new sp_yt_SanPhamFragment();
            case 1:
                return new sp_yt_BaiVietFragment();
            default:
                return new sp_yt_SanPhamFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
