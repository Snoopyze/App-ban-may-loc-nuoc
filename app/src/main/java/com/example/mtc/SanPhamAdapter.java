package com.example.mtc;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class SanPhamAdapter extends RecyclerView.Adapter<SanPhamAdapter.SanPhamViewHolder> {



    private List<SanPham> msanPhams;
    private Context mContext;

    public SanPhamAdapter(Context context, List<SanPham> msanPhams ) {
        this.mContext = context;
        this.msanPhams = msanPhams;
    }

//    public SanPhamAdapter(List<SanPham> msanPhams ) {
//        this.msanPhams = msanPhams;
//    }


//    public void setData(Context context, List<SanPham> list) {
//        this.mContext = context;
//        this.msanPhams = list;
//        notifyDataSetChanged();
//    }

    public void setData(List<SanPham> list) {
        this.msanPhams = list;
        notifyDataSetChanged();
    }




    @NonNull
    @Override
    public SanPhamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_photo_sanpham, parent, false);

        return new SanPhamViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SanPhamViewHolder holder, int position) {

        final SanPham sanPham = msanPhams.get(position);
        if (sanPham == null) {
            return;
        }

//        holder.imgSanPham.setImageResource(sanPham.getResourceID());

        Glide.with(mContext)
                .load(sanPham.getIgmPath())
                .into(holder.imgSanPham);
        holder.tenSanPham.setText(sanPham.getTittle());
        holder.giaSanPham.setText(String.valueOf(sanPham.getPrice()));



        holder.layoutItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickGoToDetailSanPham(sanPham);

            }
        });

    }

    private void onClickGoToDetailSanPham(SanPham sanPham) {
        Intent intent = new Intent(mContext, DetailSanPhamActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("object_sanpham", sanPham);
        intent.putExtras(bundle);
        mContext.startActivity(intent);

    }

    @Override
    public int getItemCount() {

        if(msanPhams != null) {
            return msanPhams.size();
        }
        return 0;
    }

    public class SanPhamViewHolder extends RecyclerView.ViewHolder {
        private CardView layoutItem;
        private ImageView imgSanPham;
        private TextView tenSanPham;
        private TextView giaSanPham;


        public SanPhamViewHolder(@NonNull View itemView) {
            super(itemView);
            layoutItem = itemView.findViewById(R.id.layout_item_photo_sanpham);
            imgSanPham = itemView.findViewById(R.id.img_sanpham);
            tenSanPham = itemView.findViewById(R.id.ten_sanpham);
            giaSanPham = itemView.findViewById(R.id.gia_sanpham);
        }
    }
}
