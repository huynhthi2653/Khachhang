package presentation.Controllertest;

import domain.model.Khachhangnuocngoai;
import domain.KhachhangService;
public class AddKHNNCommand extends Command{
    private Khachhangnuocngoai Khachhangnuocngoai;
    public AddKHNNCommand(KhachhangService KhachhangService, Khachhangnuocngoai Khachhangnuocngoai) {
        super(KhachhangService);
        this.Khachhangnuocngoai = Khachhangnuocngoai;
    }
    @Override
    public void excute() {
        KhachhangService.addKhachhangnuocngoai(Khachhangnuocngoai);
    }
}
