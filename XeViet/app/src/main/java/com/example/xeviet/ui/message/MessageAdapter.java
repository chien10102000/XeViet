package com.example.xeviet.ui.message;

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
import com.example.xeviet.ui.person.PersonAdapter;
import com.example.xeviet.ui.person.PersonFormOption;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class MessageAdapter  extends RecyclerView.Adapter<MessageAdapter.ViewHolder>{
    public List<Message> messageList;
    Context ctx;

    public MessageAdapter(List<Message> messageList, Context ctx) {
        this.messageList = messageList;
        this.ctx = ctx;
    }

    @NonNull
    @NotNull
    @Override
    public MessageAdapter.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleview_message,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull MessageAdapter.ViewHolder holder, int position) {
        holder.TenNguoiGui.setText(messageList.get(position).getTenNguoiBan());
        holder.TinNhan.setText(messageList.get(position).getTinNhan());
        holder.NgayNhan.setText(messageList.get(position).getThoiGian());
        holder.ImgSanPham_chat.setBackgroundResource(messageList.get(position).getAnhMonHang());
    }

    @Override
    public int getItemCount() {
        return 9;
    }
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView TenNguoiGui, TinNhan, NgayNhan;
        ImageView ImgSanPham_chat;
        public ViewHolder(View view) {
            super(view);
            TenNguoiGui=(TextView)view.findViewById(R.id.tv_TenNguoiBan_chat);
            TinNhan=(TextView)view.findViewById(R.id.tv_tinnhan);
            NgayNhan=(TextView)view.findViewById(R.id.tv_ngaynhan);
            ImgSanPham_chat=(ImageView)view.findViewById(R.id.imgSanPham_chat);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position=getLayoutPosition();
            Message message=messageList.get(position);
            Toast.makeText(ctx, message.getTenNguoiBan(), Toast.LENGTH_SHORT).show();
        }
    }
}
