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

public class LoaiXeAdapter extends RecyclerView.Adapter<LoaiXeAdapter.ViewHolder> {
    public List<LoaiXe> loaiXeList;
    Context ctx;

    public LoaiXeAdapter(List<LoaiXe> loaiXeList, Context ctx) {
        this.loaiXeList = loaiXeList;
        this.ctx = ctx;
    }

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleview_item_loai_xe,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {
        holder.TenXe.setText(loaiXeList.get(position).getTenXe());
        holder.IconXe.setBackgroundResource(loaiXeList.get(position).getIconXe());
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView TenXe;
        ImageView IconXe;
        public ViewHolder(View view) {
            super(view);
            TenXe=(TextView)view.findViewById(R.id.ten_loai_xe);
            IconXe=(ImageView)view.findViewById(R.id.icon_loai_xe);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position=getLayoutPosition();
            LoaiXe loaiXe=loaiXeList.get(position);
            Toast.makeText(ctx, loaiXe.getTenXe(), Toast.LENGTH_SHORT).show();
        }
    }
}
