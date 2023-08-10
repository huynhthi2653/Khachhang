/*
*  created date: Jul 24, 2023
*  author: cgm
*/

import javax.swing.SwingUtilities;
import presentation.KhachhangManagementApp;

public class BootStrap {

    public static class Main {
        public static void main(String[] args) {
            SwingUtilities.invokeLater(() -> {
                KhachhangManagementApp app = new KhachhangManagementApp();
                app.setVisible(true);
            });
        }
    }
}
