/*
*  created date: Jul 24, 2023
*  author: cgm
*/
package pesistence;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import domain.model.Khachhang;

public class KhachhangJdbcGateway implements KhachhangGateway {
    private Connection connection;
    private int Makh;
    private String name;
    private Date Ngayrahoadon;
    private double Soluong;
    private double Dongia;
    private double Dinhmuc;
    public KhachhangJdbcGateway() {
        // Initialize the database connection here (replace dbUrl, username, and
        // password with your SQL Server credentials)
        String dbUrl = "jdbc:sqlserver://localhost:1433;databaseName=YourDatabaseName";
        String username = "YourUsername";
        String password = "YourPassword";
        try {
            connection = DriverManager.getConnection(dbUrl, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addKhachhang(Khachhang Khachhang) {
        String sql = "INSERT INTO Khachhangs (id, name, major, java_mark, html_mark, css_mark) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, Khachhang.getMakh());
            statement.setString(2, Khachhang.getName());
            statement.setString(3, Khachhang.getMajor());
            statement.setInt(4, Khachhang.getJavaMark());
            statement.setInt(5, Khachhang.getHtmlMark());
            statement.setInt(6, Khachhang.getCssMark());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateKhachhang(Khachhang Khachhang) {
        String sql = "UPDATE Khachhangs SET name = ?, major = ?, java_mark = ?, html_mark = ?, css_mark = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, Khachhang.getName());
            statement.setString(2, Khachhang.getMajor());
            statement.setInt(3, Khachhang.getJavaMark());
            statement.setInt(4, Khachhang.getHtmlMark());
            statement.setInt(5, Khachhang.getCssMark());
            statement.setInt(6, Khachhang.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteKhachhang(int KhachhangId) {
        String sql = "DELETE FROM Khachhangs WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, KhachhangId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Khachhang getKhachhangById(int KhachhangId) {
        String sql = "SELECT * FROM Khachhangs WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, KhachhangId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int Makh = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Date Ngayrahoadon  = resultSet.getString("major");
                Double Soluong = resultSet.getInt("java_mark");
                Double Dongia = resultSet.getInt("html_mark");
                Double Dinhmuc = resultSet.getInt("css_mark");
                // Calculate the average mark using the formula provided
                double Thanhtien = (javaMark * 2.0 + htmlMark + cssMark) / 4.0;

                return new Khachhang(Makh, name, Ngayrahoadon, Thanhtien, KhachhangId, Makh, Thanhtien);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Khachhang> getAllKhachhangs() {
        List<Khachhang> Khachhangs = new ArrayList<>();
        String sql = "SELECT * FROM Khachhangs";
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int Makh = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Date Ngayrahoadon  = resultSet.getString("major");
                Double Soluong = resultSet.getInt("java_mark");
                Double Dongia = resultSet.getInt("html_mark");
                Double Dinhmuc = resultSet.getInt("css_mark");
                // Calculate the average mark using the formula provided
                double ThanhTien = ( * 2.0 + htmlMark + cssMark) / 4.0;

                Khachhangs.add(new Khachhang(Makh, name, Ngayrahoadon,ThanhTien, Soluong, Dongia ,Dinhmuc));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Khachhangs;
    }
}
