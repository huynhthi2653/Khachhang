package presentation.Controllertest;

import presentation.KhachhangManagementApp;

public class TongslCommand extends Command {
    private KhachhangManagementApp app;

    public TongslCommand(KhachhangManagementApp app) {
        this.app = app;
    }

    @Override
    void excute() {
           app.Tongsl();
    }

 
}
