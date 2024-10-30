package com.example.mtc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class sp_yt_LSanPhamApdapter extends RecyclerView.Adapter<sp_yt_LSanPhamApdapter.LSanPhamViewHolder> {

    private Context mContext;
    private List<sp_yt_LSanPham> mListSanPham;

    public sp_yt_LSanPhamApdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setData(List<sp_yt_LSanPham> list) {
        this.mListSanPham = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public LSanPhamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sanpham_category_wcardview, parent, false);


        return new LSanPhamViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LSanPhamViewHolder holder, int position) {
        sp_yt_LSanPham lSanPham = mListSanPham.get(position);
        if(lSanPham == null) {
            return;
        }
        holder.imgSanPham.setImageResource(lSanPham.getResourceId());
        holder.nameSP.setText(lSanPham.getName());
        holder.priceSP.setText(lSanPham.getPrice());

    }

    @Override
    public int getItemCount() {
        if(mListSanPham != null) {
            return mListSanPham.size();
        }
        return 0;
    }

    public class LSanPhamViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgSanPham;
        private TextView nameSP, priceSP;

        public LSanPhamViewHolder(@NonNull View itemView) {
            super(itemView);

            imgSanPham = itemView.findViewById(R.id.img_sanpham_wcardview);
            nameSP = itemView.findViewById(R.id.ten_sanpham_wcardview);
            priceSP = itemView.findViewById(R.id.gia_sanpham_wcardview);

        }

    }
}
