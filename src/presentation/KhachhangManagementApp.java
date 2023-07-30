package presentation;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import domain.*;
import domain.model.Khachhang;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class KhachhangManagementApp extends JFrame {
    private KhachhangService KhachhangService;
    private DefaultTableModel tableModel;
    private JTable table;
    private JButton addButton;
    private JButton editButton;
    private JButton deleteButton;
    private JButton findButton;
    private JButton saveButton;
    private JTextField idTextField;
    private JTextField nameTextField;
    private JTextField majorTextField;
    private JTextField javaTextField;
    private JTextField htmlTextField;
    private JTextField cssTextField;

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
        tableModel.addColumn("ID");
        tableModel.addColumn("Name");
        tableModel.addColumn("Major");
        tableModel.addColumn("Java Mark");
        tableModel.addColumn("HTML Mark");
        tableModel.addColumn("CSS Mark");
        tableModel.addColumn("Average");
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        // Create JPanel for Khachhang details input and buttons
        JPanel inputPanel = new JPanel(new GridLayout(10, 2));
        idTextField = new JTextField();
        nameTextField = new JTextField();
        majorTextField = new JTextField();
        javaTextField = new JTextField();
        htmlTextField = new JTextField();
        cssTextField = new JTextField();
        addButton = new JButton("Add");
        editButton = new JButton("Edit");
        deleteButton = new JButton("Delete");
        findButton = new JButton("Find");
        saveButton = new JButton("Save");

        // new GridLayout(7, 2)

        inputPanel.add(new JLabel("ID:"));
        inputPanel.add(idTextField);

        inputPanel.add(new JLabel("Name:"));
        inputPanel.add(nameTextField);
        inputPanel.add(new JLabel("Major:"));
        inputPanel.add(majorTextField);
        inputPanel.add(new JLabel("Java Mark:"));
        inputPanel.add(javaTextField);
        inputPanel.add(new JLabel("HTML Mark:"));
        inputPanel.add(htmlTextField);
        inputPanel.add(new JLabel("CSS Mark:"));
        inputPanel.add(cssTextField);
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

        // Load initial Khachhang list
        loadKhachhangList();
    }

    // Method to add a Khachhang
    private void addKhachhang() {
        int id = Integer.parseInt(idTextField.getText());
        String name = nameTextField.getText();
        String major = majorTextField.getText();
        int javaMark = Integer.parseInt(javaTextField.getText());
        int htmlMark = Integer.parseInt(htmlTextField.getText());
        int cssMark = Integer.parseInt(cssTextField.getText());

        // Calculate the average mark using the formula provided
        double averageMark = (javaMark * 2.0 + htmlMark + cssMark) / 4.0;

        Khachhang Khachhang = new Khachhang(id, name, major, javaMark, htmlMark, cssMark, averageMark);
        KhachhangService.addKhachhang(Khachhang);

        clearFields();
        loadKhachhangList();
    }

    // Method to edit a Khachhang
    private void editKhachhang() {
        int row = table.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Please select a Khachhang to edit.");
            return;
        }

        int id = Integer.parseInt(idTextField.getText());
        String name = nameTextField.getText();
        String major = majorTextField.getText();
        int javaMark = Integer.parseInt(javaTextField.getText());
        int htmlMark = Integer.parseInt(htmlTextField.getText());
        int cssMark = Integer.parseInt(cssTextField.getText());

        // Calculate the average mark using the formula provided
        double averageMark = (javaMark * 2.0 + htmlMark + cssMark) / 4.0;

        Khachhang Khachhang = new Khachhang(id, name, major, javaMark, htmlMark, cssMark, averageMark);
        KhachhangService.updateKhachhang(Khachhang);

        clearFields();
        loadKhachhangList();
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
        loadKhachhangList();
    }

    // Method to find a Khachhang
    private void findKhachhang() {
        int KhachhangId = Integer.parseInt(idTextField.getText());
        Khachhang Khachhang = KhachhangService.getKhachhangById(KhachhangId);

        if (Khachhang != null) {
            nameTextField.setText(Khachhang.getName());
            majorTextField.setText(Khachhang.getMajor());
            javaTextField.setText(String.valueOf(Khachhang.getJavaMark()));
            htmlTextField.setText(String.valueOf(Khachhang.getHtmlMark()));
            cssTextField.setText(String.valueOf(Khachhang.getCssMark()));
        } else {
            JOptionPane.showMessageDialog(this, "Khachhang not found.");
            clearFields();
        }
    }

    // Method to load the Khachhang list into the JTable
    private void loadKhachhangList() {
        // List<Khachhang> Khachhangs = KhachhangService.getAllKhachhangs();
        List<Khachhang> Khachhangs = new ArrayList<>();
        Khachhangs.add(new Khachhang(111, "Le Van Teo", "IT", 5, 5, 5, 5));
        Khachhangs.add(new Khachhang(222, "Le Van Ty", "IT", 7,
                7, 5, 7));
        Khachhangs.add(new Khachhang(333, "Le Van Tung", "IT", 5,
                5, 5, 5));
        tableModel.setRowCount(0); // Clear previous data
        for (Khachhang Khachhang : Khachhangs) {
            Object[] rowData = { Khachhang.getId(), Khachhang.getName(), Khachhang.getMajor(),
                    Khachhang.getJavaMark(), Khachhang.getHtmlMark(), Khachhang.getCssMark(), Khachhang.calAverage() };
            tableModel.addRow(rowData);
        }
    }

    // Method to clear input fields
    private void clearFields() {
        idTextField.setText("");
        nameTextField.setText("");
        majorTextField.setText("");
        javaTextField.setText("");
        htmlTextField.setText("");
        cssTextField.setText("");
    }

}
