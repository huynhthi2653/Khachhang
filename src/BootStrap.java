/*
*  created date: Jul 24, 2023
*  author: cgm
*/

import javax.swing.SwingUtilities;
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======

import presentation.Controller;
>>>>>>> 86b9ad0301f730bc73ecc265e391585cc29e8dcf
>>>>>>> 4366b2b2845e9834daf14c9334dcfda4d3e2c52a
import presentation.KhachhangManagementApp;

public class BootStrap {

    public static class Main {
        public static void main(String[] args) {
            SwingUtilities.invokeLater(() -> {
                KhachhangManagementApp app = new KhachhangManagementApp();
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
                Controller controller = new Controller(app);
>>>>>>> 86b9ad0301f730bc73ecc265e391585cc29e8dcf
>>>>>>> 4366b2b2845e9834daf14c9334dcfda4d3e2c52a
                app.setVisible(true);
            });
        }
    }
}
