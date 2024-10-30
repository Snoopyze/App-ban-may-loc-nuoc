package com.example.mtc;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class sp_SanPhamFragmentApdapter extends FragmentStateAdapter {
    public sp_SanPhamFragmentApdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new sp_sp_AOsmithFragment();
            case 1:
                return new sp_sp_KarofiFragment();
            case 2:
                return new sp_sp_KangarooFragment();
            case 3:
                return new sp_sp_SunhouseFragment();
            case 4:
                return new sp_sp_ToshibaFragment();
            default:
                return new sp_sp_AOsmithFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 5;
    }
}
