package presentation.Controllertest;

import domain.KhachhangService;
import domain.model.KhachhangViet;

public class UpdateKHVCommand extends Command{
        private KhachhangViet KhachhangViet;

    public UpdateKHVCommand(KhachhangService KhachhangService, KhachhangViet KhachhangViet) {
        super(KhachhangService);
        this.KhachhangViet = KhachhangViet;
    }

    @Override
    public void excute() {
        KhachhangService.updateKhachhangViet(KhachhangViet);
    }
}
