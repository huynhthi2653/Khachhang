/*
*  created date: Jul 24, 2023
*  author: cgm
*/
package pesistence;

import java.util.List;

import domain.model.Khachhang;

public class KhachhangDAOImpl implements KhachhangDAO {
    private KhachhangGateway KhachhangGateway;

    public KhachhangDAOImpl(KhachhangGateway KhachhangGateway) {
        this.KhachhangGateway = KhachhangGateway;
    }

    @Override
    public void addKhachhang(Khachhang Khachhang) {
        KhachhangGateway.addKhachhang(Khachhang);
    }

    @Override
    public void updateKhachhang(Khachhang Khachhang) {
        KhachhangGateway.updateKhachhang(Khachhang);
    }

    @Override
    public void deleteKhachhang(int KhachhangId) {
        KhachhangGateway.deleteKhachhang(KhachhangId);
    }

    @Override
    public Khachhang getKhachhangById(int KhachhangId) {
        return KhachhangGateway.getKhachhangById(KhachhangId);
    }

    @Override
    public List<Khachhang> getAllKhachhangs() {
        return KhachhangGateway.getAllKhachhangs();
    }
}
