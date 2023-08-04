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
    private double Soluong;
    private double Dongia;

    public Khachhang(int Makh, String name, Date Ngayrahoadon, double Soluong, double Dongia, double Giatien) {
        this.Makh = Makh;
        this.name = name;
        this.Ngayrahoadon = Ngayrahoadon;
        this.Soluong = Soluong;
        this.Dongia = Dongia;
    }

    // Getters and setters for the fields (omitted for brevity)

    @Override
    public String toString() {
        return "ID: " + Makh + ", Name: " + name + ", Ngayrahoadon: " + Ngayrahoadon + ", So luong: " + Soluong
                + ", Don gia: " + Dongia + ", Thanh tien: " + ThanhTien();
    }

    public abstract double ThanhTien();

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
    public double getSoluong() {
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
