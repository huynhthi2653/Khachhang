package presentation.Controllertest;

import presentation.KhachhangManagementApp;

public class AddCommand extends Command {
    private KhachhangManagementApp app;

    public AddCommand(KhachhangManagementApp app) {
        this.app = app;
    }

    @Override
    void excute() {
          app.addbButton();
    }

}
