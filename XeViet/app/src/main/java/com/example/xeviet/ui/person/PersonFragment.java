package com.example.xeviet.ui.person;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.xeviet.R;
import com.example.xeviet.ui.login.Login;
import com.example.xeviet.ui.login.Register;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

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

    DatabaseReference mDatabase;
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

        mDatabase = FirebaseDatabase.getInstance().getReference();

        AnhXa();
        Intent intent= null;

        intent = this.getActivity().getIntent();
        String layemail=intent.getStringExtra("ten");


//        Info info= null;
//        if (intent.getStringExtra("ten")!=null){
//            mDatabase.child("User").child(encodeUserEmail(layemail)).addListenerForSingleValueEvent(new ValueEventListener() {
//                @Override
//                public void onDataChange(DataSnapshot dataSnapshot) {
//                    Info info = dataSnapshot.getValue(Info.class);
//                    txt_ten_person.setText(info.InfoName);
//                }
//
//                @Override
//                public void onCancelled(DatabaseError databaseError) {
//
//                }
//            });
//        }
        if (layemail!=null){
                    mDatabase.child("User").child(encodeUserEmail(layemail)).child("infoName").addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            if(dataSnapshot==null){
                                txt_ten_person.setText(layemail);
                            }
                            else {
                                txt_ten_person.setText(dataSnapshot.getValue().toString());
                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                            txt_ten_person.setText(layemail);
                        }
                    });
        }
//        if (layemail!=null){
//            mDatabase.child("User").child(encodeUserEmail(layemail)).child("infoName").addValueEventListener(new ValueEventListener() {
//                @Override
//                public void onDataChange(DataSnapshot dataSnapshot) {
//                    // This method is called once with the initial value and again
//                    // whenever data at this location is updated.
//
//                    Info info = dataSnapshot.getValue(Info.class);
//                    txt_ten_person.setText(info.InfoName);
//                }
//
//                @Override
//                public void onCancelled(DatabaseError error) {
//                    // Failed to read value
//                    txt_ten_person.setText(layemail);
//
//                }
//            });
//
//        }

//        txt_ten_person.setText( mDatabase.child("User").child(encodeUserEmail(layemail)).child("infoName").get().toString());




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
    static String encodeUserEmail(String layemail) {
        return layemail.replace(".", ",");
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
