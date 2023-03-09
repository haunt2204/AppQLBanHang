/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nth.pojo;

/**
 *
 * @author admin
 */
public class SanPham {
    private String maSP;
    private String tenSP;
    private int loaiSP;
    private float giaBanSP;

    public SanPham() {
    }

    public SanPham(String maSP, String tenSP, int loaiSP, float giaBanSP) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.loaiSP = loaiSP;
        this.giaBanSP = giaBanSP;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public int getLoaiSP() {
        return loaiSP;
    }

    public void setLoaiSP(int loaiSP) {
        this.loaiSP = loaiSP;
    }

    public float getGiaBanSP() {
        return giaBanSP;
    }

    public void setGiaBanSP(float giaBanSP) {
        this.giaBanSP = giaBanSP;
    }
    
}
