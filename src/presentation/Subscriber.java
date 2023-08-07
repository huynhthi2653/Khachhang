package presentation;

import java.util.List;

import domain.model.Khachhang;

public interface Subscriber {
    void updateKhachhang(List<Khachhang> Khachhangs);
}
