package com.fpoly.core.models;

import java.util.Date;

public class StudentModel {

    private String tenTK, MK;
    String tenSV, maSV, khoa, hocKy, nganhHoc, email, soDienThoai, queQuan, danToc;
    Date ngaySinh, ngayNhapHoc;

    public StudentModel(String tenTK, String MK, String tenSV, String maSV, String khoa, String hocKy, String nganhHoc, Date ngaySinh, Date ngayNhapHoc, String email, String soDienThoai, String queQuan, String danToc) {
        this.tenTK = tenTK;
        this.MK = MK;
        this.tenSV = tenSV;
        this.maSV = maSV;
        this.khoa = khoa;
        this.hocKy = hocKy;
        this.nganhHoc = nganhHoc;
        this.email = email;
        this.soDienThoai = soDienThoai;
        this.queQuan = queQuan;
        this.danToc = danToc;
        this.ngaySinh = ngaySinh;
        this.ngayNhapHoc = ngayNhapHoc;
    }

    public String getTenSV() {
        return tenSV;
    }

    public void setTenSV(String tenSV) {
        this.tenSV = tenSV;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getKhoa() {
        return khoa;
    }

    public void setKhoa(String khoa) {
        this.khoa = khoa;
    }

    public String getHocKy() {
        return hocKy;
    }

    public void setHocKy(String hocKy) {
        this.hocKy = hocKy;
    }

    public String getNganhHoc() {
        return nganhHoc;
    }

    public void setNganhHoc(String nganhHoc) {
        this.nganhHoc = nganhHoc;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    public String getDanToc() {
        return danToc;
    }

    public void setDanToc(String danToc) {
        this.danToc = danToc;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public Date getNgayNhapHoc() {
        return ngayNhapHoc;
    }

    public void setNgayNhapHoc(Date ngayNhapHoc) {
        this.ngayNhapHoc = ngayNhapHoc;
    }

    public StudentModel() {
    }

    public StudentModel(String tenTK, String MK) {
        this.tenTK = tenTK;
        this.MK = MK;
    }

    public String getTenTK() {
        return tenTK;
    }

    public void setTenTK(String tenTK) {
        this.tenTK = tenTK;
    }

    public String getMK() {
        return MK;
    }

    public void setMK(String MK) {
        this.MK = MK;
    }
}
