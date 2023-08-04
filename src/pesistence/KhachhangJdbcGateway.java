/*
*  created date: Jul 24, 2023
*  author: cgm
*/
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
        // Initialize the database connection here (replace dbUrl, username, and
        // password with your SQL Server credentials)
        String dbUrl = "jdbc:sqlserver://localhost:1433;databaseName=Khachhang";
        String username = "sa";
        String password = "123456";
        try {
            connection = DriverManager.getConnection(dbUrl, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addKhachhang(Khachhang Khachhang) {
        String sql = "INSERT INTO khachhangchung (Makh, name, Ngayrahoadon, Soluong, Donggi) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, Khachhang.getMakh());
            statement.setString(2, Khachhang.getName());
            statement.setDate(3, (Date) Khachhang.getNgayrahoadon());
            statement.setDouble(5, Khachhang.getSoluong());
            statement.setDouble(6, Khachhang.getDongia());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateKhachhang(Khachhang Khachhang) {
        String sql = "UPDATE khachhangchung SET Name = ?, Ngayrahoadon = ?, Soluong = ?, Dongia = ?, Makh = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, Khachhang.getName());
            statement.setDate(2, (Date) Khachhang.getNgayrahoadon());
            statement.setDouble(4, Khachhang.getSoluong());
            statement.setDouble(5, Khachhang.getDongia());
            statement.setInt(6, Khachhang.getMakh());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteKhachhang(int MaKH) {
        String sql = "DELETE FROM khachhangchung WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, MaKH);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Khachhang getKhachhangById(int MaKH) {
        String sql = "SELECT * FROM khachhangchung WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, MaKH);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int Makh = resultSet.getInt("makh");
                String name = resultSet.getString("name");
                Date Ngayrahoadon = resultSet.getDate("date");
                double Soluong = resultSet.getDouble("soluong");
                double Dongia = resultSet.getDouble("dongia");
                // Calculate the average mark using the formula provided
                double ThanhTien = Soluong * Dongia;
                
                String customerType = resultSet.getString("customer_type");
                Khachhang khachhang;
    
                if ("KhachhangViet".equals(customerType)) {
                    khachhang = new KhachhangViet(Makh, MaKH, Makh, name, Ngayrahoadon, Dongia, Soluong, ThanhTien);
                } else if ("Khachhangnuocngoai".equals(customerType)) {
                    khachhang = new Khachhangnuocngoai(Makh, name, Ngayrahoadon, Soluong, Dongia, ThanhTien, "QuocTich");
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
        String sql = "SELECT * FROM Khachhangs";
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int Makh = resultSet.getInt("makh");
                String name = resultSet.getString("name");
                Date Ngayrahoadon = resultSet.getDate("ngayrahoadon");
                double Soluong = resultSet.getDouble("soluong");
                double Dongia = resultSet.getDouble("dongia");
                // Calculate the average mark using the formula provided
                double ThanhTien = Soluong * Dongia;
    
                String customerType = resultSet.getString("customer_type");
                Khachhang khachhang;
    
                if ("KhachhangViet".equals(customerType)) {
                    khachhang = new KhachhangViet(Makh, Makh, Makh, name, Ngayrahoadon, Dongia, Soluong, ThanhTien);
                } else if ("Khachhangnuocngoai".equals(customerType)) {
                    khachhang = new Khachhangnuocngoai(Makh, name, Ngayrahoadon, Soluong, Dongia, ThanhTien, "QuocTich");
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
