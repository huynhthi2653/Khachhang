package presentation;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class XuathoadonTT extends JFrame {
    private DefaultTableModel tableModel;
    private JTable table;

    public XuathoadonTT(KhachhangManagementApp khachhangManagementApp) {
    }

    public void XuatHoaDonTT() {
        
        setTitle("Bảng xuất hóa đơn");
        setSize(600, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // Khởi tạo tableModel và table cho bảng xuất hóa đơn
        JPanel inputPanel = new JPanel(new GridLayout(4, 2));
        JTextField thangField = new JTextField();
        inputPanel.add(new JLabel("Tháng:"));
        inputPanel.add(thangField);

        tableModel = new DefaultTableModel();
        tableModel.addColumn("Makh");
        tableModel.addColumn("Name");
        tableModel.addColumn("Ngayrahoadon");
        tableModel.addColumn("Đối tượng khách hàng");
        tableModel.addColumn("Soluong");
        tableModel.addColumn("Dongia");
        tableModel.addColumn("Định mức");
        tableModel.addColumn("Thanhtien");
        tableModel.addColumn("quốc tịch");
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);
    }
}