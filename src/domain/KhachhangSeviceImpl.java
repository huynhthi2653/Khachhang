/*
*  created date: Jul 24, 2023
*  author: cgm
*/
package domain;

import java.util.ArrayList;
import java.util.List;

import domain.model.Khachhang;
import domain.model.KhachhangViet;
import domain.model.Khachhangnuocngoai;
import pesistence.*;
import presentation.Subscriber;

public class KhachhangSeviceImpl implements KhachhangService {
    private KhachhangDAO KhachhangDAO;
    private List<Khachhang> Hoadons;

    public KhachhangSeviceImpl() {
        KhachhangDAO = new KhachhangDAOImpl(new KhachhangJdbcGateway());
        Hoadons = new ArrayList<>(); // Khởi tạo danh sách hoadons
    }

    @Override
    public void addKhachhangViet(KhachhangViet KhachhangViet) {
        KhachhangDAO.addKhachhangViet(KhachhangViet);
    }

    @Override
    public void addKhachhangnuocngoai(Khachhangnuocngoai Khachhangnuocngoai) {
        KhachhangDAO.addKhachhangnuocngoai(Khachhangnuocngoai);
    }

    @Override
    public void updateKhachhangViet(KhachhangViet KhachhangViet) {
        KhachhangDAO.updateKhachhangViet(KhachhangViet);
    }

    @Override
    public void updateKhachhangnuocngoai(Khachhangnuocngoai khachhangnuocngoai) {
        KhachhangDAO.updateKhachhangnuocngoai(khachhangnuocngoai);
    }

    @Override
    public void deleteKhachhang(int MaKH) {
        KhachhangDAO.deleteKhachhang(MaKH);
    }

    @Override
    public void getAllKhachhangs() {
        Hoadons = KhachhangDAO.getAllKhachhangs();
        notifySubscribers();
    }

    @Override
    public Khachhang TimkhachhangtuMakh(int Makh) {
        return KhachhangDAO.TimkhachhangtuMakh(Makh);
    }

    @Override
    public void subscribe(Subscriber Sub) {
        Subs.add(Sub);
    }

    @Override
    public void unsubscribe(Subscriber Sub) {
        Subs.remove(Sub);
    }

    @Override
    public void notifySubscribers() {
        for (Subscriber Sub : Subs) {
            Sub.updateKhachhang(Hoadons);
        }
    }

    @Override
    public int TongSLKHV() {
        int tongSLVN = 0;
        Hoadons = KhachhangDAO.getAllKhachhangs();
        for (Khachhang khachhang : Hoadons) {
            if (khachhang instanceof Khachhangnuocngoai) {
                tongSLVN++;
            }
        }
        return tongSLVN;
    }

    @Override
    public int TongSLKHNN() {
        int tongSLNN = 0;
        Hoadons = KhachhangDAO.getAllKhachhangs();
        for (Khachhang khachhang : Hoadons) {
            if (khachhang instanceof Khachhangnuocngoai) {
                tongSLNN++;
            }
        }
        return tongSLNN;
    }

    @Override
    public void XuaHDTT(String thang) {
        Hoadons = KhachhangDAO.getKhachhangThang(thang);
    }

    @Override
    public double TBTTkhachNN(Khachhangnuocngoai Khachhangnuocngoai) {
        double thanhtien = 0;
        int count = 0;
        Hoadons = KhachhangDAO.getAllKhachhangs();
        for (Khachhang khachhang : Hoadons) {
            if (khachhang instanceof Khachhangnuocngoai) {
                Khachhangnuocngoai khachhangnuocngoai = (Khachhangnuocngoai) khachhang;
                thanhtien += khachhangnuocngoai.ThanhTien();
                count++;
            }
        }
        if (count == 0) {
            return 0;
        }
        return thanhtien / count;
    }
}
