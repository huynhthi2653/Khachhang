package domain.model;

import java.util.Date;

public class KhachhangViet extends Khachhang {
    private int doituongKH;
    private int dinhmuc;

    public int getDoituongKH() {
        return doituongKH;
    }

    public void setDoituongKH(int doituongKH) {
        this.doituongKH = doituongKH;
    }

    public int getDinhmuc() {
        return dinhmuc;
    }

    public void setDinhmuc(int dinhmuc) {
        this.dinhmuc = dinhmuc;
    }

    public KhachhangViet(int doituongKH, int dinhmuc, int Makh, String name, Date Ngayrahoadon, double Dongia,
            double Soluong, double Giatien) {
        super(Makh, name, Ngayrahoadon, Soluong, Dongia, Giatien);
        this.doituongKH = doituongKH;
        this.dinhmuc = dinhmuc;
    }

    @Override
    public double ThanhTien() {
        if (getSoluong() <= dinhmuc) {
            return getSoluong() * getDongia();
        } else {
            return getDongia() * dinhmuc + (getSoluong() - dinhmuc) * getDongia() * 2.5;
        }
    }
}
