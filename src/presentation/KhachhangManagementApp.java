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
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

<<<<<<< HEAD
public class KhachhangManagementApp extends JFrame implements Subscriber {
=======
<<<<<<< HEAD
public class KhachhangManagementApp extends JFrame implements Subscriber {
=======
public class KhachhangManagementApp extends JFrame {
>>>>>>> 86b9ad0301f730bc73ecc265e391585cc29e8dcf
>>>>>>> 4366b2b2845e9834daf14c9334dcfda4d3e2c52a
    private KhachhangService KhachhangService;
    private Controller controller;
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
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 4366b2b2845e9834daf14c9334dcfda4d3e2c52a

    public KhachhangManagementApp() {
        KhachhangService = new KhachhangSeviceImpl();
        controller = new Controller();
        KhachhangService.subscribe(this);
<<<<<<< HEAD
=======
=======
    // private JTextField MakhTextField;
    // private JTextField nameTextField;
    // private JTextField NgayrahoadonTextField;
    // private JTextField SoluongTextField;
    // private JTextField DongiaTextField;
    // private JTextField QuoctichTextField;
    // private JTextField DinhmucTextField;
    private JComboBox<String> customerTypeCombo;

    public KhachhangManagementApp() {
        // Initialize the KhachhangService (Business Logic Layer)
        // KhachhangService = new KhachhangServiceImpl();

        // Set up JFrame
>>>>>>> 86b9ad0301f730bc73ecc265e391585cc29e8dcf
>>>>>>> 4366b2b2845e9834daf14c9334dcfda4d3e2c52a
        setTitle("Khachhang Management");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create JTable to display Khachhang list
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Mã KH");
        tableModel.addColumn("Name");
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 4366b2b2845e9834daf14c9334dcfda4d3e2c52a
        tableModel.addColumn("Ngày ra hoá đơn");
        tableModel.addColumn("Số lượng");
        tableModel.addColumn("Đơn giá");
        tableModel.addColumn("Định mức");
        tableModel.addColumn("Đối tượng");
        tableModel.addColumn("Quốc tịch");
        tableModel.addColumn("Thành tiền");
<<<<<<< HEAD
=======
=======
        tableModel.addColumn("Ngayrahoadon");
        tableModel.addColumn("Soluong");
        tableModel.addColumn("Dongia");
        tableModel.addColumn("Thanhtien");
>>>>>>> 86b9ad0301f730bc73ecc265e391585cc29e8dcf
>>>>>>> 4366b2b2845e9834daf14c9334dcfda4d3e2c52a
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);
        JPanel inputPanel = new JPanel(new GridLayout(10, 2));
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 4366b2b2845e9834daf14c9334dcfda4d3e2c52a

        addbButton = new JButton("Thêm hoá đơn");
        editButton = new JButton("Sửa hoá đơn");
        deleteButton = new JButton("Xoá hoá đơn");
        findButton = new JButton("Tìm hoá đơn");
        saveButton = new JButton("Lưu hoá đơn");
        TrungbinhNn = new JButton("TB thành tiền của khách hàng nước ngoài");
        Tongsl = new JButton("Tổng số lượng của các loại khách hàng");
        hoadonT = new JButton("Các hoá đơn tổng hợp trong tháng");
<<<<<<< HEAD
=======
=======
        // MakhTextField = new JTextField();
        // nameTextField = new JTextField();
        // NgayrahoadonTextField = new JTextField();
        // SoluongTextField = new JTextField();
        // DongiaTextField = new JTextField();
        addbButton = new JButton("Thêm khách hàng");
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
>>>>>>> 86b9ad0301f730bc73ecc265e391585cc29e8dcf
>>>>>>> 4366b2b2845e9834daf14c9334dcfda4d3e2c52a
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
                // Hiển thị JOptionPane với JRadioButton để chọn loại khách hàng
                int choice = JOptionPane.showOptionDialog(null, "Chọn loại khách hàng", "Tùy chọn",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                if (choice == JOptionPane.YES_OPTION) {
                    addKhachhangViet();
                } else if (choice == JOptionPane.NO_OPTION) {
                    addKhachhangnuocngoai();
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

<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
        // Add action listeners for buttons
        addbButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String[] options = { "Khách hàng Việt Nam", "Khách hàng nước ngoài" };

                // Hiển thị JOptionPane với JRadioButton để chọn loại khách hàng
                int choice = JOptionPane.showOptionDialog(null, "Chọn loại khách hàng", "Tùy chọn",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                // Xử lý lựa chọn
                if (choice == JOptionPane.YES_OPTION) {
                    // Chọn Khách hàng Việt Nam
                    // Xử lý logic tại đây
                    JPanel inputJPanel = new JPanel(new GridLayout(7, 2));
                    MakhTextField = new JTextField();
                    nameTextField = new JTextField();
                    NgayrahoadonTextField = new JTextField();
                    SoluongTextField = new JTextField();
                    DongiaTextField = new JTextField();
                    DinhmucTextField = new JTextField();
                    String[] optionss = { "Sinh hoạt", "Kinh doanh", "Sản xuất" };
                    customerTypeCombo = new JComboBox<>(optionss);
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
                    inputJPanel.add(new JLabel("Nhập Định mức:"));
                    inputJPanel.add(DinhmucTextField);
                    inputJPanel.add(new JLabel("Loại đối tượng:"));
                    inputJPanel.add(customerTypeCombo);
                    JOptionPane.showOptionDialog(null, inputJPanel, "Nhập thông tin", JOptionPane.OK_CANCEL_OPTION,
                            JOptionPane.PLAIN_MESSAGE, null, null, null);
                    addKhachhangViet();
                } else if (choice == JOptionPane.NO_OPTION) {
                    // Chọn Khách hàng nước ngoài
                    // Xử lý logic tại đây
                    JPanel inputJPanel = new JPanel(new GridLayout(7, 2));
                    MakhTextField = new JTextField();
                    nameTextField = new JTextField();
                    NgayrahoadonTextField = new JTextField();
                    SoluongTextField = new JTextField();
                    DongiaTextField = new JTextField();
                    QuoctichTextField = new JTextField();
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
                    JOptionPane.showOptionDialog(null, inputJPanel, "Nhập thông tin", JOptionPane.OK_CANCEL_OPTION,
                            JOptionPane.PLAIN_MESSAGE, null, null, null);
                    addKhachhangnuocngoai();
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

>>>>>>> 86b9ad0301f730bc73ecc265e391585cc29e8dcf
>>>>>>> 4366b2b2845e9834daf14c9334dcfda4d3e2c52a
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

            }
        });
        hoadonT.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                hoadonT();
            }
        });
        // loadKhachhang();
    }

