package com.example.mtc;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link sp_SanPhamFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class sp_SanPhamFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public sp_SanPhamFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment sp_SanPhamFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static sp_SanPhamFragment newInstance(String param1, String param2) {
        sp_SanPhamFragment fragment = new sp_SanPhamFragment();
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


    private LinearLayout splinearLayout;
    private ViewPager mViewPager;
    private CircleIndicator mCircleIndicator;
    private List<PhotoBanner> mlistPhotoBanner;
    private Handler mHandler = new Handler();
    private Runnable mRunnable = new Runnable() {
        @Override
        public void run() {
            if(mViewPager.getCurrentItem() == mlistPhotoBanner.size() - 1) {
                mViewPager.setCurrentItem(0);
            }else {
                mViewPager.setCurrentItem(mViewPager.getCurrentItem() + 1);
            }

        }
    };

    private ViewPager2 viewPager2;
    private TabLayout tabLayout;


    @Override
    public void onPause() {
        super.onPause();
        mHandler.removeCallbacks(mRunnable);
    }

    @Override
    public void onResume() {
        super.onResume();
        mHandler.postDelayed(mRunnable, 3000);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sp_san_pham, container, false);

        view.findViewById(R.id.btntrangchu_sp).setOnClickListener(v -> {
//            FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
//            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//
//            fragmentTransaction.setCustomAnimations(
//                    android.R.anim.slide_in_left,  // Hiệu ứng khi fragment vào
//                    android.R.anim.slide_out_right, // Hiệu ứng khi fragment ra
//                    android.R.anim.slide_in_left,  // Hiệu ứng khi quay lại fragment
//                    android.R.anim.slide_out_right // Hiệu ứng khi quay lại fragment cũ
//            );
//
//            fragmentTransaction.replace(R.id.fragment_sp_san_pham, new TrangChuFragment());
//            fragmentTransaction.addToBackStack(null);
//            fragmentTransaction.commit();

            Intent intent = new Intent(getActivity(), TrangChu.class);
            startActivity(intent);

        });



        splinearLayout = view.findViewById(R.id.lnheader_sp);
        mViewPager = view.findViewById(R.id.sp_view_pager_qc);
        mCircleIndicator = view.findViewById(R.id.sp_circleindicator_center);
        mlistPhotoBanner = getListPhoto();
        ViewPagerBannerAdapter adapter = new ViewPagerBannerAdapter(mlistPhotoBanner);
        mViewPager.setAdapter(adapter);

        mCircleIndicator.setViewPager(mViewPager);

        mHandler.postDelayed(mRunnable, 3000);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mHandler.removeCallbacks(mRunnable);
                mHandler.postDelayed(mRunnable, 2000);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        viewPager2 = view.findViewById(R.id.sp_sanpham_viewpager2);
        viewPager2.setAdapter(new sp_SanPhamFragmentApdapter(this));

        tabLayout = view.findViewById(R.id.sp_sanpham_tablayout);
        TabLayoutMediator  tabLayoutMediator = new TabLayoutMediator(
                tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position) {
                    case 0:
                        tab.setText("AO Smith");
                        tab.setIcon(R.drawable.mlg_ro_kangaroo_kg116i_10_loi_100x100);
                        break;
                    case 1:
                        tab.setText("Kafori");
                        tab.setIcon(R.drawable.mlg_ro_kangaroo_kg116i_10_loi_100x100);
                        break;
                    case 2:
                        tab.setText("Kangaroo");
                        tab.setIcon(R.drawable.mlg_ro_kangaroo_kg116i_10_loi_100x100);
                        break;
                    case 3:
                        tab.setText("Sunhouse");
                        tab.setIcon(R.drawable.mlg_ro_kangaroo_kg116i_10_loi_100x100);
                        break;
                    case 4:
                        tab.setText("Toshiba");
                        tab.setIcon(R.drawable.mlg_ro_kangaroo_kg116i_10_loi_100x100);
                        break;
                }
            }
        }
        );

        tabLayoutMediator.attach();



        return view;
    }

    private List<PhotoBanner> getListPhoto() {
        List<PhotoBanner> list = new ArrayList<>();
        list.add(new PhotoBanner(R.drawable.bn1));
        list.add(new PhotoBanner(R.drawable.bn2));
        list.add(new PhotoBanner(R.drawable.bn3));
        list.add(new PhotoBanner(R.drawable.bn4));
        return list;
    }

}