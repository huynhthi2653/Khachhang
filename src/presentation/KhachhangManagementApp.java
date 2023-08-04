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
    private JButton TrungbinhNn;
    private JButton Tongsl;
    private JButton hoadonT;
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
        // MakhTextField = new JTextField();
        // nameTextField = new JTextField();
        // NgayrahoadonTextField = new JTextField();
        // SoluongTextField = new JTextField();
        // DongiaTextField = new JTextField();
        addButton = new JButton("Add");
        editButton = new JButton("Edit");
        deleteButton = new JButton("Delete");
        findButton = new JButton("Find");
        saveButton = new JButton("Save");
        TrungbinhNn = new JButton("Trung Binh Thanh tien khach hang nuoc ngoai");
        Tongsl = new JButton("tong so luong ");
        hoadonT = new JButton("cac hoa don can tong hop trong thang");

        // new GridLayout(7, 2)

        // inputPanel.add(new JLabel("ID:"));
        // inputPanel.add(MakhTextField);

        // inputPanel.add(new JLabel("Name:"));
        // inputPanel.add(nameTextField);
        // inputPanel.add(new JLabel("Ngayrahoadon:"));
        // inputPanel.add(NgayrahoadonTextField);
        // inputPanel.add(new JLabel("Soluong:"));
        // inputPanel.add(SoluongTextField);
        // inputPanel.add(new JLabel("Dongia:"));
        // inputPanel.add(DongiaTextField);
        inputPanel.add(addButton);
        inputPanel.add(editButton);
        inputPanel.add(deleteButton);
        inputPanel.add(findButton);
        inputPanel.add(saveButton);
        inputPanel.add(hoadonT);
        inputPanel.add(Tongsl);
        inputPanel.add(TrungbinhNn);

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
        Tongsl.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String[] options = {"Khách hàng Việt Nam", "Khách hàng nước ngoài"};

                // Hiển thị JOptionPane với JRadioButton để chọn loại khách hàng
                int choice = JOptionPane.showOptionDialog(null, "Chọn loại khách hàng", "Tùy chọn", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

                // Xử lý lựa chọn
                if (choice == JOptionPane.YES_OPTION) {
                    // Chọn Khách hàng Việt Nam
                    // Xử lý logic tại đây
                    JOptionPane.showMessageDialog(null, "Bạn đã chọn Khách hàng Việt Nam");
                } else if (choice == JOptionPane.NO_OPTION) {
                    // Chọn Khách hàng nước ngoài
                    // Xử lý logic tại đây
                    JOptionPane.showMessageDialog(null, "Bạn đã chọn Khách hàng nước ngoài");
                } else {
                    // Không chọn gì cả hoặc đóng cửa sổ
                }
            }
        });

     
                            
        TrungbinhNn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        hoadonT.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
             hoadonT();
    }

    private void addKhachhang() {
        int Makh = Integer.parseInt(MakhTextField.getText());
        String name = nameTextField.getText();
        Date Ngayrahoadon = Date.valueOf(NgayrahoadonTextField.getText());
        double Soluong = Integer.parseInt(SoluongTextField.getText());
        double Dongia = Integer.parseInt(DongiaTextField.getText());
        if (rootPaneCheckingEnabled) {
            
        } else {
            
        }
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
    private void hoadonT(){
           // Tạo JPanel chứa các thành phần nhập liệu
                JPanel inputPanel = new JPanel(new GridLayout(4, 2));
                JTextField ngayField = new JTextField();
                JTextField thangField = new JTextField();
                JTextField namField = new JTextField();
                String[] options = {"Khách hàng Việt Nam", "Khách hàng nước ngoài"};
                JComboBox<String> customerTypeCombo = new JComboBox<>(options);
                inputPanel.add(new JLabel("Ngày:"));
                inputPanel.add(ngayField);
                inputPanel.add(new JLabel("Tháng:"));
                inputPanel.add(thangField);
                inputPanel.add(new JLabel("Năm:"));
                inputPanel.add(namField);
                inputPanel.add(new JLabel("Loại khách hàng:"));
                inputPanel.add(customerTypeCombo);

                // Hiển thị JOptionPane với các thành phần nhập liệu
                int result = JOptionPane.showOptionDialog(null, inputPanel, "Chọn thông tin", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);

                // Xử lý khi người dùng chọn OK
                if (result == JOptionPane.OK_OPTION) {
                    String ngay = ngayField.getText();
                    String thang = thangField.getText();
                    String nam = namField.getText();
                    String customerType = customerTypeCombo.getSelectedItem().toString();

                    // Xử lý thông tin tại đây
                    // Ví dụ:
                    String message = "Bạn đã chọn thông tin:\n";
                    message += "Ngày: " + ngay + "\n";
                    message += "Tháng: " + thang + "\n";
                    message += "Năm: " + nam + "\n";
                    message += "Loại khách hàng: " + customerType + "\n";
                    JOptionPane.showMessageDialog(null, message);
                }
            }
        });

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
