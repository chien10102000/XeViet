package com.example.xeviet.ui.person;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.xeviet.R;
import com.example.xeviet.ui.login.Login;
import com.example.xeviet.ui.login.Register;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class PersonFragment extends Fragment {
    RecyclerView recyclerViewPerson;
    List<PersonFormOption> personFormOptionList=new ArrayList<>();
    PersonAdapter adapter;
    TextView txt_ten_person;
    ImageView img_Setting;

    View view;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        view= inflater.inflate(R.layout.fragment_person,container,false);

        recyclerViewPerson=(RecyclerView) view.findViewById(R.id.recycleview_person_option);
        setPersonOption();

        adapter=new PersonAdapter(personFormOptionList, view.getContext());
        LinearLayoutManager manager=new LinearLayoutManager(view.getContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerViewPerson.setLayoutManager(manager);
        recyclerViewPerson.setAdapter(adapter);

        AnhXa();
        Intent intent= null;

        intent = this.getActivity().getIntent();
        String layemail=intent.getStringExtra("ten");

        if (intent.getStringExtra("ten")!=null){
            txt_ten_person.setText(layemail);

        }

        txt_ten_person.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txt_ten_person.getText().toString().equals("ĐĂNG NHẬP")){
                    Intent intentLogin=new Intent(getContext(), Login.class);
                    startActivity(intentLogin);
                }
                else{
                    Intent intentInfo=new Intent(getContext(), InforFragment.class);
                    intentInfo.putExtra("layemail",layemail);
                    startActivity(intentInfo);
                }
            }
        });
        img_Setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txt_ten_person.getText().toString().equals("ĐĂNG NHẬP")){
                    Intent intentlogin=new Intent(getContext(), Login.class);
                    startActivity(intentlogin);
                }
                else{
                    Intent intentInfo=new Intent(getContext(), InforFragment.class);
                    intentInfo.putExtra("layemail",layemail);
                    startActivity(intentInfo);
                }
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
    private void AnhXa(){
        img_Setting=(ImageView) view.findViewById(R.id.img_setting);
        txt_ten_person=(TextView)view.findViewById(R.id.txt_ten_person);
    }
}
