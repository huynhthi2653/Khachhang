/*
*  created date: Jul 24, 2023
*  author: cgm
*/
package pesistence;

import java.util.List;

import domain.model.Khachhang;
import domain.model.KhachhangViet;
import domain.model.Khachhangnuocngoai;

public interface KhachhangDAO {
    void addKhachhangViet(KhachhangViet KhachhangViet);

    void addKhachhangnuocngoai(Khachhangnuocngoai Khachhangnuocngoai);

    void updateKhachhangViet(KhachhangViet KhachhangViet);

    void updateKhachhangnuocngoai(Khachhangnuocngoai Khachhangnuocngoai);

    void deleteKhachhang(int MaKH);

    Khachhang getKhachhangById(int MaKH);

    List<Khachhang> getAllKhachhangs();

    int TongSLKHNN();
    
    int TongSLKHV();
    int tongHangDienMay();

    double TongTTKNN(Khachhang Khachhang);

    List<Khachhang> getKhachhangThang();
}
