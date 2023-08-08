package presentation.Controllertest;

import presentation.KhachhangManagementApp;

public class DeleteCommand extends Command {
    private KhachhangManagementApp app;

    public DeleteCommand(KhachhangManagementApp app) {
        this.app = app;
    }

    @Override
    void excute() {
           app.deleteKhachhang();
    }

 
}
