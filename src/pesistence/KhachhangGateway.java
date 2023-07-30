/*
*  created date: Jul 24, 2023
*  author: cgm
*/
package pesistence;

import java.util.List;

import domain.model.Khachhang;

public interface KhachhangGateway {
    void addKhachhang(Khachhang Khachhang);

    void updateKhachhang(Khachhang Khachhang);

    void deleteKhachhang(int KhachhangId);

    Khachhang getKhachhangById(int KhachhangId);

    List<Khachhang> getAllKhachhangs();
}
