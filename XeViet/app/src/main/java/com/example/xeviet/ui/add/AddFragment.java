package com.example.xeviet.ui.add;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
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
import androidx.lifecycle.ViewModelProvider;

import com.example.xeviet.R;
import com.google.firebase.storage.FirebaseStorage;

import static android.app.Activity.RESULT_OK;

public class AddFragment extends Fragment {
    ImageView btnAddAvatar,btnAddAnh1,btnAddAnh2,btnAddAnh3,btnAddAnh4,
            btnAddAnh5,btnAddAnh6,btnAddAnh7,btnAddAnh8;
    ImageView imgAvatar,imgAnh1,imgAnh2,imgAnh3,imgAnh4,imgAnh5,imgAnh6,imgAnh7,imgAnh8;
    View view;

    int REQUEST_CODE_IMAGE=1;
    int PICK_IMAGE=1;
    FirebaseStorage storage = FirebaseStorage.getInstance();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        view= inflater.inflate(R.layout.fragment_add,container,false);
        String str="Nguyenthechien";
        str.length();

        AnhXa();

        btnAddAvatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] items = {"Chụp ảnh", "Chọn ảnh từ thư viện"};
                AlertDialog.Builder b = new AlertDialog.Builder(getActivity());
                //Thiết lập title
                b.setTitle("Thêm ảnh");
//Thiết lập item
                b.setItems(items, new DialogInterface.OnClickListener() {
                    //Xử lý sự kiện
                    public void onClick(DialogInterface dialog, int which) {
                        if (which==0){
                            Intent intentCam=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                            startActivityForResult(intentCam,REQUEST_CODE_IMAGE);

                        }
                        else if (which==1){
                            Intent getIntent = new Intent(Intent.ACTION_GET_CONTENT);
                            getIntent.setType("image/*");

                            Intent pickIntent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                            pickIntent.setType("image/*");

                            Intent chooserIntent = Intent.createChooser(getIntent, "Select Image");
                            chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, new Intent[] {pickIntent});

                            startActivityForResult(chooserIntent, PICK_IMAGE);
                        }
                    }
                });
//Hiển thị dialog
                b.show();
            }
        });

        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable @org.jetbrains.annotations.Nullable Intent data) {
        if (requestCode== REQUEST_CODE_IMAGE&&resultCode==RESULT_OK&&data!=null){
            Bitmap bitmap=(Bitmap) data.getExtras().get("data");
            imgAvatar.setImageBitmap(bitmap);
        }
        super.onActivityResult(requestCode,resultCode,data);
    }
    
    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
    private void AnhXa(){
        btnAddAvatar=(ImageView)view.findViewById(R.id.btnAddAvatar);
        btnAddAnh1=(ImageView)view.findViewById(R.id.btnAddAnh1);
        btnAddAnh2=(ImageView)view.findViewById(R.id.btnAddAnh2);
        btnAddAnh3=(ImageView)view.findViewById(R.id.btnAddAnh3);
        btnAddAnh4=(ImageView)view.findViewById(R.id.btnAddAnh4);
        btnAddAnh5=(ImageView)view.findViewById(R.id.btnAddAnh5);
        btnAddAnh6=(ImageView)view.findViewById(R.id.btnAddAnh6);
        btnAddAnh7=(ImageView)view.findViewById(R.id.btnAddAnh7);
        btnAddAnh8=(ImageView)view.findViewById(R.id.btnAddAnh8);

        imgAvatar=(ImageView) view.findViewById(R.id.img_anh_avatar);
    }
}
