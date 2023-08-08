package presentation;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

public class viewKHViet extends JFrame {
    private JTextField MakhTextField;
    private JTextField nameTextField;
    private JTextField NgayrahoadonTextField;
    private JTextField SoluongTextField;
    private JTextField DongiaTextField;
        private JTextField DinhmucTextField;

    
    private JButton LuuButton;
    private JButton HuyButton;

    public viewKHViet(KhachhangManagementApp viewApp) {
        setTitle("Khachhang Management");
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        JPanel inputJPanel = new JPanel(new GridLayout(6, 2));
        MakhTextField = new JTextField();
        nameTextField = new JTextField();
        NgayrahoadonTextField = new JTextField();
        SoluongTextField = new JTextField();
        DongiaTextField = new JTextField();
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
        inputJPanel.add(new JLabel("Nhập định mức:"));

        inputJPanel.add(LuuButton);
        inputJPanel.add(HuyButton);
        
        LuuButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addKhachhangViet(viewApp);
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

    public void setKhachhangInfo1(int Makh, String name, Date Ngayrahoadon, double Soluong, double Dongia) {
        MakhTextField.setText(String.valueOf(Makh));
        nameTextField.setText(name);
        NgayrahoadonTextField.setText(String.valueOf(Ngayrahoadon));
        SoluongTextField.setText(String.valueOf(Soluong));
        DongiaTextField.setText(String.valueOf(Dongia));
    }

    private void addKhachhangViet(KhachhangManagementApp viewApp) {
        int Makh = Integer.parseInt(MakhTextField.getText());
        String name = nameTextField.getText();
        Date Ngayrahoadon = Date.valueOf(NgayrahoadonTextField.getText());
        double Soluong = Double.parseDouble(SoluongTextField.getText());
        double Dongia = Double.parseDouble(DongiaTextField.getText());

        // Gọi phương thức của viewApp để thêm khách hàng Việt Nam
        viewApp.addKhachhangViet(Makh, name, Ngayrahoadon, Soluong, Dongia);

        JOptionPane.showMessageDialog(null, "Thêm khách hàng thành công!");
    }
}
