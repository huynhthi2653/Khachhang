package presentation;

import java.awt.AWTEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class controller implements java.awt.event.AWTEventListener {
    private KhachhangManagementApp app;

    // Constructor
    public controller(KhachhangManagementApp app) {
        this.app = app;
        configureListeners();
    }

    private void configureListeners() {
        JButton addbButton = app.getAddButton();
        JButton editButton = app.getEditButton();
        JButton deleteButton = app.getDeleteButton();
        JButton findButton = app.getFindButton();
        JButton Tongsl = app.getTongslButton();
        JButton TrungbinhNn = app.getTrungbinhNnButton();
        JButton hoadonT = app.getHoadonTButton();

        addbButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addbButton();
            }
        });

        editButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                editKhachhang();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteKhachhang();
            }
        });

        findButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                findKhachhang();
            }
        });

        Tongsl.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Tongsl();
            }
        });

        TrungbinhNn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TrungbinhNn();
            }
        });

        hoadonT.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                hoadonT();
            }
        });
    }

    @Override
    public void eventDispatched(AWTEvent event) {
        // Leave this method empty or implement if needed
    }

    private void addbButton() {
        // Your implementation for addbButton action
    }

    private void editKhachhang() {
        // Your implementation for editButton action
    }

    private void deleteKhachhang() {
        // Your implementation for deleteButton action
    }

    private void findKhachhang() {
        // Your implementation for findButton action
    }

    private void Tongsl() {
        // Your implementation for Tongsl action
    }

    private void TrungbinhNn() {
        // Your implementation for TrungbinhNn action
    }

    private void hoadonT() {
        // Your implementation for hoadonT action
    }
}
