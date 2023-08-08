package presentation.Controllertest;

import presentation.KhachhangManagementApp;

public class Findcommand extends Command {
    private KhachhangManagementApp app;

    public Findcommand(KhachhangManagementApp app) {
        this.app = app;
    }

  

    @Override
    void excute() {
         app.findKhachhang();
    }




}

