package com.example.xeviet.ui.home;

public class SanPham {
    int AnhSanPham;
    String GiaSanPham, TenSanPham, ThoiGian;

    public SanPham(int anhSanPham, String giaSanPham, String tenSanPham, String thoiGian) {
        AnhSanPham = anhSanPham;
        GiaSanPham = giaSanPham;
        TenSanPham = tenSanPham;
        ThoiGian = thoiGian;
    }

    public int getAnhSanPham() {
        return AnhSanPham;
    }

    public void setAnhSanPham(int anhSanPham) {
        AnhSanPham = anhSanPham;
    }

    public String getGiaSanPham() {
        return GiaSanPham;
    }

    public void setGiaSanPham(String giaSanPham) {
        GiaSanPham = giaSanPham;
    }

    public String getTenSanPham() {
        return TenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        TenSanPham = tenSanPham;
    }

    public String getThoiGian() {
        return ThoiGian;
    }

    public void setThoiGian(String thoiGian) {
        ThoiGian = thoiGian;
    }
}
