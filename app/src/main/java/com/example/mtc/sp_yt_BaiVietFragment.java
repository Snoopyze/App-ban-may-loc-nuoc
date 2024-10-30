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
 * Use the {@link sp_yt_BaiVietFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class sp_yt_BaiVietFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public sp_yt_BaiVietFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment sp_yt_BaiVietFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static sp_yt_BaiVietFragment newInstance(String param1, String param2) {
        sp_yt_BaiVietFragment fragment = new sp_yt_BaiVietFragment();
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

    private RecyclerView rcvBaiViet;
    private sp_yt_LBaiVietAdapter lBaiVietAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sp_yt_baiviet, container, false);

        rcvBaiViet = view.findViewById(R.id.sp_yt_rcvbaiviet);
        lBaiVietAdapter = new sp_yt_LBaiVietAdapter(requireContext());

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false);
        rcvBaiViet.setLayoutManager(linearLayoutManager);

        lBaiVietAdapter.setData(getListBaiViet());
        rcvBaiViet.setAdapter(lBaiVietAdapter);


        return view;
    }

    private List<sp_yt_LBaiViet> getListBaiViet() {
        List<sp_yt_LBaiViet> list = new ArrayList<>();

        list.add(new sp_yt_LBaiViet(R.drawable.mln_ro_kangaroo_kg116i_10_loi, "Lưu ý khi sử dụng máy lọc nước", "Sản Phẩm"));
        list.add(new sp_yt_LBaiViet(R.drawable.mln_ro_kangaroo_kg116i_10_loi, "5 điều cần biết khi sử dụng máy lọc nước Kangaroo", "Sản Phẩm"));
        list.add(new sp_yt_LBaiViet(R.drawable.mln_ro_kangaroo_kg116i_10_loi, "Lưu ý khi thay lõi máy lọc nước", "Dịch vụ"));
        list.add(new sp_yt_LBaiViet(R.drawable.mln_ro_kangaroo_kg116i_10_loi, "Cách lựa chọn máy lọc nước phụ hợp với gia đình", "Sản Phẩm"));
        list.add(new sp_yt_LBaiViet(R.drawable.mln_ro_kangaroo_kg116i_10_loi, "Bao lâu thì nên thay lõi lọc nước", "Dịch vụ"));
        list.add(new sp_yt_LBaiViet(R.drawable.mln_ro_kangaroo_kg116i_10_loi, "Lưu ý khi sử dụng máy lọc nước", "Sản Phẩm"));
        list.add(new sp_yt_LBaiViet(R.drawable.mln_ro_kangaroo_kg116i_10_loi, "5 điều cần biết khi sử dụng máy lọc nước Kangaroo", "Sản Phẩm"));
        list.add(new sp_yt_LBaiViet(R.drawable.mln_ro_kangaroo_kg116i_10_loi, "Lưu ý khi thay lõi máy lọc nước", "Dịch vụ"));
        list.add(new sp_yt_LBaiViet(R.drawable.mln_ro_kangaroo_kg116i_10_loi, "Cách lựa chọn máy lọc nước phụ hợp với gia đình", "Sản Phẩm"));
        list.add(new sp_yt_LBaiViet(R.drawable.mln_ro_kangaroo_kg116i_10_loi, "Bao lâu thì nên thay lõi lọc nước", "Dịch vụ"));



        return list;
    }
}