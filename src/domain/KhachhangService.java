/*
*  created date: Jul 24, 2023
*  author: cgm
*/
package domain;

import java.util.ArrayList;
import java.util.List;

import domain.model.Khachhang;
import domain.model.Khachhangnuocngoai;
import presentation.Subscriber;

public interface KhachhangService {
    void addKhachhang(Khachhang Khachhang);

    void updateKhachhang(Khachhang Khachhang);

    void deleteKhachhang(int KhachhangMakh);

    Khachhang TimkhachhangtuMakh(int KhachhangMakh);

    List<Khachhang> getAllKhachhangs();

    void TongSLKHV();

    void TongSLKHNN();

    double TBTTkhachNN(Khachhangnuocngoai Khachhangnuocngoai);

    void XuaHDTT(Khachhang khachhang);

    List<Subscriber> Subs = new ArrayList<Subscriber>();

    void subscribe(Subscriber Sub);

    void unsubscribe(Subscriber Sub);

    void notifySubscribers();
}