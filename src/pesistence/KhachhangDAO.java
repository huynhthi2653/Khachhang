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
<<<<<<< HEAD

    int TongSLKHV();
=======
<<<<<<< HEAD

    int TongSLKHV();
=======
    
    int TongSLKHV();
    int tongHangDienMay();
>>>>>>> 86b9ad0301f730bc73ecc265e391585cc29e8dcf
>>>>>>> 4366b2b2845e9834daf14c9334dcfda4d3e2c52a

    double TongTTKNN(Khachhang Khachhang);

    List<Khachhang> getKhachhangThang();
}
