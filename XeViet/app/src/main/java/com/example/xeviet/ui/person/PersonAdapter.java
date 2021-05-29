package com.example.xeviet.ui.person;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
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
        return 6;
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

            switch (position){
                case 0:
                    Toast.makeText(ctx, "Sản phẩm yêu thích", Toast.LENGTH_SHORT).show();
                    break;
                case 1:
                    Toast.makeText(ctx, "Xe đang bán", Toast.LENGTH_SHORT).show();
                    break;
                case 2:
                    Toast.makeText(ctx, "Xe đã bán", Toast.LENGTH_SHORT).show();
                    break;
                case 3:
                    Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/Xe-Vi%E1%BB%87t-103142368648408/"));
                    ctx.startActivity(intent);
                    break;
                case 4:
                    AlertDialog.Builder alertPhienBan=new AlertDialog.Builder(v.getContext());
                    alertPhienBan.setTitle("Phiên bản");
                    alertPhienBan.setMessage("Xe Việt\nPhiên bản 1.0.0\nMade by Công ty TNHH Xe Việt");
                    alertPhienBan.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
                    AlertDialog al=alertPhienBan.create(); 
                    al.show();
                    break;
                case 5:
                    Intent intent2=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/permalink.php?story_fbid=103272251968753&id=103142368648408"));
                    ctx.startActivity(intent2);
                    break;
                default:
                    Toast.makeText(ctx, "Loi!!!", Toast.LENGTH_SHORT).show();
            }
        }
    }


}
