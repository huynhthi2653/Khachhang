package presentation;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import domain.*;
import domain.model.Khachhang;
import presentation.Controllertest.Command;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class KhachhangManagementApp extends JFrame implements Subscriber {
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

    public KhachhangManagementApp() {
        KhachhangService = new KhachhangSeviceImpl();
        controller = new Controller();
        KhachhangService.subscribe(this);
        setTitle("Khachhang Management");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create JTable to display Khachhang list
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Mã KH");
        tableModel.addColumn("Name");
        tableModel.addColumn("Ngày ra hoá đơn");
        tableModel.addColumn("Số lượng");
        tableModel.addColumn("Đơn giá");
        tableModel.addColumn("Định mức");
        tableModel.addColumn("Đối tượng");
        tableModel.addColumn("Quốc tịch");
        tableModel.addColumn("Thành tiền");
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);
        JPanel inputPanel = new JPanel(new GridLayout(10, 2));

        addbButton = new JButton("Thêm hoá đơn");
        editButton = new JButton("Sửa hoá đơn");
        deleteButton = new JButton("Xoá hoá đơn");
        findButton = new JButton("Tìm hoá đơn");
        saveButton = new JButton("Lưu hoá đơn");
        TrungbinhNn = new JButton("TB thành tiền của khách hàng nước ngoài");
        Tongsl = new JButton("Tổng số lượng của các loại khách hàng");
        hoadonT = new JButton("Các hoá đơn tổng hợp trong tháng");
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

            }
        });
        Tongsl.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Tongsl();
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
        loadKhachhang();
    }

    private void addKhachhangViet() {
        new viewKHViet(this, controller, KhachhangService, 0).setVisible(true);
    }

    private void addKhachhangnuocngoai() {
        new ViewKHNN(this, controller, KhachhangService, 0).setVisible(true);
    }

    // Method to edit a Khachhang
    private void editKhachhang() {
        int row = table.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một Khachhang để chỉnh sửa.");
            return;
        }
        // Lấy thông tin khách hàng từ dòng đã chọn trong bảng
        String QuocTich = (String) tableModel.getValueAt(row, 8); // Chỉnh index thành 8
        // Kiểm tra quốc tịch để xác định loại khách hàng và hiển thị giao diện tương
        // ứng
        if (QuocTich == null || QuocTich.isEmpty()) {
            UpdateKhachhangViet();
        } else {
            UpdateKhachhangnuocngoai();
        }
    }

    private void UpdateKhachhangViet() {
        new viewKHViet(this, controller, KhachhangService, ABORT).setVisible(true);
    }

    private void UpdateKhachhangnuocngoai() {
        new ViewKHNN(this, controller, KhachhangService, ABORT).setVisible(true);
    }

    // Method to delete a Khachhang
    private void deleteKhachhang() {
        int row = table.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Please select a Khachhang to delete.");
            return;
        }
        int KhachhangId = (int) tableModel.getValueAt(row, 0);
        Command DeleteCommand = new presentation.Controllertest.DeleteCommand(KhachhangService, KhachhangId);
        controller.excute(DeleteCommand);
    }

    private void Tongsl() {
        String[] options = { "Khách hàng Việt Nam", "Khách hàng nước ngoài" };

        // Hiển thị JOptionPane với JRadioButton để chọn loại khách hàng
        int choice = JOptionPane.showOptionDialog(null, "Chọn loại khách hàng", "Tùy chọn",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        // Xử lý lựa chọn
        if (choice == JOptionPane.YES_OPTION) {
            // Chọn Khách hàng Việt Nam
            // Xử lý logic tại đây
            int tongSL = TongSLKHV();

            // Hiển thị bảng với tổng số lượng khách hàng Việt Nam
            hienThiTongSoLuongKhachHang(tongSL, "Khách hàng Việt Nam");
        } else if (choice == JOptionPane.NO_OPTION) {
            // Chọn Khách hàng nước ngoài
            // Xử lý logic tại đây
            int tongSLNN = TongSLKHNN();

            // Hiển thị bảng với tổng số lượng khách hàng nước ngoài
            hienThiTongSoLuongKhachHang(tongSLNN, "Khách hàng nước ngoài");
        } else {
            // Không chọn gì cả hoặc đóng cửa sổ
        }
    }

    private void hienThiTongSoLuongKhachHang(int tongSL, String loaiKhachHang) {
        JFrame frame = new JFrame("Tổng số lượng khách hàng - " + loaiKhachHang);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Tạo một bảng để hiển thị tổng số lượng
        String[] columnNames = { "Loại khách hàng", "Tổng số lượng" };
        Object[][] data = { { "Loai khach hang: ", loaiKhachHang }, { "Tong so luong: ", tongSL } };
        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane);
        frame.pack();
        frame.setVisible(true);
    }

    private int TongSLKHV() {
        return KhachhangService.TongSLKHV();
    }

    private int TongSLKHNN() {
        return KhachhangService.TongSLKHNN();
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
            Khachhang Khachhang = KhachhangService.TimkhachhangtuMakh(KhachhangId);

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
        JPanel inputPanel = new JPanel(new GridLayout(2, 2));
        JTextField thangField = new JTextField();
        inputPanel.add(new JLabel("Tháng:"));
        inputPanel.add(thangField);
        // Hiển thị JOptionPane với các thành phần nhập liệu
        int result = JOptionPane.showOptionDialog(null, inputPanel, "Chọn thông tin",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);

        // Xử lý khi người dùng chọn OK
        if (result == JOptionPane.OK_OPTION) {
            String thang = thangField.getText();
            new XuathoadonTT(this, controller, KhachhangService, thang);
        }
    }

    public void loadKhachhang() {
        KhachhangService.getAllKhachhangs();
    }

    // Method to load the Khachhang list into the JTable
    @Override
    public void updateKhachhang(List<Khachhang> HoadonList) {
        while (tableModel.getRowCount() != 0) {
            tableModel.removeRow(0);
        }
        for (Khachhang hoadonList : HoadonList) {
            Object[] rowData = { hoadonList.getMakh(), hoadonList.getName(), hoadonList.getNgayrahoadon(),
                    hoadonList.getSoluong(), hoadonList.getDongia(), hoadonList.getDinhmuc(),
                    hoadonList.getDoituongKH(), hoadonList.getQuoctich() };
            tableModel.addRow(rowData);
        }
    }

}
