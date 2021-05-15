package com.example.xeviet.ui.shopping;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.xeviet.R;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ShoppingAdapter extends RecyclerView.Adapter<ShoppingAdapter.ViewHolder> {
    public List<Shopping> shoppingList;
    Context ctx;

    public ShoppingAdapter(List<Shopping> shoppingList, Context ctx) {
        this.shoppingList = shoppingList;
        this.ctx = ctx;
    }

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleview_giohang,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {
        holder.TenNguoiBan.setText(shoppingList.get(position).getTenNguoiBan());
        holder.TenSanPham.setText(shoppingList.get(position).getTenSanPham());
        holder.SoLuong.setText(String.valueOf(shoppingList.get(position).getSoLuong()));
        holder.GiaNiemYet.setText(String.valueOf(shoppingList.get(position).getGiaNiemYet()));
        holder.GiaKM.setText(String.valueOf(shoppingList.get(position).getGiaKM()));
        holder.ImgSanPham.setBackgroundResource(shoppingList.get(position).getAnhSanPham());
    }

    @Override
    public int getItemCount() {
        return 6;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView TenNguoiBan, TenSanPham, SoLuong,GiaNiemYet,GiaKM;
        ImageView ImgSanPham;

        public ViewHolder(View view) {
            super(view);
            TenNguoiBan=(TextView)view.findViewById(R.id.tv_tenngban);
            TenSanPham=(TextView)view.findViewById(R.id.tv_tensp);
            SoLuong=(TextView) view.findViewById(R.id.tv_soluong);
            GiaNiemYet=(TextView)view.findViewById(R.id.tv_gia_niemyet);
            GiaKM=(TextView)view.findViewById(R.id.tv_gia_km);
            ImgSanPham=(ImageView) view.findViewById(R.id.img_sanpham);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position=getLayoutPosition();
            Shopping option=shoppingList.get(position);
            Toast.makeText(ctx, option.getTenSanPham(), Toast.LENGTH_SHORT).show();
        }
    }
}
