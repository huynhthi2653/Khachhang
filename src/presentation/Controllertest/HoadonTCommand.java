package presentation.Controllertest;

import domain.KhachhangService;

public class HoadonTCommand extends Command {
    private String Thang;

    public HoadonTCommand(KhachhangService KhachhangService, String Thang) {
        super(KhachhangService);
        this.Thang = Thang;
    }

    @Override
    public void excute() {
        KhachhangService.XuaHDTT(Thang);
    }
}
