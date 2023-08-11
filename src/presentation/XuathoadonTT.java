package presentation;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import domain.KhachhangService;
import domain.model.Khachhang;
import presentation.Controllertest.Command;
import presentation.Controllertest.HoadonTCommand;

import java.awt.*;

public class XuathoadonTT extends JFrame {
    private DefaultTableModel tableModel;
    private JTable table;
    private KhachhangManagementApp parentApp;
    private Khachhang Khachhang;

    public XuathoadonTT(KhachhangManagementApp khachhangManagementApp, Controller Controller,
            KhachhangService KhachhangService, String Thang) {
        setTitle("Xuất Hóa Đơn");
        setSize(770, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Close this window only, not the entire app
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(1, 2));
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
        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        Command Hoadons = new HoadonTCommand(KhachhangService, Thang);
        Controller.excute(Hoadons);
    }
}