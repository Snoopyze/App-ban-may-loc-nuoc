package com.example.mtc;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link sp_sp_KangarooFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class sp_sp_KangarooFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public sp_sp_KangarooFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment sp_sp_KangarooFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static sp_sp_KangarooFragment newInstance(String param1, String param2) {
        sp_sp_KangarooFragment fragment = new sp_sp_KangarooFragment();
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

    private DatabaseReference databaseReference;

    private void fetchSanPhamCategoryFromFirebase() {
        databaseReference.addValueEventListener(new ValueEventListener() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                List<SanPhamCategory> listSanPhamCategory = new ArrayList<>();
                for (DataSnapshot categorySnapshot : snapshot.getChildren()) {
                    String nameCategory = categorySnapshot.child("nameCategory").getValue(String.class);
                    List<SanPham> listSanPham = new ArrayList<>();

                    for (DataSnapshot productSnapshot : categorySnapshot.child("list").getChildren()) {
                        int resourceID = productSnapshot.child("resourceID").getValue(Integer.class);
                        String title = productSnapshot.child("tittle").getValue(String.class);
//
                        String content = productSnapshot.child("content").getValue(String.class);
//
                        int price = productSnapshot.child("price").getValue(Integer.class);
//
                        String imgPath = productSnapshot.child("igmPath").getValue(String.class);


//                        int resourceID = 1;
//                        String title = "minh";
//                        String content = "123";
//                        int price = 5140000;
//                        String imgPath = "https://aiosmart.com.vn/media/catalog/product/cache/24d0ad29ea4d0b7ccefb253965039c4f/m/_/m_y_l_c_n_c_empire_n_ng_ngu_i_-_10_c_p_l_c_model_epml038_1.jpg";
                        listSanPham.add(new SanPham(resourceID, title, content, price, imgPath));
                    }

                    listSanPhamCategory.add(new SanPhamCategory(nameCategory, listSanPham));
                }

                // Cập nhật dữ liệu vào adapter
                sanPhamCategoryAdapter.setData(listSanPhamCategory);
                sanPhamCategoryAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("FirebaseError", "Failed to fetch data: " + error.getMessage());
            }
        });
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sp_sp_kangaroo, container, false);


        rcvSanPhamCategory = view.findViewById(R.id.rcv_sanphamcategory_kangaroo);
        sanPhamCategoryAdapter = new SanPhamCategoryAdapter(requireContext());


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false);
        rcvSanPhamCategory.setLayoutManager(linearLayoutManager);


        rcvSanPhamCategory.setAdapter(sanPhamCategoryAdapter);


        databaseReference = FirebaseDatabase.getInstance().getReference("SanPhamCategory");
        fetchSanPhamCategoryFromFirebase();



        return view;
    }


}