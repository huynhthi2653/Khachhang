package presentation;

import javax.swing.*;

import domain.KhachhangService;
import domain.model.Khachhangnuocngoai;
import presentation.Controllertest.AddKHNNCommand;
import presentation.Controllertest.Command;
import presentation.Controllertest.UpdateKHNNConmand;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class ViewKHNN extends JFrame {
    private JTextField MakhTextField;
    private JTextField nameTextField;
    private JTextField NgayrahoadonTextField;
    private JTextField SoluongTextField;
    private JTextField DongiaTextField;
    private JTextField QuoctichTextField;
    private JButton LuuButton;
    private JButton HuyButton;

    public ViewKHNN(KhachhangManagementApp viewApp, Controller Controller, KhachhangService khachhangService,
            int chon) {
        setTitle("Khachhang Management");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        JPanel inputJPanel = new JPanel(new GridLayout(8, 2));
        MakhTextField = new JTextField();
        nameTextField = new JTextField();
        NgayrahoadonTextField = new JTextField();
        SoluongTextField = new JTextField();
        DongiaTextField = new JTextField();
        QuoctichTextField = new JTextField();
        LuuButton = new JButton("Lưu");
        HuyButton = new JButton("Hủy");
        inputJPanel.add(new JLabel("Nhập mã khách hàng:"));
        inputJPanel.add(MakhTextField);
        inputJPanel.add(new JLabel("Nhập tên khách hàng:"));
        inputJPanel.add(nameTextField);
        inputJPanel.add(new JLabel("Nhập ngày ra hoá đơn:"));
        inputJPanel.add(NgayrahoadonTextField);
        inputJPanel.add(new JLabel("Nhập số lượng:"));
        inputJPanel.add(SoluongTextField);
        inputJPanel.add(new JLabel("Nhập đơn giá:"));
        inputJPanel.add(DongiaTextField);
        inputJPanel.add(new JLabel("Nhập quốc tịch:"));
        inputJPanel.add(QuoctichTextField);
        inputJPanel.add(LuuButton);
        inputJPanel.add(HuyButton);

        LuuButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (chon != 0) {
                    UpdateKhachhangnuocngoai(khachhangService, Controller);
                    dispose();
                } else {
                    addKhachhangnuocngoai(khachhangService, Controller);
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

    public String getQuocTich() {
        return QuoctichTextField.getText();
    }

    public void setKhachhangInfo2(int makh, String Quoctich, Date ngayrahoadon, int soluong, double dongia,
            String quocTich2) {
        QuoctichTextField.setText(Quoctich);

    }

    private void addKhachhangnuocngoai(KhachhangService KhachhangService, Controller Controller) {
        Command addKHNN = new AddKHNNCommand(KhachhangService, GetKhachhang());
        Controller.excute(addKHNN);
    }

    private void UpdateKhachhangnuocngoai(KhachhangService KhachhangService, Controller Controller) {
        Command UpdateKHNN = new UpdateKHNNConmand(KhachhangService, GetKhachhang());
        Controller.excute(UpdateKHNN);
    }

    private Khachhangnuocngoai GetKhachhang() {
        int Makh = Integer.parseInt(MakhTextField.getText());
        String name = nameTextField.getText();
        Date Ngayrahoadon = java.sql.Date.valueOf(NgayrahoadonTextField.getText());
        int Soluong = Integer.parseInt(SoluongTextField.getText());
        double Dongia = Double.parseDouble(DongiaTextField.getText());
        double ThanhTien = Soluong * Dongia;
        String QuocTich = QuoctichTextField.getText();
        return new Khachhangnuocngoai(Makh, name, Ngayrahoadon, Soluong, Dongia, QuocTich, ThanhTien);
    }
}