    private void addKhachhangViet() {
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 4366b2b2845e9834daf14c9334dcfda4d3e2c52a
        new viewKHViet(this, controller, KhachhangService).setVisible(true);
    }

    private void addKhachhangnuocngoai() {
        new ViewKHNN(this, controller, KhachhangService).setVisible(true);
    }

    // Method to edit a Khachhang
    private void editKhachhang() {
        int row = table.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Please select a Khachhang to edit.");
            return;
        }
        clearFields();
    }

    // Method to delete a Khachhang
    private void deleteKhachhang() {
        int row = table.getSelectedRow();
        if (row == -1) {
<<<<<<< HEAD
=======
=======
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
        double Soluong = Double.parseDouble(SoluongTextField.getText());
        double Dongia = Double.parseDouble(DongiaTextField.getText());
        double Dinhmuc = Double.parseDouble(DinhmucTextField.getText());
        String doituongKH = customerTypeCombo.getSelectedItem().toString();
        // Calculate the average mark using the formula provided
        double ThanhTien;
        if (Soluong <= Dinhmuc) {
            ThanhTien = Soluong * Dongia;
        } else {
            ThanhTien = Dongia * Dinhmuc + (Soluong - Dinhmuc) * Dongia * 2.5;
        }
        Khachhang KhachhangViet = new KhachhangViet(doituongKH, Dinhmuc, Makh, name, Ngayrahoadon, Dongia, Soluong,
                ThanhTien);
        KhachhangService.addKhachhang(KhachhangViet);
    }

    private void addKhachhangnuocngoai() {
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
        double Soluong = Integer.parseInt(SoluongTextField.getText());
        double Dongia = Integer.parseInt(DongiaTextField.getText());
        String Quoctich = QuoctichTextField.getText();
        // Calculate the average mark using the formula provided
        double ThanhTien = Soluong * Dongia;
        Khachhang Khachhangnuocngoai = new Khachhangnuocngoai(Makh, name, Ngayrahoadon, Soluong, Dongia, ThanhTien,
                Quoctich);
        KhachhangService.addKhachhang(Khachhangnuocngoai);
    }

    // Method to edit a Khachhang
    private void editKhachhang() {
        int row = table.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Please select a Khachhang to edit.");
            return;
        }

        // Lấy thông tin từ các trường nhập liệu
        // int Makh = Integer.parseInt(MakhTextField.getText());
        // String name = nameTextField.getText();
        // Date Ngayrahoadon;
        // try {
        // SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", new
        // Locale("vi", "VN"));
        // Ngayrahoadon = dateFormat.parse(NgayrahoadonTextField.getText());
        // } catch (ParseException e) {
        // JOptionPane.showMessageDialog(null, "Invalid date format. Please use
        // 'dd/MM/yyyy' format for the date.");
        // return;
        // }
        // double Soluong = Double.parseDouble(SoluongTextField.getText());
        // double Dongia = Double.parseDouble(DongiaTextField.getText());

        // Calculate the total price using the formula provided

        // Lấy đối tượng Khachhang tại dòng đã chọn trong bảng
        // Thực hiện cập nhật thông tin khách hàng trong cơ sở dữ liệu
        KhachhangService.updateKhachhang(khachhang);

        // Xóa trắng các trường nhập liệu
        clearFields();
    }

    // Method to delete a Khachhang
    private void deleteKhachhang() {
        int row = table.getSelectedRow();
        if (row == -1) {
>>>>>>> 86b9ad0301f730bc73ecc265e391585cc29e8dcf
>>>>>>> 4366b2b2845e9834daf14c9334dcfda4d3e2c52a
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

    // Method to clear input fields
    private void clearFields() {
        MakhTextField.setText("");
        nameTextField.setText("");
        NgayrahoadonTextField.setText("");
        SoluongTextField.setText("");
        DongiaTextField.setText("");
    }

<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 4366b2b2845e9834daf14c9334dcfda4d3e2c52a
    @Override
    public void updateKhachhang(List<Khachhang> Khachhangs) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateKhachhang'");
    }

<<<<<<< HEAD
=======
=======
>>>>>>> 86b9ad0301f730bc73ecc265e391585cc29e8dcf
>>>>>>> 4366b2b2845e9834daf14c9334dcfda4d3e2c52a
}
