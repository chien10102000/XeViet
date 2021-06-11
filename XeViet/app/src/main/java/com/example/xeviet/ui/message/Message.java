package com.example.xeviet.ui.message;

public class Message {
    String TenNguoiBan,TinNhan, ThoiGian;
    int AnhMonHang;

    public Message(String tenNguoiBan, String tinNhan, String thoiGian, int anhMonHang) {
        TenNguoiBan = tenNguoiBan;
        TinNhan = tinNhan;
        ThoiGian = thoiGian;
        AnhMonHang = anhMonHang;
    }

    public String getTenNguoiBan() {
        return TenNguoiBan;
    }

    public void setTenNguoiBan(String tenNguoiBan) {
        TenNguoiBan = tenNguoiBan;
    }

    public String getTinNhan() {
        return TinNhan;
    }

    public void setTinNhan(String tinNhan) {
        TinNhan = tinNhan;
    }

    public String getThoiGian() {
        return ThoiGian;
    }

    public void setThoiGian(String thoiGian) {
        ThoiGian = thoiGian;
    }

    public int getAnhMonHang() {
        return AnhMonHang;
    }

    public void setAnhMonHang(int anhMonHang) {
        AnhMonHang = anhMonHang;
    }
}
