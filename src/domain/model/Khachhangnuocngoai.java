package domain.model;

import java.util.Date;

public class Khachhangnuocngoai extends Khachhang {

    public Khachhangnuocngoai(int Makh, String name, Date ngayrahoadon, int Soluong, double Dongia, String QuocTich,
            double ThanhTien) {
        super(Makh, name, ngayrahoadon, Soluong, Dongia, ThanhTien);
        this.Quoctich = QuocTich;
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
