package presentation;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import domain.*;
import domain.model.Khachhang;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

public class KhachhangManagementApp extends JFrame {
    private KhachhangService KhachhangService;
    private DefaultTableModel tableModel;
    private JTable table;
    private JButton addButton;
    private JButton editButton;
    private JButton deleteButton;
    private JButton findButton;
    private JButton saveButton;
    private JTextField MakhTextField;
    private JTextField nameTextField;
    private JTextField NgayrahoadonTextField;
    private JTextField SoluongTextField;
    private JTextField DongiaTextField;

    public KhachhangManagementApp() {
        // Initialize the KhachhangService (Business Logic Layer)
        // KhachhangService = new KhachhangServiceImpl();

        // Set up JFrame
        setTitle("Khachhang Management");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create JTable to display Khachhang list
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Makh");
        tableModel.addColumn("Name");
        tableModel.addColumn("Ngayrahoadon");
        tableModel.addColumn("Soluong");
        tableModel.addColumn("Dongia");
        tableModel.addColumn("Thanhtien");
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        // Create JPanel for Khachhang details input and buttons
        JPanel inputPanel = new JPanel(new GridLayout(10, 2));
        MakhTextField = new JTextField();
        nameTextField = new JTextField();
        NgayrahoadonTextField = new JTextField();
        SoluongTextField = new JTextField();
        DongiaTextField = new JTextField();
        addButton = new JButton("Add");
        editButton = new JButton("Edit");
        deleteButton = new JButton("Delete");
        findButton = new JButton("Find");
        saveButton = new JButton("Save");

        // new GridLayout(7, 2)

        inputPanel.add(new JLabel("ID:"));
        inputPanel.add(MakhTextField);

        inputPanel.add(new JLabel("Name:"));
        inputPanel.add(nameTextField);
        inputPanel.add(new JLabel("Ngayrahoadon:"));
        inputPanel.add(NgayrahoadonTextField);
        inputPanel.add(new JLabel("Soluong:"));
        inputPanel.add(SoluongTextField);
        inputPanel.add(new JLabel("Dongia:"));
        inputPanel.add(DongiaTextField);
        inputPanel.add(addButton);
        inputPanel.add(editButton);
        inputPanel.add(deleteButton);
        inputPanel.add(findButton);
        inputPanel.add(saveButton);

        add(inputPanel, BorderLayout.SOUTH);

        // Add action listeners for buttons
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addKhachhang();
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

    }

    private void addKhachhang() {
        int Makh = Integer.parseInt(MakhTextField.getText());
        String name = nameTextField.getText();
        Date Ngayrahoadon = Date.valueOf(NgayrahoadonTextField.getText());
        double Soluong = Integer.parseInt(SoluongTextField.getText());
        double Dongia = Integer.parseInt(DongiaTextField.getText());

        // Calculate the average mark using the formula provided
        double ThanhTien = Soluong * Dongia;

        Khachhang Khachhang = new Khachhang(Makh, name, Ngayrahoadon, Soluong, Dongia, ThanhTien);
        KhachhangService.addKhachhang(Khachhang);

        clearFields();
    }

    // Method to edit a Khachhang
    private void editKhachhang() {
        int row = table.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Please select a Khachhang to edit.");
            return;
        }

        int Makh = Integer.parseInt(MakhTextField.getText());
        String name = nameTextField.getText();
        Date Ngayrahoadon = Date.valueOf(NgayrahoadonTextField.getText());
        double Soluong = Integer.parseInt(SoluongTextField.getText());
        double Dongia = Integer.parseInt(DongiaTextField.getText());

        // Calculate the average mark using the formula provided
        double ThanhTien = Soluong * Dongia;

        Khachhang Khachhang = new Khachhang(Makh, name, Ngayrahoadon, Soluong, Dongia, ThanhTien);
        KhachhangService.updateKhachhang(Khachhang);

        clearFields();

    }

    // Method to delete a Khachhang
    private void deleteKhachhang() {
        int row = table.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Please select a Khachhang to delete.");
            return;
        }

        int KhachhangId = (int) tableModel.getValueAt(row, 0);
        KhachhangService.deleteKhachhang(KhachhangId);

        clearFields();

    }

    // Method to find a Khachhang
    private void findKhachhang() {
        int KhachhangId = Integer.parseInt(MakhTextField.getText());
        Khachhang Khachhang = KhachhangService.getKhachhangByMakh(KhachhangId);

        if (Khachhang != null) {
            nameTextField.setText(Khachhang.getName());
            NgayrahoadonTextField.setText(String.valueOf(Khachhang.getNgayrahoadon()));
            SoluongTextField.setText(String.valueOf(Khachhang.getSoluong()));
            DongiaTextField.setText(String.valueOf(Khachhang.getDongia()));
        } else {
            JOptionPane.showMessageDialog(this, "Khachhang not found.");
            clearFields();
        }
    }

    // Method to load the Khachhang list into the JTable
    private void loadKhachhang() {

    }

    // Method to clear input fields
    private void clearFields() {
        MakhTextField.setText("");
        nameTextField.setText("");
        NgayrahoadonTextField.setText("");
        SoluongTextField.setText("");
        DongiaTextField.setText("");
    }

}
