/*
*  created date: Jul 24, 2023
*  author: cgm
*/
package domain;

import java.util.List;

import domain.model.Khachhang;
import pesistence.*;

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
    public void deleteKhachhang(int KhachhangId) {
        KhachhangDAO.deleteKhachhang(KhachhangId);
    }

    @Override
    public Khachhang getKhachhangByMakh(int KhachhangId) {
        return KhachhangDAO.getKhachhangById(KhachhangId);
    }

    @Override
    public List<Khachhang> getAllKhachhangs() {
        return KhachhangDAO.getAllKhachhangs();
    }
}
