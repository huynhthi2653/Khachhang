package domain.model;

import java.util.Date;

public class KhachhangViet extends Khachhang {
    private String doituongKH;
    private int dinhmuc;

    @Override
    public String getDoituongKH() {
        return doituongKH;
    }

    @Override
    public int getDinhmuc() {
        return dinhmuc;
    }

    public KhachhangViet(int MaKH, String hotenKH, Date Ngayrahoadon, int Soluong, double Dongia, double ThanhTien,
            String doituongKH,
            int dinhmuc) {
        super(MaKH, doituongKH, Ngayrahoadon, Soluong, Dongia, ThanhTien);
        this.doituongKH = doituongKH;
        this.dinhmuc = dinhmuc;
        this.ThanhTien = ThanhTien();
    }

    @Override
    public double ThanhTien() {
        if (Soluong <= dinhmuc) {
            ThanhTien = Dongia * Soluong;
        } else {
            ThanhTien = Dongia * dinhmuc + (Soluong - dinhmuc) * Dongia * 2.5;
        }
        return ThanhTien;
    }
}