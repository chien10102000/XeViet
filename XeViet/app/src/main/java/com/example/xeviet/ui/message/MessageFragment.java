package com.example.xeviet.ui.message;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.xeviet.R;
import java.util.ArrayList;
import java.util.List;

public class MessageFragment extends Fragment {
    RecyclerView recyclerViewMessage;
    List<Message> messageList=new ArrayList<>();
    MessageAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_message,container,false);

        recyclerViewMessage=(RecyclerView) view.findViewById(R.id.recycleview_tinnhan);
        setMessageData();

        adapter=new MessageAdapter(messageList, view.getContext());
        LinearLayoutManager manager=new LinearLayoutManager(view.getContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerViewMessage.setLayoutManager(manager);
        recyclerViewMessage.setAdapter(adapter);

        return view;
    }

    private void setMessageData() {
        Message message;

        message =new Message("Nguyễn Thế Chiến","Đây là tin nhắn 1","13-5-2021",R.drawable.icon_favorite_black);
        messageList.add(message);

        message =new Message("Nguyễn Thế Chiến 2","Đây là tin nhắn 2","Hôm qua",R.drawable.icon_favorite_black);
        messageList.add(message);

        message =new Message("Nguyễn Thế Chiến 3","Đây là tin nhắn 3","13-5-2021",R.drawable.icon_favorite_black);
        messageList.add(message);

        message =new Message("Nguyễn Thế Chiến 4","Đây là tin nhắn 4","Hôm kìa1",R.drawable.icon_favorite_black);
        messageList.add(message);

        message =new Message("Nguyễn Thế Chiến 5","Đây là tin nhắn 5","13-5-2021",R.drawable.icon_favorite_black);
        messageList.add(message);

        message =new Message("Nguyễn Thế Chiến 6","Đây là tin nhắn 5","13-5-2021",R.drawable.icon_favorite_black);
        messageList.add(message);

        message =new Message("Nguyễn Thế Chiến 7","Đây là tin nhắn 5","13-5-2021",R.drawable.icon_favorite_black);
        messageList.add(message);

        message =new Message("Nguyễn Thế Chiến 8","Đây là tin nhắn 5","13-5-2021",R.drawable.icon_favorite_black);
        messageList.add(message);

        message =new Message("Nguyễn Thế Chiến 9","Đây là tin nhắn 5","13-5-2021",R.drawable.icon_favorite_black);
        messageList.add(message);
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
