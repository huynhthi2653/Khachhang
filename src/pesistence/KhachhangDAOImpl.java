/*
*  created date: Jul 24, 2023
*  author: cgm
*/
package pesistence;

import java.util.List;

import domain.model.Khachhang;
import domain.model.KhachhangViet;
import domain.model.Khachhangnuocngoai;

public class KhachhangDAOImpl implements KhachhangDAO {
    private KhachhangGateway KhachhangGateway;

    public KhachhangDAOImpl(KhachhangGateway KhachhangGateway) {
        this.KhachhangGateway = KhachhangGateway;
    }

    @Override
    public void addKhachhangViet(KhachhangViet KhachhangViet) {
        KhachhangGateway.addKhachhangViet(KhachhangViet);
    }

    @Override
    public void addKhachhangnuocngoai(Khachhangnuocngoai Khachhangnuocngoai) {
        KhachhangGateway.addKhachhangnuocngoai(Khachhangnuocngoai);
    }

    @Override
    public void updateKhachhangViet(KhachhangViet KhachhangViet) {
        KhachhangGateway.updateKhachhangViet(KhachhangViet);
    }

    @Override
    public void updateKhachhangnuocngoai(Khachhangnuocngoai Khachhangnuocngoai) {
        KhachhangGateway.updateKhachhangnuocngoai(Khachhangnuocngoai);
    }

    @Override
    public void deleteKhachhang(int MaKH) {
        KhachhangGateway.deleteKhachhang(MaKH);
    }

    @Override
    public Khachhang getKhachhangById(int MaKH) {
        return KhachhangGateway.getKhachhangById(MaKH);
    }

    @Override
    public List<Khachhang> getAllKhachhangs() {
        return KhachhangGateway.getAllKhachhangs();
    }

    @Override
    public double TongTTKNN(Khachhang Khachhang) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'TongTTKNN'");
    }

    @Override
    public List<Khachhang> getKhachhangThang() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getKhachhangThang'");
    }
}
