package presentation;

import javax.swing.*;

import domain.KhachhangService;
import domain.model.KhachhangViet;
import presentation.Controllertest.AddKHVCommand;
import presentation.Controllertest.Command;
import presentation.Controllertest.UpdateKHVCommand;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class viewKHViet extends JFrame {
    private JTextField MakhTextField;
    private JTextField NameTextField;
    private JTextField NgayrahoadonTextField;
    private JTextField SoluongTextField;
    private JTextField DongiaTextField;
    private JTextField DinhmucTextField;
    private JComboBox<String> customerTypeCombo;

    public JTextField getMakhTextField() {
        return MakhTextField;
    }

    public JTextField getNameTextField() {
        return NameTextField;
    }

    public JTextField getNgayrahoadonTextField() {
        return NgayrahoadonTextField;
    }

    public JTextField getSoluongTextField() {
        return SoluongTextField;
    }

    public JTextField getDongiaTextField() {
        return DongiaTextField;
    }

    public JTextField getDinhmucTextField() {
        return DinhmucTextField;
    }

    public JComboBox<String> getCustomerTypeCombo() {
        return customerTypeCombo;
    }

    private JButton LuuButton;
    private JButton HuyButton;

    public viewKHViet(KhachhangManagementApp viewApp, Controller Controller, KhachhangService khachhangService,
            int Chon) {
        setTitle("Khachhang Management");
        setSize(400, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        JPanel inputJPanel = new JPanel(new GridLayout(8, 2));
        MakhTextField = new JTextField();
        NameTextField = new JTextField();
        NgayrahoadonTextField = new JTextField();
        SoluongTextField = new JTextField();
        DongiaTextField = new JTextField();
        DinhmucTextField = new JTextField();
        String[] optionss = { "Sinh hoạt", "Kinh doanh", "Sản xuất" };
        customerTypeCombo = new JComboBox<>(optionss);
        LuuButton = new JButton("Lưu");
        HuyButton = new JButton("Hủy");
        inputJPanel.add(new JLabel("Nhập mã khách hàng:"));
        inputJPanel.add(MakhTextField);
        inputJPanel.add(new JLabel("Nhập tên khách hàng:"));
        inputJPanel.add(NameTextField);
        inputJPanel.add(new JLabel("Nhập ngày ra hoá đơn:"));
        inputJPanel.add(NgayrahoadonTextField);
        inputJPanel.add(new JLabel("Nhập số lượng:"));
        inputJPanel.add(SoluongTextField);
        inputJPanel.add(new JLabel("Nhập đơn giá:"));
        inputJPanel.add(DongiaTextField);
        inputJPanel.add(new JLabel("Nhập định mức:"));
        inputJPanel.add(DinhmucTextField);
        inputJPanel.add(new JLabel("Loại đối tượng:"));
        inputJPanel.add(customerTypeCombo);
        inputJPanel.add(LuuButton);
        inputJPanel.add(HuyButton);

        LuuButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (Chon != 0) {
                    UpdateKhachhangViet(khachhangService, Controller);
                    dispose();
                } else {
                    addKhachhangViet(khachhangService, Controller);
                    dispose();
                }
            }
        });

        HuyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        add(inputJPanel, BorderLayout.SOUTH);
    }

    private void addKhachhangViet(KhachhangService KhachhangService, Controller Controller) {
        Command addKHV = new AddKHVCommand(KhachhangService, GetKhachhang());
        Controller.excute(addKHV);
    }

    private void UpdateKhachhangViet(KhachhangService KhachhangService, Controller Controller) {
        Command UpdateKHV = new UpdateKHVCommand(KhachhangService, GetKhachhang());
        Controller.excute(UpdateKHV);
    }

    private KhachhangViet GetKhachhang() {
        int Makh = Integer.parseInt(MakhTextField.getText());
        String Name = NameTextField.getText();
        Date Ngayrahoadon = java.sql.Date.valueOf(NgayrahoadonTextField.getText());
        int Soluong = Integer.parseInt(SoluongTextField.getText());
        double Dongia = Double.parseDouble(DongiaTextField.getText());
        int Dinhmuc = Integer.parseInt(DinhmucTextField.getText());
        String doituongKH = customerTypeCombo.getSelectedItem().toString();
        double ThanhTien;
        if (Soluong <= Dinhmuc) {
            ThanhTien = Soluong * Dinhmuc;
        } else {
            ThanhTien = Dongia * Dinhmuc + (Soluong - Dinhmuc) * Dongia * 2.5;
        }
        return new KhachhangViet(Makh, Name, Ngayrahoadon, Soluong, Dongia, ThanhTien, doituongKH, Dinhmuc);
    }
}