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

public class ThuongHieuAdapter extends RecyclerView.Adapter<ThuongHieuAdapter.ViewHolder>{
    public List<ThuongHieu> thuongHieuList;
    Context ctx;

    public ThuongHieuAdapter(List<ThuongHieu> thuongHieuList, Context ctx) {
        this.thuongHieuList = thuongHieuList;
        this.ctx = ctx;
    }

    @NonNull
    @NotNull
    @Override
    public ThuongHieuAdapter.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_view_thuong_hieu,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ThuongHieuAdapter.ViewHolder holder, int position) {
        holder.TenThuongHieu.setText(thuongHieuList.get(position).getTenThuongHieu());
        holder.AnhThuongHieu.setBackgroundResource(thuongHieuList.get(position).getAnhThuongHieu());
    }

    @Override
    public int getItemCount() {
        return 6;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView TenThuongHieu;
        ImageView AnhThuongHieu;
        public ViewHolder(View view) {
            super(view);
            TenThuongHieu=(TextView)view.findViewById(R.id.tv_ten_thuong_hieu);
            AnhThuongHieu=(ImageView)view.findViewById(R.id.img_thuong_hieu);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position=getLayoutPosition();
            ThuongHieu thuongHieu=thuongHieuList.get(position);
            Toast.makeText(ctx, thuongHieu.getTenThuongHieu(), Toast.LENGTH_SHORT).show();
        }
    }
}
