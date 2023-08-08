package presentation;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import domain.*;
import domain.model.Khachhang;
import domain.model.KhachhangViet;
import domain.model.Khachhangnuocngoai;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.util.Date;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.List;
//import java.util.Locale;
import java.util.Date;

public class KhachhangManagementApp extends JFrame {
    private KhachhangService KhachhangService;
    private DefaultTableModel tableModel;
    private JTable table;
    private JButton addbButton;
    private JButton editButton;
    private JButton deleteButton;
    private JButton findButton;
    private JButton TrungbinhNn;
    private JButton Tongsl;
    private JButton hoadonT;
    private JButton saveButton;

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
        tableModel.addColumn("Định mức");
        tableModel.addColumn("Đối tượng");
        tableModel.addColumn("quốc tịch");
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        // Create JPanel for Khachhang details input and buttons
        JPanel inputPanel = new JPanel(new GridLayout(10, 2));
        addbButton = new JButton("Thêm khách hàng");
        editButton = new JButton("Edit");
        deleteButton = new JButton("Delete");
        findButton = new JButton("Find");
        saveButton = new JButton("Save");
        TrungbinhNn = new JButton("Trung Binh Thanh tien khach hang nuoc ngoai");
        Tongsl = new JButton("tong so luong ");
        hoadonT = new JButton("cac hoa don can tong hop trong thang");

        new GridLayout(7, 2);
        inputPanel.add(addbButton);
        inputPanel.add(editButton);
        inputPanel.add(deleteButton);
        inputPanel.add(findButton);
        inputPanel.add(saveButton);
        inputPanel.add(hoadonT);
        inputPanel.add(Tongsl);
        inputPanel.add(TrungbinhNn);

        add(inputPanel, BorderLayout.SOUTH);

        // Add action listeners for buttons
       addbButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        String[] options = { "Khách hàng Việt Nam", "Khách hàng nước ngoài" };

        int choice = JOptionPane.showOptionDialog(null, "Chọn loại khách hàng", "Tùy chọn",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        if (choice == JOptionPane.YES_OPTION) {
            // Chọn Khách hàng Việt Nam
            viewKHViet viewKHViet = new viewKHViet(KhachhangManagementApp.this);
            viewKHViet.setVisible(true);
        } else if (choice == JOptionPane.NO_OPTION) {
            // Chọn Khách hàng nước ngoài
            ViewKHNN viewKHNN = new ViewKHNN(KhachhangManagementApp.this);
            viewKHNN.setVisible(true);
        } else {
            // Không chọn gì cả hoặc đóng cửa sổ
        }
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
                String[] options = { "Khách hàng Việt Nam", "Khách hàng nước ngoài" };

                // Hiển thị JOptionPane với JRadioButton để chọn loại khách hàng
                int choice = JOptionPane.showOptionDialog(null, "Chọn loại khách hàng", "Tùy chọn",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

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
                    TrungbinhNn();
            }
        });
        hoadonT.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                hoadonT();
            }
        });
        // loadKhachhang();
    }
    private void TrungbinhNn(){
         JOptionPane.showMessageDialog(null, new JScrollPane(), "Thành tiền nước ngoài",
         JOptionPane.PLAIN_MESSAGE);
    }
  
    private void editKhachhang() {
        int row = table.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Please select a Khachhang to edit.");
            return;
        }
    
        // Lấy thông tin khách hàng từ dòng đã chọn trong bảng
        int Makh = (int) tableModel.getValueAt(row, 0);
        String name = (String) tableModel.getValueAt(row, 1);
        Date Ngayrahoadon = (Date) tableModel.getValueAt(row, 3);
        int Soluong = (int) tableModel.getValueAt(row, 3);
        double Dongia = (double) tableModel.getValueAt(row, 4);
        String QuocTich  = (String) tableModel.getValueAt(row, 9);

        // Khởi tạo biến viewKHNN ở đây
        ViewKHNN viewKHNN = new ViewKHNN(this);
    
        if (shouldShowViewKHNN(viewKHNN)) {
            // Set thông tin của Khachhang vào các trường của ViewKHNN
            viewKHNN.setKhachhangInfo2(Makh, name, Ngayrahoadon, Soluong, Dongia, QuocTich);
            viewKHNN.setVisible(true);
        } else {
            viewKHViet viewKHViet = new viewKHViet(this);
            // Set thông tin của Khachhang vào các trường của ViewKHViet
            viewKHViet.setVisible(true);
        }
    }
    
    
    
    

    private boolean shouldShowViewKHNN(ViewKHNN viewKHNN) {
        return false;
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


    }

     // Method to find a Khachhang
     private void findKhachhang() {
        // Tạo JPanel chứa các thành phần nhập liệu
        JPanel inputPanel = new JPanel(new GridLayout(2, 2));
        JTextField MakhTextField = new JTextField();
        inputPanel.add(new JLabel("Mã khách hàng:"));
        inputPanel.add(MakhTextField);
    
        // Hiển thị JOptionPane với các thành phần nhập liệu
        int result = JOptionPane.showOptionDialog(null, inputPanel, "Tìm khách hàng",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);
    
        // Xử lý khi người dùng chọn OK
        if (result == JOptionPane.OK_OPTION) {
            int KhachhangId = Integer.parseInt(MakhTextField.getText());
            Khachhang Khachhang = KhachhangService.getKhachhangByID(KhachhangId);
    
            if (Khachhang != null) {
                JOptionPane.showMessageDialog(this, "đã tìm thấy khách hàng!");
                // Hiển thị thông tin khách hàng tìm thấy
                // ...
            } else {
                JOptionPane.showMessageDialog(this, "không tìm thấy khách hàng.");
            }
        }
    }

    private void hoadonT() {
        // Tạo JPanel chứa các thành phần nhập liệu
        JPanel inputPanel = new JPanel(new GridLayout(4, 2));
        JTextField ngayField = new JTextField();
        JTextField thangField = new JTextField();
        JTextField namField = new JTextField();
        String[] options = { "Khách hàng Việt Nam", "Khách hàng nước ngoài" };
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
        int result = JOptionPane.showOptionDialog(null, inputPanel, "Chọn thông tin",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);

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

    // Method to load the Khachhang list into the JTable
    private void loadKhachhang() {
        List<Khachhang> Khachhangs = KhachhangService.getAllKhachhangs();
        tableModel.setRowCount(0); // Clear previous data
        for (Khachhang Khachhang : Khachhangs) {
            Object[] rowData = { Khachhang.getMakh(), Khachhang.getName(), Khachhang.getNgayrahoadon(),
                    Khachhang.getSoluong(), Khachhang.getSoluong(), Khachhang.ThanhTien() };
            tableModel.addRow(rowData);
        }
        
    }

   
   



}
