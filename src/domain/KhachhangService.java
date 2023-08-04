/*
*  created date: Jul 24, 2023
*  author: cgm
*/
package domain;

import java.util.List;

import domain.model.Khachhang;

public interface KhachhangService {
    void addKhachhang(Khachhang Khachhang);

    void updateKhachhang(Khachhang Khachhang);

    void deleteKhachhang(int MaKH);

    Khachhang getKhachhangByMakh(int MaKH);

    List<Khachhang> getAllKhachhangs();

}
