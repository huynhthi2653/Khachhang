/*
*  created date: Jul 24, 2023
*  author: cgm
*/
package domain.model;

import java.util.Date;

public abstract class Khachhang {
    private int Makh;
    private String name;
    private Date Ngayrahoadon;
    protected int Soluong;
    protected double Dongia;
    protected double ThanhTien;

    public double getThanhTien() {
        return ThanhTien;
    }

    public void setThanhTien(double thanhTien) {
        ThanhTien = thanhTien;
    }

    public abstract double ThanhTien();

    public Khachhang(int Makh, String name, Date ngayrahoadon, int Soluong, double Dongia, double ThanhTien) {
        this.Makh = Makh;
        this.name = name;
        this.Ngayrahoadon = ngayrahoadon;
        this.Soluong = Soluong;
        this.Dongia = Dongia;
    }

    // Getters and setters for the fields (omitted for brevity)
    /**
     * @return the Makh
     */
    public int getMakh() {
        return Makh;
    }

    /**
     * @param id the id to set
     */
    public void setMakh(int Makh) {
        this.Makh = Makh;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the major
     */
    public Date getNgayrahoadon() {
        return Ngayrahoadon;
    }

    /**
     * @param Ngayrahoadon the Ngayrahoadon to set
     */
    public void setNgayrahoadon(Date Ngayrahoadon) {
        this.Ngayrahoadon = Ngayrahoadon;
    }

    /**
     * @return the Soluong
     */
    public int getSoluong() {
        return Soluong;
    }

    /**
     * @param Soluong the Soluong to set
     */
    public void setSoluong(int Soluong) {
        this.Soluong = Soluong;
    }

    /**
     * @return the Dongia
     */
    public double getDongia() {
        return Dongia;
    }

    /**
     * @param Dongia the Dongia to set
     */
    public void setDongia(double Dongia) {
        this.Dongia = Dongia;
    }
}
