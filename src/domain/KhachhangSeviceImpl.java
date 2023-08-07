/*
*  created date: Jul 24, 2023
*  author: cgm
*/
package domain;

import java.util.List;

import domain.model.Khachhang;
import domain.model.Khachhangnuocngoai;
import pesistence.*;
import presentation.Subscriber;

public class KhachhangSeviceImpl implements KhachhangService {
    private KhachhangDAO KhachhangDAO;

    public KhachhangSeviceImpl() {
        // Initialize the KhachhangDAO (Data Access Layer)
        KhachhangDAO = new KhachhangDAOImpl(new KhachhangJdbcGateway());
    }

    @Override
    public void addKhachhang(Khachhang Khachhang) {
        KhachhangDAO.addKhachhang(Khachhang);
    }

    @Override
    public void updateKhachhang(Khachhang Khachhang) {
        KhachhangDAO.updateKhachhang(Khachhang);
    }

    @Override
    public void deleteKhachhang(int MaKH) {
        KhachhangDAO.deleteKhachhang(MaKH);
    }

    @Override
    public List<Khachhang> getAllKhachhangs() {
        return KhachhangDAO.getAllKhachhangs();
    }

    @Override
    public Khachhang TimkhachhangtuMakh(int KhachhangMakh) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'TimkhachhangtuMakh'");
    }

    @Override
    public void TongSLKHV() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'TongSLKHV'");
    }

    @Override
    public void TongSLKHNN() {
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'subscribe'");
    }

    @Override
    public void unsubscribe(Subscriber Sub) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'unsubscribe'");
    }

    @Override
    public void notifySubscribers() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'notifySubscribers'");
    }
}
