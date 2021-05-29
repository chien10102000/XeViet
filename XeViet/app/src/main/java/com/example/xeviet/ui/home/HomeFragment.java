package com.example.xeviet.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.xeviet.R;
import com.example.xeviet.databinding.FragmentHomeBinding;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    RecyclerView recyclerView,recyclerView_thuongHieu,recyclerView_SanPham;
    List<LoaiXe> loaiXeList=new ArrayList<>();
    LoaiXeAdapter adapter;

    List<ThuongHieu> thuongHieuList=new ArrayList<>();
    ThuongHieuAdapter adapter_thuongHieu;

    List<SanPham> sanPhamList=new ArrayList<>();
    SanPhamAdapter adapter_SanPham;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
//        recyclerView loai xe
        recyclerView=(RecyclerView) root.findViewById(R.id.recycle_view_loaixe);
        setLoaiXe();

        adapter=new LoaiXeAdapter(loaiXeList, root.getContext());
        LinearLayoutManager manager=new LinearLayoutManager(root.getContext());
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);

        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);

//      recyclerView thuong hieu

        recyclerView_thuongHieu=(RecyclerView) root.findViewById(R.id.recycle_view_thuong_hieu);
        setThuongHieu();

        adapter_thuongHieu=new ThuongHieuAdapter(thuongHieuList, root.getContext());
        LinearLayoutManager manager_thuongHieu=new LinearLayoutManager(root.getContext());
        manager_thuongHieu.setOrientation(LinearLayoutManager.HORIZONTAL);

        recyclerView_thuongHieu.setLayoutManager(manager_thuongHieu);
        recyclerView_thuongHieu.setAdapter(adapter_thuongHieu);

//        recyclerView san pham
        recyclerView_SanPham=(RecyclerView) root.findViewById(R.id.recycleview_tatCaSanPham);
        setSanPhamData();

        adapter_SanPham=new SanPhamAdapter(sanPhamList, root.getContext());
        LinearLayoutManager manager_sanpham=new LinearLayoutManager(root.getContext());

        StaggeredGridLayoutManager gridLayoutManager =
                new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
// Attach the layout manager to the recycler view
        recyclerView_SanPham.setLayoutManager(gridLayoutManager);

        recyclerView_SanPham.setAdapter(adapter_SanPham);

        return root;
    }

    private void setLoaiXe() {
        LoaiXe loaiXe;

        loaiXe =new LoaiXe(R.drawable.icon_all, "Tất cả");
        loaiXeList.add(loaiXe);

        loaiXe =new LoaiXe(R.drawable.xe_ga, "Xe tay ga");
        loaiXeList.add(loaiXe);

        loaiXe =new LoaiXe(R.drawable.xe_so,"Xe số");
        loaiXeList.add(loaiXe);

        loaiXe =new LoaiXe(R.drawable.xe_pkl,"Xe PKL");
        loaiXeList.add(loaiXe);

        loaiXe =new LoaiXe(R.drawable.xe_dien, "Xe điện");
        loaiXeList.add(loaiXe);
    }

    private void setThuongHieu() {
        ThuongHieu thuongHieu;

        thuongHieu =new ThuongHieu("Tất cả",R.drawable.icon_all);
        thuongHieuList.add(thuongHieu);

        thuongHieu =new ThuongHieu("Yamaha",R.drawable.yamaha);
        thuongHieuList.add(thuongHieu);

        thuongHieu =new ThuongHieu("SYM",R.drawable.sym);
        thuongHieuList.add(thuongHieu);

        thuongHieu =new ThuongHieu("Honda",R.drawable.honda);
        thuongHieuList.add(thuongHieu);

        thuongHieu =new ThuongHieu("Suzuki",R.drawable.suzuki);
        thuongHieuList.add(thuongHieu);

        thuongHieu =new ThuongHieu("HKBike",R.drawable.hk_bike);
        thuongHieuList.add(thuongHieu);

    }
    private void setSanPhamData() {
        SanPham sanPham;

        sanPham =new SanPham(R.drawable.android,"5000000","Vision","12-5-2021");
        sanPhamList.add(sanPham);

        sanPham =new SanPham(R.drawable.android,"5000000","exciter","12-5-2021");
        sanPhamList.add(sanPham);

        sanPham =new SanPham(R.drawable.android,"5000000","R15V3 Yamaha","12-5-2021");
        sanPhamList.add(sanPham);

        sanPham =new SanPham(R.drawable.android,"5000000","honda dream","12-5-2021");
        sanPhamList.add(sanPham);

        sanPham =new SanPham(R.drawable.android,"5000000","wave alpha","12-5-2021");
        sanPhamList.add(sanPham);

        sanPham =new SanPham(R.drawable.android,"5000000","winner","12-5-2021");
        sanPhamList.add(sanPham);

        sanPham =new SanPham(R.drawable.android,"5000000","kawasaki z1000","12-5-2021");
        sanPhamList.add(sanPham);

        sanPham =new SanPham(R.drawable.android,"5000000","SH mode","12-5-2021");
        sanPhamList.add(sanPham);

        sanPham =new SanPham(R.drawable.android,"5000000","SH Italia","12-5-2021");
        sanPhamList.add(sanPham);

        sanPham =new SanPham(R.drawable.android,"5000000","HK Bike","12-5-2021");
        sanPhamList.add(sanPham);

        sanPham =new SanPham(R.drawable.android,"5000000","CBR 1000RR","12-5-2021");
        sanPhamList.add(sanPham);

        sanPham =new SanPham(R.drawable.android,"5000000","Ducati","12-5-2021");
        sanPhamList.add(sanPham);

    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}