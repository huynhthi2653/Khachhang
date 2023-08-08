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
    public void addKhachhangViet(KhachhangViet KhachhangViet) {
        String sql = "INSERT INTO KhachhangVietchung (Makh, name, Ngayrahoadon, Soluong, Dongia, Dinhmuc, DoituongKH) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, KhachhangViet.getMakh());
            statement.setString(2, KhachhangViet.getName());
            statement.setDate(3, (Date) KhachhangViet.getNgayrahoadon()); // Convert to java.sql.Date
            statement.setInt(4, KhachhangViet.getSoluong());
            statement.setDouble(5, KhachhangViet.getDongia());
            statement.setInt(6, KhachhangViet.getDinhmuc());
            statement.setString(7, KhachhangViet.getDoituongKH());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addKhachhangnuocngoai(Khachhangnuocngoai Khachhangnuocngoai) {
        String sql = "INSERT INTO khachhangchung (Makh, name, Ngayrahoadon, Soluong, Dongia, Quoctich) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, Khachhangnuocngoai.getMakh());
            statement.setString(2, Khachhangnuocngoai.getName());
            statement.setDate(3, (Date) Khachhangnuocngoai.getNgayrahoadon()); // Convert to java.sql.Date
            statement.setInt(4, Khachhangnuocngoai.getSoluong());
            statement.setDouble(5, Khachhangnuocngoai.getDongia());
            statement.setString(8, Khachhangnuocngoai.getQuoctich());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateKhachhangViet(KhachhangViet KhachhangViet) {
        String sql = "UPDATE khachhangchung SET Name = ?, Ngayrahoadon = ?, Soluong = ?, Dongia = ?, Dinhmuc = ?, DoituongKH = ? WHERE Makh = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, KhachhangViet.getMakh());
            statement.setString(2, KhachhangViet.getName());
            statement.setDate(3, (Date) KhachhangViet.getNgayrahoadon()); // Convert to java.sql.Date
            statement.setInt(4, KhachhangViet.getSoluong());
            statement.setDouble(5, KhachhangViet.getDongia());
            statement.setInt(6, KhachhangViet.getDinhmuc());
            statement.setString(7, KhachhangViet.getDoituongKH());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateKhachhangnuocngoai(Khachhangnuocngoai Khachhangnuocngoai) {
        String sql = "UPDATE khachhangchung SET Name = ?, Ngayrahoadon = ?, Soluong = ?, Dongia = ?, Quoctich = ? WHERE Makh = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, Khachhangnuocngoai.getMakh());
            statement.setString(2, Khachhangnuocngoai.getName());
            statement.setDate(3, (Date) Khachhangnuocngoai.getNgayrahoadon()); // Convert to java.sql.Date
            statement.setInt(4, Khachhangnuocngoai.getSoluong());
            statement.setDouble(5, Khachhangnuocngoai.getDongia());
            statement.setString(8, Khachhangnuocngoai.getQuoctich());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteKhachhang(int MaKH) {
        String sql = "SELECT * FROM khachhangchung WHERE MaKH = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, MaKH);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Khachhang getKhachhangById(int MaKH) {
        String sql = "SELECT * FROM khachhangchung WHERE MaKH = ?";
        Khachhang Khachhang;
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, MaKH);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int Makh = resultSet.getInt("makh");
                String name = resultSet.getString("name");
                Date Ngayrahoadon = resultSet.getDate("date");
                int Soluong = resultSet.getInt("soluong");
                double Dongia = resultSet.getDouble("dongia");
                int Dinhmuc = resultSet.getInt("Dinhmuc");
                String DoituongKH = resultSet.getString("DoituongKH");
                String QuocTich = resultSet.getString("Quoctich");
                // Calculate the average mark using the formula provided
                double ThanhTien;
                if (Soluong <= Dinhmuc) {
                    ThanhTien = Dongia * Soluong;
                } else {
                    ThanhTien = Dongia * Dinhmuc + (Soluong - Dinhmuc) * Dongia * 2.5;
                }

                if (QuocTich != null) {
                    Khachhang = new KhachhangViet(Makh, QuocTich, Ngayrahoadon, Soluong, Dongia, ThanhTien, DoituongKH,
                            Dinhmuc);
                    return Khachhang;
                } else if (DoituongKH != null) {
                    Khachhang = new Khachhangnuocngoai(Makh, name, Ngayrahoadon, Soluong, Dongia, ThanhTien);
                    // Xử lý trường hợp loại khách hàng không hợp lệ
                    return Khachhang;
                }
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
                Date Ngayrahoadon = resultSet.getDate("date");
                int Soluong = resultSet.getInt("soluong");
                double Dongia = resultSet.getDouble("dongia");
                int Dinhmuc = resultSet.getInt("Dinhmuc");
                String DoituongKH = resultSet.getString("DoituongKH");
                String QuocTich = resultSet.getString("Quoctich");
                double ThanhTien = resultSet.getDouble("Thanhtien");

                if (QuocTich != null) {
                    khachhangs.add(new KhachhangViet(Makh, QuocTich, Ngayrahoadon, Soluong, Dongia, ThanhTien,
                            DoituongKH, Dinhmuc));
                } else if (DoituongKH != null) {
                    khachhangs.add(new Khachhangnuocngoai(Makh, name, Ngayrahoadon, Soluong, Dongia, ThanhTien));
                }
            }
            return khachhangs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return khachhangs;
    }

    @Override
    public double TongTTKNN(Khachhang Khachhang) {
        String sql = "call @Trungbinhthanhtien";
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                double ThanhtienNN = resultSet.getInt("ThanhtienNN");
                return ThanhtienNN;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
        return 0;

    }

    @Override
    public List<Khachhang> getKhachhangThang() {

    }
}
