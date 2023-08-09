package presentation;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ViewKHNN extends JFrame {
    private JTextField MakhTextField;
    private JTextField nameTextField;
    private JTextField NgayrahoadonTextField;
    private JTextField SoluongTextField;
    private JTextField DongiaTextField;
    private JTextField QuoctichTextField;
    private JButton LuuButton;
    private JButton HuyButton;

    public ViewKHNN(KhachhangManagementApp viewApp, Controller Controller) {
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
                addKhachhangnuocngoai(viewApp);
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
  public String getQuocTich() {
        return QuoctichTextField.getText();
    }
    public void setKhachhangInfo2(int makh, String Quoctich, Date ngayrahoadon, int soluong, double dongia, String quocTich2) {
        QuoctichTextField.setText(Quoctich);
        
    }

    private void addKhachhangnuocngoai(KhachhangManagementApp viewApp) {
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
        String QuocTich = QuoctichTextField.getText();

        // Gọi phương thức của viewApp để thêm khách hàng nước ngoài
        
        JOptionPane.showMessageDialog(null, "Thêm khách hàng thành công!");
    }
    
  
}
