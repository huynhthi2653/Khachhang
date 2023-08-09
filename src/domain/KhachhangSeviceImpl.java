/*
*  created date: Jul 24, 2023
*  author: cgm
*/
package domain;

import java.util.List;

import domain.model.Khachhang;
import domain.model.KhachhangViet;
import domain.model.Khachhangnuocngoai;
import pesistence.*;
import presentation.Subscriber;

public class KhachhangSeviceImpl implements KhachhangService {
    private KhachhangDAO KhachhangDAO;
    private List<Khachhang> Khachhangs;
    public KhachhangSeviceImpl() {
        // Initialize the KhachhangDAO (Data Access Layer)
        KhachhangDAO = new KhachhangDAOImpl(new KhachhangJdbcGateway());
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
    public List<Khachhang> getAllKhachhangs() {
        return Khachhangs = KhachhangDAO.getAllKhachhangs();
    }

    @Override
    public Khachhang TimkhachhangtuMakh(int KhachhangMakh) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'TimkhachhangtuMakh'");
    }

    @Override
    public int TongSLKHV() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'TongSLKHV'");
    }

    @Override
    public int TongSLKHNN() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'TongSLKHNN'");
    }

    @Override
    public double TBTTkhachNN(Khachhangnuocngoai Khachhangnuocngoai) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'TBTTkhachNN'");
    }

    @Override
    public void XuaHDTT(Khachhang khachhang) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'XuaHDTT'");
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
        for (Subscriber Sub: Subs){
            Sub.updateKhachhang(Khachhangs);
        }
    }
}
