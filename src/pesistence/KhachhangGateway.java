/*
*  created date: Jul 24, 2023
*  author: cgm
*/
package pesistence;

import java.util.List;

import domain.model.Khachhang;
import domain.model.KhachhangViet;
import domain.model.Khachhangnuocngoai;

public interface KhachhangGateway {
    void addKhachhangViet(KhachhangViet KhachhangViet);

    void addKhachhangnuocngoai(Khachhangnuocngoai Khachhangnuocngoai);

    void updateKhachhangViet(KhachhangViet KhachhangViet);

    void updateKhachhangnuocngoai(Khachhangnuocngoai Khachhangnuocngoai);

    void deleteKhachhang(int MaKH);

    Khachhang TimkhachhangtuMakh(int MaKH);

    int TongSLKHNN();

    int TongSLKHV();

    List<Khachhang> getAllKhachhangs();

    double TongTTKNN(Khachhang Khachhang);

    List<Khachhang> getKhachhangThang(String thang);
}
