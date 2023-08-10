package presentation.Controllertest;

import domain.KhachhangService;

public class DeleteCommand extends Command {
    private int Makh;

    public DeleteCommand(KhachhangService KhachhangService, int Makh) {
        super(KhachhangService);
        this.Makh = Makh;
    
    }
    @Override
    public void excute() {
        KhachhangService.deleteKhachhang(Makh);
    }
}
