package domain.model;

import java.util.Date;

public class KhachhangViet extends Khachhang {
    private String doituongKH;
    private int Dinhmuc;

    @Override
    public String getDoituongKH() {
        return doituongKH;
    }

    @Override
    public int getDinhmuc() {
        return Dinhmuc;
    }

    public KhachhangViet(int MaKH, String Name, Date Ngayrahoadon, int Soluong, double Dongia, double ThanhTien,
            String doituongKH,
            int Dinhmuc) {
        super(MaKH, doituongKH, Ngayrahoadon, Soluong, Dongia, ThanhTien);
        this.doituongKH = doituongKH;
        this.Dinhmuc = Dinhmuc;
        this.ThanhTien = ThanhTien();
    }

    @Override
    public double ThanhTien() {
        if (Soluong <= Dinhmuc) {
            ThanhTien = Dongia * Soluong;
        } else {
            ThanhTien = Dongia * Dinhmuc + (Soluong - Dinhmuc) * Dongia * 2.5;
        }
        return ThanhTien;
    }
}