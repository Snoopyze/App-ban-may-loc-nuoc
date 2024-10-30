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
 * Use the {@link sp_yt_SanPhamFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class sp_yt_SanPhamFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public sp_yt_SanPhamFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment sp_yt_SanPhamFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static sp_yt_SanPhamFragment newInstance(String param1, String param2) {
        sp_yt_SanPhamFragment fragment = new sp_yt_SanPhamFragment();
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
    private RecyclerView rcvSanPham;
    private sp_yt_LSanPhamApdapter lSanPhamApdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_sp_yt_san_pham, container, false);

        rcvSanPham = view.findViewById(R.id.sp_yt_rcvsanpham);
        lSanPhamApdapter = new sp_yt_LSanPhamApdapter(requireContext());

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false);
        rcvSanPham.setLayoutManager(linearLayoutManager);

        lSanPhamApdapter.setData(getListSanPham());
        rcvSanPham.setAdapter(lSanPhamApdapter);

        return view;
    }

    private List<sp_yt_LSanPham> getListSanPham() {
            List<sp_yt_LSanPham> list = new ArrayList<>();


        list.add(new sp_yt_LSanPham(R.drawable.mln_ro_kangaroo_kg116i_10_loi, "Máy lọc nước RO kangarro GK 116l 01", "5.140.000.đ"));
        list.add(new sp_yt_LSanPham(R.drawable.mln_ro_kangaroo_kg116i_10_loi, "Máy lọc nước RO kangarro GK 116l 02", "5.140.000.đ"));
        list.add(new sp_yt_LSanPham(R.drawable.mln_ro_kangaroo_kg116i_10_loi, "Máy lọc nước RO kangarro GK 116l 03", "5.140.000.đ"));
        list.add(new sp_yt_LSanPham(R.drawable.mln_ro_kangaroo_kg116i_10_loi, "Máy lọc nước RO kangarro GK 116l 04", "5.140.000.đ"));
        list.add(new sp_yt_LSanPham(R.drawable.mln_ro_kangaroo_kg116i_10_loi, "Máy lọc nước RO kangarro GK 116l 05", "5.140.000.đ"));
        list.add(new sp_yt_LSanPham(R.drawable.mln_ro_kangaroo_kg116i_10_loi, "Máy lọc nước RO kangarro GK 116l 06", "5.140.000.đ"));
        list.add(new sp_yt_LSanPham(R.drawable.mln_ro_kangaroo_kg116i_10_loi, "Máy lọc nước RO kangarro GK 116l 07", "5.140.000.đ"));

        return list;
    }

}