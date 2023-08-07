package domain.model;

import java.util.Date;

public class Khachhangnuocngoai extends Khachhang {
    public Khachhangnuocngoai(int Makh, String name, Date ngayrahoadon, double Soluong, double Dongia,
            String Quoctich) {
        super(Makh, name, ngayrahoadon, Soluong, Dongia);

    }

    private String Quoctich;

    public String getQuoctich() {
        return Quoctich;
    }

    public void setQuoctich(String quoctich) {
        Quoctich = quoctich;
    }

    @Override
    public double ThanhTien() {
        return Dongia * Soluong;
    }
}
