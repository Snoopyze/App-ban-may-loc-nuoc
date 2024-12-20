package com.example.mtc;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link sp_sp_SunhouseFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class sp_sp_SunhouseFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public sp_sp_SunhouseFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment sp_sp_SunhouseFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static sp_sp_SunhouseFragment newInstance(String param1, String param2) {
        sp_sp_SunhouseFragment fragment = new sp_sp_SunhouseFragment();
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

    private RecyclerView rcvSanPhamCategory;
    private SanPhamCategoryAdapter sanPhamCategoryAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view   = inflater.inflate(R.layout.fragment_sp_sp_sunhouse, container, false);

        rcvSanPhamCategory = view.findViewById(R.id.rcv_sanphamcategory_sunhouse);
        sanPhamCategoryAdapter = new SanPhamCategoryAdapter(requireContext());

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false);
        rcvSanPhamCategory.setLayoutManager(linearLayoutManager);

        sanPhamCategoryAdapter.setData(getListSanPhamCategory());
        rcvSanPhamCategory.setAdapter(sanPhamCategoryAdapter);

        return view;
    }

    private List<SanPhamCategory> getListSanPhamCategory() {
        List<SanPhamCategory> listSanPhamCategory = new ArrayList<>();
        String content = "Loại máy: Máy lọc nước dạng đứng\n"
                + "Số lõi lọc: 4 lõi\n"
                + "Dung tích bình chứa: 5 lít\n"
                + "Tỷ lệ lọc thải: Lọc 5 thải 5\n"
                + "Công suất tiêu thụ điện trung bình: 0.048 kW/h\n"
                ;
//        List<SanPham> listSanPhamSunhouse_1 = new ArrayList<>();
//        listSanPhamSunhouse_1.add(new SanPham(R.drawable.mln_ro_kangaroo_kg116i_10_loi, "Máy lọc nước RO Sunhouse GK 116l 01", "5.140.000.đ", content));
//        listSanPhamSunhouse_1.add(new SanPham(R.drawable.mln_ro_kangaroo_kg116i_10_loi, "Máy lọc nước RO Sunhouse GK 116l 02", "5.140.000.đ", content));
//        listSanPhamSunhouse_1.add(new SanPham(R.drawable.mln_ro_kangaroo_kg116i_10_loi, "Máy lọc nước RO Sunhouse GK 116l 03", "5.140.000.đ", content));
//        listSanPhamSunhouse_1.add(new SanPham(R.drawable.mln_ro_kangaroo_kg116i_10_loi, "Máy lọc nước RO Sunhouse GK 116l 04", "5.140.000.đ", content));
//        listSanPhamSunhouse_1.add(new SanPham(R.drawable.mln_ro_kangaroo_kg116i_10_loi, "Máy lọc nước RO Sunhouse GK 116l 05", "5.140.000.đ", content));
//
//        List<SanPham> listSanPhamSunhouse_2 = new ArrayList<>();
//        listSanPhamSunhouse_2.add(new SanPham(R.drawable.mln_ro_kangaroo_kg116i_10_loi, "Máy lọc nước RO Sunhouse GK 116l 01", "5.140.000.đ", content));
//        listSanPhamSunhouse_2.add(new SanPham(R.drawable.mln_ro_kangaroo_kg116i_10_loi, "Máy lọc nước RO Sunhouse GK 116l 02", "5.140.000.đ", content));
//        listSanPhamSunhouse_2.add(new SanPham(R.drawable.mln_ro_kangaroo_kg116i_10_loi, "Máy lọc nước RO Sunhouse GK 116l 03", "5.140.000.đ", content));
//        listSanPhamSunhouse_2.add(new SanPham(R.drawable.mln_ro_kangaroo_kg116i_10_loi, "Máy lọc nước RO Sunhouse GK 116l 04", "5.140.000.đ", content));
//        listSanPhamSunhouse_2.add(new SanPham(R.drawable.mln_ro_kangaroo_kg116i_10_loi, "Máy lọc nước RO Sunhouse GK 116l 05", "5.140.000.đ", content));
//
//        List<SanPham> listSanPhamSunhouse_3 = new ArrayList<>();
//        listSanPhamSunhouse_3.add(new SanPham(R.drawable.mln_ro_kangaroo_kg116i_10_loi, "Máy lọc nước RO Sunhouse GK 116l 01", "5.140.000.đ", content));
//        listSanPhamSunhouse_3.add(new SanPham(R.drawable.mln_ro_kangaroo_kg116i_10_loi, "Máy lọc nước RO Sunhouse GK 116l 02", "5.140.000.đ", content));
//        listSanPhamSunhouse_3.add(new SanPham(R.drawable.mln_ro_kangaroo_kg116i_10_loi, "Máy lọc nước RO Sunhouse GK 116l 03", "5.140.000.đ", content));
//        listSanPhamSunhouse_3.add(new SanPham(R.drawable.mln_ro_kangaroo_kg116i_10_loi, "Máy lọc nước RO Sunhouse GK 116l 04", "5.140.000.đ", content));
//        listSanPhamSunhouse_3.add(new SanPham(R.drawable.mln_ro_kangaroo_kg116i_10_loi, "Máy lọc nước RO Sunhouse GK 116l 05", "5.140.000.đ", content));
//
//        List<SanPham> listSanPhamSunhouse_4 = new ArrayList<>();
//        listSanPhamSunhouse_4.add(new SanPham(R.drawable.mln_ro_kangaroo_kg116i_10_loi, "Máy lọc nước RO Sunhouse GK 116l 01", "5.140.000.đ", content));
//        listSanPhamSunhouse_4.add(new SanPham(R.drawable.mln_ro_kangaroo_kg116i_10_loi, "Máy lọc nước RO Sunhouse GK 116l 02", "5.140.000.đ", content));
//        listSanPhamSunhouse_4.add(new SanPham(R.drawable.mln_ro_kangaroo_kg116i_10_loi, "Máy lọc nước RO Sunhouse GK 116l 03", "5.140.000.đ", content));
//        listSanPhamSunhouse_4.add(new SanPham(R.drawable.mln_ro_kangaroo_kg116i_10_loi, "Máy lọc nước RO Sunhouse GK 116l 04", "5.140.000.đ", content));
//        listSanPhamSunhouse_4.add(new SanPham(R.drawable.mln_ro_kangaroo_kg116i_10_loi, "Máy lọc nước RO Sunhouse GK 116l 05", "5.140.000.đ", content));
//
//        List<SanPham> listSanPhamSunhouse_5 = new ArrayList<>();
//        listSanPhamSunhouse_5.add(new SanPham(R.drawable.mln_ro_kangaroo_kg116i_10_loi, "Máy lọc nước RO Sunhouse GK 116l 01", "5.140.000.đ", content));
//        listSanPhamSunhouse_5.add(new SanPham(R.drawable.mln_ro_kangaroo_kg116i_10_loi, "Máy lọc nước RO Sunhouse GK 116l 02", "5.140.000.đ", content));
//        listSanPhamSunhouse_5.add(new SanPham(R.drawable.mln_ro_kangaroo_kg116i_10_loi, "Máy lọc nước RO Sunhouse GK 116l 03", "5.140.000.đ", content));
//        listSanPhamSunhouse_5.add(new SanPham(R.drawable.mln_ro_kangaroo_kg116i_10_loi, "Máy lọc nước RO Sunhouse GK 116l 04", "5.140.000.đ", content));
//        listSanPhamSunhouse_5.add(new SanPham(R.drawable.mln_ro_kangaroo_kg116i_10_loi, "Máy lọc nước RO Sunhouse GK 116l 05", "5.140.000.đ", content));
//
//
//        listSanPhamCategory.add(new SanPhamCategory("Máy lọc nước Sunhouse 01",listSanPhamSunhouse_1));
//        listSanPhamCategory.add(new SanPhamCategory("Máy lọc nước Sunhouse 02",listSanPhamSunhouse_2));
//        listSanPhamCategory.add(new SanPhamCategory("Máy lọc nước Sunhouse 03",listSanPhamSunhouse_3));
//        listSanPhamCategory.add(new SanPhamCategory("Máy lọc nước Sunhouse 04",listSanPhamSunhouse_4));
//        listSanPhamCategory.add(new SanPhamCategory("Máy lọc nước Sunhouse 05",listSanPhamSunhouse_5));
//



        return listSanPhamCategory;
    }
}