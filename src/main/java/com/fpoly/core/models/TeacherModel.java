/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpoly.core.models;

import java.util.Date;

/**
 *
 * @author acer
 */
public class TeacherModel {

    private String tenTK, tenGV, maGV, bangCap, chuyenNganh, matKhau, email, sdt, queQuan, danToc;
    private Date ngayVaoLam, ngaySinh;

    public TeacherModel(String tenTK, String tenGV, String maGV, String bangCap, Date ngayVaoLam, String chuyenNganh, String matKhau, Date ngaySinh, String email, String sdt, String queQuan, String danToc) {
        this.tenTK = tenTK;
        this.tenGV = tenGV;
        this.maGV = maGV;
        this.bangCap = bangCap;
        this.chuyenNganh = chuyenNganh;
        this.matKhau = matKhau;
        this.email = email;
        this.sdt = sdt;
        this.queQuan = queQuan;
        this.danToc = danToc;
        this.ngayVaoLam = ngayVaoLam;
        this.ngaySinh = ngaySinh;
    }

    public String getBangCap() {
        return bangCap;
    }

    public void setBangCap(String bangCap) {
        this.bangCap = bangCap;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {

        this.ngaySinh = ngaySinh;
    }

    public String getTenTK() {
        return tenTK;
    }

    public void setTenTK(String tenTK) {
        this.tenTK = tenTK;
    }

    public String getTenGV() {
        return tenGV;
    }

    public void setTenGV(String tenGV) {
        this.tenGV = tenGV;
    }

    public String getMaGV() {
        return maGV;
    }

    public void setMaGV(String maGV) {
        this.maGV = maGV;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDanToc() {
        return danToc;
    }

    public void setDanToc(String danToc) {
        this.danToc = danToc;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getChuyenNganh() {
        return chuyenNganh;
    }

    public void setChuyenNganh(String chuyenNganh) {
        this.chuyenNganh = chuyenNganh;
    }

    public Date getNgayVaoLam() {
        return ngayVaoLam;
    }

    public void setNgayVaoLam(Date ngayVaoLam) {
        this.ngayVaoLam = ngayVaoLam;
    }

    public TeacherModel() {
    }
}
