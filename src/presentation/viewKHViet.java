package presentation;

import javax.swing.*;

import domain.KhachhangService;
import domain.model.Khachhang;
import domain.model.KhachhangViet;
import presentation.Controllertest.AddKHNNCommand;
import presentation.Controllertest.AddKHVCommand;
import presentation.Controllertest.Command;
import presentation.Controllertest.UpdateKHNNConmand;
import presentation.Controllertest.UpdateKHVCommand;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class viewKHViet extends JFrame {
    private JTextField MakhTextField;
    private JTextField nameTextField;
    private JTextField NgayrahoadonTextField;
    private JTextField SoluongTextField;
    private JTextField DongiaTextField;
    private JTextField DinhmucTextField;
    private JComboBox<String> customerTypeCombo;
    private JButton LuuButton;
    private JButton HuyButton;
    private KhachhangViet khachhangViet;

    public viewKHViet(KhachhangManagementApp viewApp, Controller Controller, KhachhangService khachhangService) {
        setTitle("Khachhang Management");
        setSize(400, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        JPanel inputJPanel = new JPanel(new GridLayout(10, 2));
        MakhTextField = new JTextField();
        nameTextField = new JTextField();
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
        inputJPanel.add(nameTextField);
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
                addKhachhangViet(viewApp, Controller, khachhangService);
                dispose();
            }
        });

        HuyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        add(inputJPanel, BorderLayout.SOUTH);
    }

    private void addKhachhangViet(KhachhangManagementApp viewApp, Controller Controller,
            KhachhangService khachhangService) {
        int Makh = Integer.parseInt(MakhTextField.getText());
        String name = nameTextField.getText();
        Date Ngayrahoadon;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", new Locale("vi", "VN"));
            Ngayrahoadon = dateFormat.parse(NgayrahoadonTextField.getText());
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Invalid date format. Please use 'dd/MM/yyyy' format for the date.");
            return;
        }
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
        Khachhang KhachhangViet = new KhachhangViet(Makh, name, Ngayrahoadon, Soluong, Dongia, ThanhTien, doituongKH,
                Dinhmuc);
        Command ThemHD = new AddKHVCommand(khachhangService, khachhangViet);
        Controller.excute(ThemHD);
        Command CapnhatHD = new UpdateKHVCommand(khachhangService, khachhangViet);
        Controller.excute(CapnhatHD);
        JOptionPane.showMessageDialog(null, "Thêm khách hàng thành công!");
    }
}