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

    public Khachhangnuocngoai(int i, String string, java.sql.Date valueOf, int j, int k, String string2) {
    }

    @Override
    public double ThanhTien() {
        return getSoluong() * getDongia();
    }

}
