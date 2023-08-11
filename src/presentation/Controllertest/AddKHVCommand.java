package presentation.Controllertest;

import domain.KhachhangService;
import domain.model.KhachhangViet;

public class AddKHVCommand extends Command {
    
    private KhachhangViet KhachhangViet;

    public AddKHVCommand(KhachhangService KhachhangService, KhachhangViet KhachhangViet) {
        super(KhachhangService);
        this.KhachhangViet = KhachhangViet;
    }

    @Override
    public void excute() {
        KhachhangService.addKhachhangViet(KhachhangViet);
    }

}
