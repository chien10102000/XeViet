package com.example.xeviet.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.xeviet.R;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class SanPhamAdapter extends RecyclerView.Adapter<SanPhamAdapter.ViewHolder>{
    List<SanPham> sanPhamList;
    Context ctx;

    public SanPhamAdapter(List<SanPham> sanPhamList, Context ctx) {
        this.sanPhamList = sanPhamList;
        this.ctx = ctx;
    }

    @NonNull
    @NotNull
    @Override
    public SanPhamAdapter.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleview_sanpham,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull SanPhamAdapter.ViewHolder holder, int position) {
        holder.TenSanPham.setText(sanPhamList.get(position).getTenSanPham());
        holder.GiaSanPham.setText(sanPhamList.get(position).getGiaSanPham());
        holder.ThoiGian.setText(sanPhamList.get(position).getThoiGian());
        holder.AnhSanPham.setBackgroundResource(sanPhamList.get(position).getAnhSanPham());
    }

    @Override
    public int getItemCount() {
        return 12;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView TenSanPham, GiaSanPham, ThoiGian;
        ImageView AnhSanPham;
        public ViewHolder(View view) {
            super(view);
            TenSanPham=(TextView)view.findViewById(R.id.tv_tensp);
            GiaSanPham=(TextView)view.findViewById(R.id.tv_giasp);
            ThoiGian=(TextView)view.findViewById(R.id.tv_thoigian);
            AnhSanPham=(ImageView)view.findViewById(R.id.img_sanpham);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position=getLayoutPosition();
            SanPham sanPham=sanPhamList.get(position);
            Toast.makeText(ctx, sanPham.getTenSanPham(), Toast.LENGTH_SHORT).show();
        }
    }
}
