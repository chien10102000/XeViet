package com.example.xeviet.ui.shopping;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.xeviet.R;
import java.util.ArrayList;
import java.util.List;

public class ShoppingFragment extends Fragment {
    RecyclerView recyclerViewShopping;
    List<Shopping> shoppingList=new ArrayList<>();
    ShoppingAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_shopping,container,false);

        recyclerViewShopping=(RecyclerView) view.findViewById(R.id.recycleview_giohang);
        setShoppingData();

        adapter=new ShoppingAdapter(shoppingList, view.getContext());
        LinearLayoutManager manager=new LinearLayoutManager(view.getContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerViewShopping.setLayoutManager(manager);
        recyclerViewShopping.setAdapter(adapter);

        return view;
    }
    private void setShoppingData() {
        Shopping giohang;

        giohang =new Shopping("Nguyễn Thế Chiến","Wave tàu",2000000,1000000,1,R.drawable.xe_pkl);
        shoppingList.add(giohang);

        giohang =new Shopping("Nguyễn Thế Chiến 2","Dream",2000000,1000000,1,R.drawable.xe_so);
        shoppingList.add(giohang);

        giohang =new Shopping("Nguyễn Thế Chiến 3","SH",2000000,1000000,1,R.drawable.xe_ga);
        shoppingList.add(giohang);

        giohang =new Shopping("Nguyễn Thế Chiến 4","Winner",2000000,1000000,1,R.drawable.xe_so);
        shoppingList.add(giohang);

        giohang =new Shopping("Nguyễn Thế Chiến 5","Ex",2000000,1000000,1, R.drawable.xe_so);
        shoppingList.add(giohang);

        giohang =new Shopping("Nguyễn Thế Chiến 6","Vision",2000000,1000000,1, R.drawable.xe_ga);
        shoppingList.add(giohang);
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
