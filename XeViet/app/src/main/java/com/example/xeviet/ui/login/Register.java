package com.example.xeviet.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.xeviet.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {
    EditText edtEmail, edtPassword, edtConfirm;
    Button btnRegister;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        mAuth = FirebaseAuth.getInstance();

        AnhXa();
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DangKy();
            }
        });
    }
    protected void DangKy(){
        String email= edtEmail.getText().toString();
        String password=edtPassword.getText().toString();
        String confirm=edtConfirm.getText().toString();
        if (password.equals(confirm)){
            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(Register.this, "DK thanh cong", Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(Register.this,Login.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(Register.this, "DK khong thanh cong", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
        else Toast.makeText(this, "Mat khau khong khop", Toast.LENGTH_SHORT).show();
    }
    private void AnhXa(){
        edtEmail=(EditText)findViewById(R.id.edtRegisterEmail);
        edtPassword=(EditText)findViewById(R.id.edtRegisterPassword);
        edtConfirm=(EditText)findViewById(R.id.edtRegisterConfirm);
        btnRegister=(Button)findViewById(R.id.btnRegister);
    }
}
