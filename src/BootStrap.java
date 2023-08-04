/*
*  created date: Jul 24, 2023
*  author: cgm
*/

import javax.swing.SwingUtilities;

import presentation.KhachhangManagementApp;

public class BootStrap {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new KhachhangManagementApp().setVisible(true);
            }
        });
    }
}
