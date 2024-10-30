package com.example.mtc;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class sp_dh_ViewPagerAdapter extends FragmentStateAdapter {


    public sp_dh_ViewPagerAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new sp_dh_ChoXacNhanFragment();
            case 1:
                return new sp_dh_DaXacNhanFragment();
            case 2:
                return new sp_dh_DangGiaoFragment();
            case 3:
                return new sp_dh_ThanhCongFragment();
            case 4:
                return new sp_dh_DaHuyFragment();
            default:
                return new sp_dh_ChoXacNhanFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 5;
    }
}
