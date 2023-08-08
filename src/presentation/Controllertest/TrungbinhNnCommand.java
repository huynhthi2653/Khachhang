package presentation.Controllertest;

import presentation.KhachhangManagementApp;

public class TrungbinhNnCommand extends Command {
    private KhachhangManagementApp app;

    public TrungbinhNnCommand(KhachhangManagementApp app) {
        this.app = app;
    }

    @Override
    void excute() {
           app.TrungbinhNn();
    }

 
}
