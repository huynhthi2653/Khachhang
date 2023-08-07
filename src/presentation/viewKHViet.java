package presentation;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class viewKHViet extends JFrame {
    private JTextField MakhTextField;
    private JTextField nameTextField;
    private JTextField NgayrahoadonTextField;
    private JTextField SoluongTextField;
    private JTextField DongiaTextField;
    private JTextField DinhmucTextField;
    private JComboBox<String> customerTypeCombo;

    public viewKHViet(KhachhangManagementApp viewApp) {
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
    }
}
