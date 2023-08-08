package presentation;

import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

public class ViewKHNN extends JFrame {
    private JTextField MakhTextField;
    private JTextField nameTextField;
    private JTextField NgayrahoadonTextField;
    private JTextField SoluongTextField;
    private JTextField DongiaTextField;
    private JTextField QuoctichTextField;
    private JButton LuuButton;
    private JButton HuyButton;

    public ViewKHNN(KhachhangManagementApp viewApp) {
        JPanel inputJPanel = new JPanel(new GridLayout(7, 2));
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
                addKhachhangnuocngoai(viewApp);
                dispose();
            }
        });

        HuyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        
        int result = JOptionPane.showOptionDialog(null, inputJPanel, "Nhập thông tin", JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE, null, null, null);

        if (result == JOptionPane.CANCEL_OPTION || result == JOptionPane.CLOSED_OPTION) {
            // Xử lý khi người dùng hủy hoặc đóng cửa sổ dialog
        }
        
    }
  public String getQuocTich() {
        return QuoctichTextField.getText();
    }
    public void setKhachhangInfo2(int Makh, String name, Date Ngayrahoadon, double Soluong, double Dongia, String Quoctich) {
        MakhTextField.setText(String.valueOf(Makh));
        nameTextField.setText(name);
        NgayrahoadonTextField.setText(String.valueOf(Ngayrahoadon));
        SoluongTextField.setText(String.valueOf(Soluong));
        DongiaTextField.setText(String.valueOf(Dongia));
        QuoctichTextField.setText(Quoctich);
        
    }

    private void addKhachhangnuocngoai(KhachhangManagementApp viewApp) {
        int Makh = Integer.parseInt(MakhTextField.getText());
        String name = nameTextField.getText();
        Date Ngayrahoadon = Date.valueOf(NgayrahoadonTextField.getText());
        double Soluong = Double.parseDouble(SoluongTextField.getText());
        double Dongia = Double.parseDouble(DongiaTextField.getText());
        String Quoctich = QuoctichTextField.getText();

        // Gọi phương thức của viewApp để thêm khách hàng nước ngoài
        viewApp.addKhachhangnuocngoai(Makh, name, Ngayrahoadon, Soluong, Dongia, Quoctich);

        JOptionPane.showMessageDialog(null, "Thêm khách hàng thành công!");
    }
  
}
