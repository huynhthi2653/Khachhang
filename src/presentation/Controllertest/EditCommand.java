package presentation.Controllertest;

import presentation.KhachhangManagementApp;

public class EditCommand extends Command {
    private KhachhangManagementApp app;

    public EditCommand(KhachhangManagementApp app) {
        this.app = app;
    }
    @Override
    void excute() {
         app.editKhachhang();
    }
}

