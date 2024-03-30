/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.entites;

/**
 *
 * @author ASUS
 */
public class Phuong {

    private int id;
    private String tenPhuong;

    public Phuong() {
    }

    public Phuong(int id, String tenPhuong) {
        this.id = id;
        this.tenPhuong = tenPhuong;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenPhuong() {
        return tenPhuong;
    }

    public void setTenPhuong(String tenPhuong) {
        this.tenPhuong = tenPhuong;
    }

}
