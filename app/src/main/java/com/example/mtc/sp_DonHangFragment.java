package com.example.mtc;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link sp_DonHangFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class sp_DonHangFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public sp_DonHangFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment sp_DonHangFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static sp_DonHangFragment newInstance(String param1, String param2) {
        sp_DonHangFragment fragment = new sp_DonHangFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    private TabLayout spdhTabLayout;
    private ViewPager2 spdhViewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sp_don_hang, container, false);


        spdhViewPager = view.findViewById(R.id.sp_dh_viewpager);
        spdhViewPager.setAdapter(new sp_dh_ViewPagerAdapter(this));

        spdhTabLayout = view.findViewById(R.id.sp_dh_tablayout);
        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(
                spdhTabLayout, spdhViewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {

                switch (position) {
                    case 0: {
                        tab.setText("Chờ xác nhận");
                        tab.setIcon(R.drawable.icon_choxacnhan_m);
                        break;
                    }
                    case 1: {
                        tab.setText("Đã xác nhận");
                        tab.setIcon(R.drawable.icon_daxacnhan_m);
                        break;
                    }
                    case 2: {
                        tab.setText("Đang giao");
                        tab.setIcon(R.drawable.icon_dangiaohang_m);
                        break;
                    }
                    case 3: {
                        tab.setText("Thành công");
                        tab.setIcon(R.drawable.icon_thanhcong_m);
                        break;
                    }
                    case 4: {
                        tab.setText("Đã hủy");
                        tab.setIcon(R.drawable.icon_dahuy_1_m);
                        break;
                    }

                }
            }
        }
        );
        tabLayoutMediator.attach();

        return view;
    }
}