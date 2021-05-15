package com.example.xeviet.ui.home;

public class ThuongHieu {
    String TenThuongHieu;
    int AnhThuongHieu;

    public ThuongHieu() {
    }

    public ThuongHieu(String tenThuongHieu, int anhThuongHieu) {
        TenThuongHieu = tenThuongHieu;
        AnhThuongHieu = anhThuongHieu;
    }

    public String getTenThuongHieu() {
        return TenThuongHieu;
    }

    public void setTenThuongHieu(String tenThuongHieu) {
        TenThuongHieu = tenThuongHieu;
    }

    public int getAnhThuongHieu() {
        return AnhThuongHieu;
    }

    public void setAnhThuongHieu(int anhThuongHieu) {
        AnhThuongHieu = anhThuongHieu;
    }
}
