package com.example.mtc;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TrangChuFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TrangChuFragment extends Fragment {




    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public TrangChuFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TrangChuFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TrangChuFragment newInstance(String param1, String param2) {
        TrangChuFragment fragment = new TrangChuFragment();
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

    private LinearLayout lnHeader, lnSanPhamNB, lnbtnSPDV;

    private List<PhotoBanner> getListPhoto() {
        List<PhotoBanner> list = new ArrayList<>();
        list.add(new PhotoBanner(R.drawable.bn1));
        list.add(new PhotoBanner(R.drawable.bn2));
        list.add(new PhotoBanner(R.drawable.bn3));
        list.add(new PhotoBanner(R.drawable.bn4));
        return list;
    }


    private RecyclerView rcvSanPhamCategory;
    private SanPhamCategoryAdapter sanPhamCategoryAdapter;
    private ScrollView scrollView;


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

        View view = inflater.inflate(R.layout.fragment_trang_chu, container, false);


        view.findViewById(R.id.btnsanpham).setOnClickListener(v -> {
            Intent intent= new Intent(requireActivity(), sp_SanPham.class);
            startActivity(intent);
        });

//        scrollView = view.findViewById(R.id.view_layout);
        mViewPager = view.findViewById(R.id.view_pager_qc);
        mCircleIndicator = view.findViewById(R.id.circleindicator_center);
        lnHeader = view.findViewById(R.id.lnheader);
        lnSanPhamNB = view.findViewById(R.id.lnsanphamnb);
        lnbtnSPDV = view.findViewById(R.id.lnspdv);



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

        rcvSanPhamCategory = view.findViewById(R.id.rcv_sanphamcategory);
        sanPhamCategoryAdapter = new SanPhamCategoryAdapter(requireContext());

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false);
        rcvSanPhamCategory.setLayoutManager(linearLayoutManager);

        sanPhamCategoryAdapter.setData(getListSanPhamCategory());
        rcvSanPhamCategory.setAdapter(sanPhamCategoryAdapter);




        return view;
    }

    private List<SanPhamCategory> getListSanPhamCategory() {
        String content = "Loại máy: Máy lọc nước dạng đứng\n"
                + "Số lõi lọc: 4 lõi\n"
                + "Dung tích bình chứa: 5 lít\n"
                + "Tỷ lệ lọc thải: Lọc 5 thải 5\n"
                + "Công suất tiêu thụ điện trung bình: 0.048 kW/h\n"
                ;
        List<SanPhamCategory> listSanPhamCategory = new ArrayList<>();

        List<SanPham> listSanPhamAOSmith = new ArrayList<>();
        listSanPhamAOSmith.add(new SanPham(R.drawable.mln_ro_kangaroo_kg116i_10_loi, "Máy lọc nước RO AO Smith GK 116l 01", "5.140.000.đ", content));
        listSanPhamAOSmith.add(new SanPham(R.drawable.mln_ro_kangaroo_kg116i_10_loi, "Máy lọc nước RO AO Smith GK 116l 02", "3.140.000.đ", content));
        listSanPhamAOSmith.add(new SanPham(R.drawable.mln_ro_kangaroo_kg116i_10_loi, "Máy lọc nước RO AO Smith GK 116l 03", "4.999.000.đ", content));
        listSanPhamAOSmith.add(new SanPham(R.drawable.mln_ro_kangaroo_kg116i_10_loi, "Máy lọc nước RO AO Smith GK 116l 04", "1.999.000.đ", content));
        listSanPhamAOSmith.add(new SanPham(R.drawable.mln_ro_kangaroo_kg116i_10_loi, "Máy lọc nước RO AO Smith GK 116l 05", "2.134.000.đ", content));

        List<SanPham> listSanPhamKarofi = new ArrayList<>();
        listSanPhamKarofi.add(new SanPham(R.drawable.mln_ro_kangaroo_kg116i_10_loi, "Máy lọc nước RO Karofi GK 116l 01", "2.134.000.đ", content));
        listSanPhamKarofi.add(new SanPham(R.drawable.mln_ro_kangaroo_kg116i_10_loi, "Máy lọc nước RO Karofi GK 116l 02", "4.999.000.đ", content));
        listSanPhamKarofi.add(new SanPham(R.drawable.mln_ro_kangaroo_kg116i_10_loi, "Máy lọc nước RO Karofi GK 116l 03", "3.140.000.đ", content));
        listSanPhamKarofi.add(new SanPham(R.drawable.mln_ro_kangaroo_kg116i_10_loi, "Máy lọc nước RO Karofi GK 116l 04", "5.140.000.đ", content));
        listSanPhamKarofi.add(new SanPham(R.drawable.mln_ro_kangaroo_kg116i_10_loi, "Máy lọc nước RO Karofi GK 116l 05", "1.999.000.đ", content));

        List<SanPham> listSanPhamKangaroo = new ArrayList<>();
        listSanPhamKangaroo.add(new SanPham(R.drawable.mln_ro_kangaroo_kg116i_10_loi, "Máy lọc nước RO kangaroo GK 116l 01", "3.140.000.đ", content));
        listSanPhamKangaroo.add(new SanPham(R.drawable.mln_ro_kangaroo_kg116i_10_loi, "Máy lọc nước RO kangaroo GK 116l 02", "5.140.000.đ", content));
        listSanPhamKangaroo.add(new SanPham(R.drawable.mln_ro_kangaroo_kg116i_10_loi, "Máy lọc nước RO kangaroo GK 116l 03", "1.999.000.đ", content));
        listSanPhamKangaroo.add(new SanPham(R.drawable.mln_ro_kangaroo_kg116i_10_loi, "Máy lọc nước RO kangaroo GK 116l 04", "2.134.000.đ", content));
        listSanPhamKangaroo.add(new SanPham(R.drawable.mln_ro_kangaroo_kg116i_10_loi, "Máy lọc nước RO kangaroo GK 116l 05", "4.999.000.đ", content));

        List<SanPham> listSanPhamSunhouse = new ArrayList<>();
        listSanPhamSunhouse.add(new SanPham(R.drawable.mln_ro_kangaroo_kg116i_10_loi, "Máy lọc nước RO Sunhouse GK 116l 01", "2.134.000.đ", content));
        listSanPhamSunhouse.add(new SanPham(R.drawable.mln_ro_kangaroo_kg116i_10_loi, "Máy lọc nước RO Sunhouse GK 116l 02", "1.999.000.đ", content));
        listSanPhamSunhouse.add(new SanPham(R.drawable.mln_ro_kangaroo_kg116i_10_loi, "Máy lọc nước RO Sunhouse GK 116l 03", "5.140.000.đ", content));
        listSanPhamSunhouse.add(new SanPham(R.drawable.mln_ro_kangaroo_kg116i_10_loi, "Máy lọc nước RO Sunhouse GK 116l 04", "4.999.000.đ", content));
        listSanPhamSunhouse.add(new SanPham(R.drawable.mln_ro_kangaroo_kg116i_10_loi, "Máy lọc nước RO Sunhouse GK 116l 05", "5.140.000.đ", content));

        List<SanPham> listSanPhamToshiba = new ArrayList<>();
        listSanPhamToshiba.add(new SanPham(R.drawable.mln_ro_kangaroo_kg116i_10_loi, "Máy lọc nước RO Toshiba GK 116l 01", "4.999.000.đ", content));
        listSanPhamToshiba.add(new SanPham(R.drawable.mln_ro_kangaroo_kg116i_10_loi, "Máy lọc nước RO Toshiba GK 116l 02", "1.999.000.đ", content));
        listSanPhamToshiba.add(new SanPham(R.drawable.mln_ro_kangaroo_kg116i_10_loi, "Máy lọc nước RO Toshiba GK 116l 03", "3.140.000.đ", content));
        listSanPhamToshiba.add(new SanPham(R.drawable.mln_ro_kangaroo_kg116i_10_loi, "Máy lọc nước RO Toshiba GK 116l 04", "5.140.000.đ", content));
        listSanPhamToshiba.add(new SanPham(R.drawable.mln_ro_kangaroo_kg116i_10_loi, "Máy lọc nước RO Toshiba GK 116l 05", "2.134.000.đ", content));


        listSanPhamCategory.add(new SanPhamCategory("Máy lọc nước AO Smith",listSanPhamAOSmith));
        listSanPhamCategory.add(new SanPhamCategory("Máy lọc nước Karofi",listSanPhamKarofi));
        listSanPhamCategory.add(new SanPhamCategory("Máy lọc nước Kangarro",listSanPhamKangaroo));
        listSanPhamCategory.add(new SanPhamCategory("Máy lọc nước Sunhouse",listSanPhamSunhouse));
        listSanPhamCategory.add(new SanPhamCategory("Máy lọc nước Toshiba",listSanPhamToshiba));




        return listSanPhamCategory;
    }


}
