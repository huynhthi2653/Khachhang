/*
*  created date: Jul 24, 2023
*  author: cgm
*/
package domain;

import java.util.LinkedList;
import java.util.List;

import domain.model.Khachhang;
import domain.model.KhachhangViet;
import domain.model.Khachhangnuocngoai;
import presentation.Subscriber;

public interface KhachhangService {
    void addKhachhangViet(KhachhangViet KhachhangViet);

    void addKhachhangnuocngoai(Khachhangnuocngoai Khachhangnuocngoai);

    void updateKhachhangViet(KhachhangViet KhachhangViet);

    void updateKhachhangnuocngoai(Khachhangnuocngoai Khachhangnuocngoai);

    void deleteKhachhang(int KhachhangMakh);

    void TimkhachhangtuMakh(int KhachhangMakh);

    List<Khachhang> getAllKhachhangs();

    int TongSLKHV();

    int TongSLKHNN();

    double TBTTkhachNN(Khachhangnuocngoai Khachhangnuocngoai);

    void XuaHDTT(Khachhang khachhang);

    List<Subscriber> Subs = new LinkedList<Subscriber>();

    void subscribe(Subscriber Sub);

    void unsubscribe(Subscriber Sub);

    void notifySubscribers();
}