package presentation.Controllertest;

import domain.KhachhangService;
import presentation.KhachhangManagementApp;

public class Findcommand extends Command {
private int Makh;

    public Findcommand(KhachhangService KhachhangService, int Makh) {
        super(KhachhangService);
        this.Makh = Makh;
    
    }
    @Override
    public void excute() {
        KhachhangService.TimkhachhangtuMakh(Makh);
    }
}

