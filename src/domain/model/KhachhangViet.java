package domain.model;

import java.util.Date;

public class KhachhangViet extends Khachhang {
    private String doituongKH;
    private int dinhmuc;

    public String getDoituongKH() {
        return doituongKH;
    }

    public void setDoituongKH(String doituongKH) {
        this.doituongKH = doituongKH;
    }

    public int getDinhmuc() {
        return dinhmuc;
    }

    public void setDinhmuc(int dinhmuc) {
        this.dinhmuc = dinhmuc;
    }

    public KhachhangViet(int MaKH, String hotenKH, Date Ngayrahoadon, int Soluong, double Dongia, double ThanhTien,
            String doituongKH,
            int dinhmuc) {
        super(MaKH, doituongKH, Ngayrahoadon, Soluong, Dongia, ThanhTien);
        this.doituongKH = doituongKH;
        this.dinhmuc = dinhmuc;
    }

    @Override
    public double ThanhTien() {
        if (Soluong <= dinhmuc) {
            return Dongia * Soluong;
        } else {
            return Dongia * dinhmuc + (Soluong - dinhmuc) * Dongia * 2.5;
        }
    }
}