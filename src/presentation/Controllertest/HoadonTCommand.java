package presentation.Controllertest;

import presentation.KhachhangManagementApp;

public class HoadonTCommand extends Command {
    private KhachhangManagementApp app;

    public HoadonTCommand(KhachhangManagementApp app) {
        this.app = app;
    }

    @Override
    void excute() {
           app.hoadonT();
    }
}
