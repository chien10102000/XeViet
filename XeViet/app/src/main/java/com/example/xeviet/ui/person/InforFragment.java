package com.example.xeviet.ui.person;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.xeviet.MainActivity;
import com.example.xeviet.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

public class InforFragment extends AppCompatActivity {
    EditText edtInfoName, edtInfoPhone,edtInfoAddress;
    Button btnSave;

    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info);

        mDatabase = FirebaseDatabase.getInstance().getReference();
        AnhXa();

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addUser();
            }
        });
    }
    static String encodeUserEmail(String userEmail) {
        return userEmail.replace(".", ",");
    }
    private void addUser(){
        Intent intentInfoEmail = getIntent();
        Info info=new Info(edtInfoName.getText().toString(),Double.parseDouble(edtInfoPhone.getText().toString()),edtInfoAddress.getText().toString());

        Intent intentPerson=new Intent(InforFragment.this, MainActivity.class);

        mDatabase.child("User").child(encodeUserEmail(intentInfoEmail.getStringExtra("layemail"))).setValue(info, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(@Nullable @org.jetbrains.annotations.Nullable DatabaseError error, @NonNull @NotNull DatabaseReference ref) {
                if (error.equals(null)){
                    Toast.makeText(InforFragment.this, "Lưu thành công!", Toast.LENGTH_SHORT).show();
                    intentPerson.putExtra("RealName",info.InfoName);
                    startActivity(intentPerson);
                }
                else Toast.makeText(InforFragment.this, "Lưu lỗi!!!", Toast.LENGTH_SHORT).show();
            }
        });

    }
    private void AnhXa(){
        btnSave=(Button)findViewById(R.id.btnInfoSave);
        edtInfoName=(EditText)findViewById(R.id.edtInfoName);
        edtInfoPhone=(EditText)findViewById(R.id.edtInfoPhone);
        edtInfoAddress=(EditText)findViewById(R.id.edtInfoAddress);
    }
}

