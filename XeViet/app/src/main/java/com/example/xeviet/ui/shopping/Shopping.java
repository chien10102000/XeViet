package com.example.xeviet.ui.shopping;

public class Shopping {
    String TenNguoiBan, TenSanPham;
    int GiaNiemYet, GiaKM, SoLuong;
    int AnhSanPham;

    public Shopping() {
    }

    public Shopping(String tenNguoiBan, String tenSanPham, int giaNiemYet, int giaKM, int soLuong, int anhSanPham) {
        TenNguoiBan = tenNguoiBan;
        TenSanPham = tenSanPham;
        GiaNiemYet = giaNiemYet;
        GiaKM = giaKM;
        SoLuong = soLuong;
        AnhSanPham = anhSanPham;
    }

    public String getTenNguoiBan() {
        return TenNguoiBan;
    }

    public void setTenNguoiBan(String tenNguoiBan) {
        TenNguoiBan = tenNguoiBan;
    }

    public String getTenSanPham() {
        return TenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        TenSanPham = tenSanPham;
    }

    public int getGiaNiemYet() {
        return GiaNiemYet;
    }

    public void setGiaNiemYet(int giaNiemYet) {
        GiaNiemYet = giaNiemYet;
    }

    public int getGiaKM() {
        return GiaKM;
    }

    public void setGiaKM(int giaKM) {
        GiaKM = giaKM;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int soLuong) {
        SoLuong = soLuong;
    }

    public int getAnhSanPham() {
        return AnhSanPham;
    }

    public void setAnhSanPham(int anhSanPham) {
        AnhSanPham = anhSanPham;
    }

}
