package com.fpoly.core.models;

public class StudentModel {

    private String tenTK, MK;

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
