package com.example.xeviet.ui.person;

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
import com.example.xeviet.ui.home.ThuongHieu;
import com.example.xeviet.ui.home.ThuongHieuAdapter;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolder>{
    public List<PersonFormOption> personFormOptionList;
    Context ctx;

    public PersonAdapter(List<PersonFormOption> personFormOptionList, Context ctx) {
        this.personFormOptionList = personFormOptionList;
        this.ctx = ctx;
    }

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleview_taikhoan,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {
        holder.TenPersonOption.setText(personFormOptionList.get(position).getTenPersonOption());
        holder.IconPerson.setBackgroundResource(personFormOptionList.get(position).getIconPerson());
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView TenPersonOption;
        ImageView IconPerson;
        public ViewHolder(View view) {
            super(view);
            TenPersonOption=(TextView)view.findViewById(R.id.tv_ten_person_option);
            IconPerson=(ImageView)view.findViewById(R.id.img_icon_person);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position=getLayoutPosition();
            PersonFormOption option=personFormOptionList.get(position);
            Toast.makeText(ctx, option.getTenPersonOption(), Toast.LENGTH_SHORT).show();
        }
    }


}
