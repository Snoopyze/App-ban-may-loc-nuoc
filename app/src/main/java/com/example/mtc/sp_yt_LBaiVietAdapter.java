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

import javax.xml.namespace.QName;

public class sp_yt_LBaiVietAdapter extends RecyclerView.Adapter<sp_yt_LBaiVietAdapter.LBaiVietViewHolder>  {

    private Context mContext;
    private List<sp_yt_LBaiViet> mListBaiViet;

    public sp_yt_LBaiVietAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setData(List<sp_yt_LBaiViet> list) {
        this.mListBaiViet = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public LBaiVietViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_baiviet_category_wcardview, parent, false);

        return new LBaiVietViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LBaiVietViewHolder holder, int position) {
        sp_yt_LBaiViet lBaiViet = mListBaiViet.get(position);
        if(lBaiViet == null) {
            return;
        }
        holder.imgBaiViet.setImageResource(lBaiViet.getResouceId());
        holder.tittleBV.setText(lBaiViet.getTittle());
        holder.typeBV.setText(lBaiViet.getType());


    }

    @Override
    public int getItemCount() {
        if(mListBaiViet != null) {
            return mListBaiViet.size();
        }
        return 0;
    }

    public class LBaiVietViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgBaiViet;
        private TextView tittleBV, typeBV;

        public LBaiVietViewHolder(@NonNull View itemView) {
            super(itemView);

            imgBaiViet = itemView.findViewById(R.id.img_baiviet_wcardview);
            tittleBV = itemView.findViewById(R.id.ten_baiviet_wcardview);
            typeBV = itemView.findViewById(R.id.loai_sanpham_wcardview);
        }
    }
}
