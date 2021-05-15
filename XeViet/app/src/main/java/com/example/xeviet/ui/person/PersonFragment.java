package com.example.xeviet.ui.person;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.xeviet.R;
import java.util.ArrayList;
import java.util.List;

public class PersonFragment extends Fragment {
    RecyclerView recyclerViewPerson;
    List<PersonFormOption> personFormOptionList=new ArrayList<>();
    PersonAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_person,container,false);

        recyclerViewPerson=(RecyclerView) view.findViewById(R.id.recycleview_person_option);
        setPersonOption();

        adapter=new PersonAdapter(personFormOptionList, view.getContext());
        LinearLayoutManager manager=new LinearLayoutManager(view.getContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerViewPerson.setLayoutManager(manager);
        recyclerViewPerson.setAdapter(adapter);

//        setting
        ImageView img_Setting=(ImageView) view.findViewById(R.id.img_setting);
        img_Setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return view;
    }

    private void setPersonOption() {
        PersonFormOption option;

        option =new PersonFormOption(R.drawable.icon_favorite_black, "Sản phẩm yêu thích");
        personFormOptionList.add(option);

        option =new PersonFormOption(R.drawable.xe_ga, "Xe đang bán");
        personFormOptionList.add(option);

        option =new PersonFormOption(R.drawable.xe_so,"Xe đã mua");
        personFormOptionList.add(option);

        option =new PersonFormOption(R.drawable.xe_pkl,"Trung tâm trợ giúp");
        personFormOptionList.add(option);

        option =new PersonFormOption(R.drawable.xe_dien, "Phiên bản");
        personFormOptionList.add(option);

        option =new PersonFormOption(R.drawable.xe_dien, "Điều khoản");
        personFormOptionList.add(option);
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
