package domain.model;

import java.util.Date;

public class Khachhangnuocngoai extends Khachhang {
    private String Quoctich;

    public String getQuoctich() {
        return Quoctich;
    }

    public void setQuoctich(String quoctich) {
        Quoctich = quoctich;
    }

    public Khachhangnuocngoai(int Makh, String name, Date Ngayrahoadon, double Soluong, double Dongia, double Giatien,
            String Quoctich) {
        super(Makh, name, Ngayrahoadon, Soluong, Dongia, Giatien);
        this.Quoctich = Quoctich;
    }

    @Override
    public double ThanhTien() {
        return getSoluong() * getDongia();
    }

}
