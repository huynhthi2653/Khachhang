package domain.model;

import java.util.Date;
// import java.util.jar.Attributes.Name;

public class Khachhangnuocngoai extends Khachhang {

    public Khachhangnuocngoai(int Makh, String Name, Date ngayrahoadon, int Soluong, double Dongia, String QuocTich,
            double ThanhTien) {
        super(Makh, Name, ngayrahoadon, Soluong, Dongia, ThanhTien);
        this.Quoctich = QuocTich;
        this.ThanhTien = ThanhTien();
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
        return ThanhTien = Dongia * Soluong;
    }
}
