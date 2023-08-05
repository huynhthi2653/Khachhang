package pesistence;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import domain.model.Khachhang;
import domain.model.KhachhangViet;
import domain.model.Khachhangnuocngoai;

public class KhachhangJdbcGateway implements KhachhangGateway {
    private Connection connection;

    public KhachhangJdbcGateway() {
        // Khởi tạo kết nối đến cơ sở dữ liệu (thay dbUrl, username và password bằng thông tin đăng nhập SQL Server của bạn)
        String dbUrl = "jdbc:sqlserver://localhost:1433;databaseName=Khachhang";
        String username = "sa";
        String password = "123456";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(dbUrl, username, password);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addKhachhang(Khachhang khachhang) {
        String sql = "INSERT INTO khachhangchung (Makh, name, Ngayrahoadon, Soluong, Donggia) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, khachhang.getMakh());
            statement.setString(2, khachhang.getName());
            statement.setDate(3, new Date(khachhang.getNgayrahoadon().getTime()));
            statement.setDouble(4, khachhang.getSoluong());
            statement.setDouble(5, khachhang.getDongia());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateKhachhang(Khachhang khachhang) {
        String sql = "UPDATE khachhangchung SET name = ?, Ngayrahoadon = ?, Soluong = ?, Dongia = ? WHERE Makh = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, khachhang.getName());
            statement.setDate(2, new Date(khachhang.getNgayrahoadon().getTime()));
            statement.setDouble(3, khachhang.getSoluong());
            statement.setDouble(4, khachhang.getDongia());
            statement.setInt(5, khachhang.getMakh());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteKhachhang(int MaKH) {
        String sql = "DELETE FROM khachhangchung WHERE Makh = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, MaKH);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Khachhang getKhachhangById(int MaKH) {
        String sql = "SELECT * FROM khachhangchung WHERE Makh = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, MaKH);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int Makh = resultSet.getInt("Makh");
                String name = resultSet.getString("name");
                Date Ngayrahoadon = resultSet.getDate("Ngayrahoadon");
                double Soluong = resultSet.getDouble("Soluong");
                double Dongia = resultSet.getDouble("Dongia");
                // Tính toán giá trị Thành tiền sử dụng công thức đã cung cấp
                double ThanhTien = Soluong * Dongia;

                String customerType = resultSet.getString("customer_type");
                Khachhang khachhang;

                if ("KhachhangViet".equals(customerType)) {
                    khachhang = new KhachhangViet( Makh, name, Ngayrahoadon, Dongia, Soluong, ThanhTien)
                } else if ("Khachhangnuocngoai".equals(customerType)) {
                    khachhang = new Khachhangnuocngoai(Makh, name, Ngayrahoadon, Soluong, Dongia, ThanhTien,
                            "QuocTich");
                } else {
                    // Xử lý trường hợp loại khách hàng không hợp lệ
                    khachhang = null;
                }

                return khachhang;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Khachhang> getAllKhachhangs() {
        List<Khachhang> khachhangs = new ArrayList<>();
        String sql = "SELECT * FROM khachhangchung";
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int Makh = resultSet.getInt("Makh");
                String name = resultSet.getString("name");
                Date Ngayrahoadon = resultSet.getDate("Ngayrahoadon");
                double Soluong = resultSet.getDouble("Soluong");
                double Dongia = resultSet.getDouble("Dongia");
                // Tính toán giá trị Thành tiền sử dụng công thức đã cung cấp
                double ThanhTien = Soluong * Dongia;

                String customerType = resultSet.getString("customer_type");
                Khachhang khachhang;

                if ("KhachhangViet".equals(customerType)) {
                    khachhang = new KhachhangViet(Makh, name, Ngayrahoadon, Dongia, Soluong, ThanhTien);
                } else if ("Khachhangnuocngoai".equals(customerType)) {
                    khachhang = new Khachhangnuocngoai(Makh, name, Ngayrahoadon, Soluong, Dongia, ThanhTien,
                            "QuocTich");
                } else {
                    // Xử lý trường hợp loại khách hàng không hợp lệ
                    khachhang = null;
                }

                khachhangs.add(khachhang);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return khachhangs;
    }
}
