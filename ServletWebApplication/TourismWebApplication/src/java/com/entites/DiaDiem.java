/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.entites;

/**
 *
 * @author ASUS
 */
public class DiaDiem {

    private int id;
    private String tenDiaDiem;
    private int idDichVu;
    private int idGia;
    private int idPhuong;
    private DichVu dichVu;
    private Gia gia;
    private Phuong phuong;
    private Quan quan;
    private ThanhPho thanhPho;

    public DiaDiem() {
    }

    public DiaDiem(int id, String tenDiaDiem, int idDichVu, int idGia, int idPhuong, DichVu dichVu, Gia gia, Phuong phuong) {
        this.id = id;
        this.tenDiaDiem = tenDiaDiem;
        this.idDichVu = idDichVu;
        this.idGia = idGia;
        this.idPhuong = idPhuong;
        this.dichVu = dichVu;
        this.gia = gia;
        this.phuong = phuong;
    }

    public DiaDiem(int id, String tenDiaDiem, int idDichVu, int idGia, int idPhuong, DichVu dichVu, Gia gia, Phuong phuong, Quan quan, ThanhPho thanhPho) {
    this.id = id;
    this.tenDiaDiem = tenDiaDiem;

    // Khởi tạo idDichVu
//    this.idDichVu = idDichVu;

    // Khởi tạo dichVu
    if (dichVu != null) {
        this.dichVu = new DichVu(idDichVu, dichVu.getTenDichVu());
    }

    // Khởi tạo idGia
//    this.idGia = idGia;

    // Khởi tạo gia
    if (gia != null) {
        this.gia = new Gia(idGia, gia.getMucGia());
    }

    // Khởi tạo idPhuong
//    this.idPhuong = idPhuong;

    // Khởi tạo phuong
    if (phuong != null) {
        this.phuong = new Phuong(idPhuong, phuong.getTenPhuong());
    }
    
    // Khởi tạo quan
    if (quan != null) {
        this.quan = new Quan(quan.getId(), quan.getTenQuan());
    }
    
    // Khởi tạo thanhPho
    if (thanhPho != null) {
        this.thanhPho = new ThanhPho(thanhPho.getId(), thanhPho.getTenThanhPho());
    }

}


    public Quan getQuan() {
        return quan;
    }

    public void setQuan(Quan quan) {
        this.quan = quan;
    }

    public ThanhPho getThanhPho() {
        return thanhPho;
    }

    public void setThanhPho(ThanhPho thanhPho) {
        this.thanhPho = thanhPho;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenDiaDiem() {
        return tenDiaDiem;
    }

    public void setTenDiaDiem(String tenDiaDiem) {
        this.tenDiaDiem = tenDiaDiem;
    }

    public int getIdDichVu() {
        return idDichVu;
    }

    public void setIdDichVu(int idDichVu) {
        this.idDichVu = idDichVu;
    }

    public int getIdGia() {
        return idGia;
    }

    public void setIdGia(int idGia) {
        this.idGia = idGia;
    }

    public int getIdPhuong() {
        return idPhuong;
    }

    public void setIdPhuong(int idPhuong) {
        this.idPhuong = idPhuong;
    }

    public DichVu getDichVu() {
        return dichVu;
    }

    public void setDichVu(DichVu dichVu) {
        this.dichVu = dichVu;
    }

    public Gia getGia() {
        return gia;
    }

    public void setGia(Gia gia) {
        this.gia = gia;
    }

    public Phuong getPhuong() {
        return phuong;
    }

    public void setPhuong(Phuong phuong) {
        this.phuong = phuong;
    }
}
