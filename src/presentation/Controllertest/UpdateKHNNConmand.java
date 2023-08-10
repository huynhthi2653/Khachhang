package presentation.Controllertest;

import domain.KhachhangService;
import domain.model.Khachhangnuocngoai;

public class UpdateKHNNConmand extends Command{
        private Khachhangnuocngoai Khachhangnuocngoai;
    public UpdateKHNNConmand(KhachhangService KhachhangService, Khachhangnuocngoai Khachhangnuocngoai) {
        super(KhachhangService);
        this.Khachhangnuocngoai = Khachhangnuocngoai;
    }
    @Override
    public void excute() {
        KhachhangService.updateKhachhangnuocngoai(Khachhangnuocngoai);
    }
}
