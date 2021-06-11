package com.example.xeviet.ui.login;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.xeviet.MainActivity;
import com.example.xeviet.R;
import com.example.xeviet.ui.person.InforFragment;
import com.example.xeviet.ui.person.PersonFragment;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    EditText edtEmail, edtPassword;
    Button btnLogin;
    TextView txtRegister,txt_ten_person;

    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        mAuth = FirebaseAuth.getInstance();
        AnhXa();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DangNhap();
            }
        });
        txtRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Login.this,Register.class);
                startActivity(intent);
            }
        });

    }
    protected void DangNhap(){
        String email= edtEmail.getText().toString();
        String password=edtPassword.getText().toString();

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(Login.this, "Dang nhap thanh cong", Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(Login.this, MainActivity.class);
                            intent.putExtra("ten",email);
                            startActivity(intent);

                        }
                        else {
                            Toast.makeText(Login.this, "Dang nhap loi", Toast.LENGTH_SHORT).show();
                        }

                    }
                });

    }


    private void AnhXa(){
        btnLogin=(Button)findViewById(R.id.btnLogin);
        edtEmail=(EditText)findViewById(R.id.edtEmail);
        edtPassword=(EditText)findViewById(R.id.edtPassword);
        txtRegister=(TextView)findViewById(R.id.txtRegister);
        txt_ten_person=(TextView)findViewById(R.id.txt_ten_person);
    }

}
