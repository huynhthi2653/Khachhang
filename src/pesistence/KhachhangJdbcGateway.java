/*
*  created date: Jul 24, 2023
*  author: cgm
*/
package pesistence;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import domain.model.Khachhang;
import domain.model.KhachhangViet;
import domain.model.Khachhangnuocngoai;

public class KhachhangJdbcGateway implements KhachhangGateway {
    private Connection connection;

    public KhachhangJdbcGateway() {
        String dbUrl = "jdbc:sqlserver://NO1SBK:1433;databaseName=danhsach;encrypt=false";
        String username = "sa";
        String password = "01102003";
        try {
            connection = DriverManager.getConnection(dbUrl, username, password);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ket noi không thanh conng" + toString(), "thông báo", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void addKhachhangViet(KhachhangViet KhachhangViet) {
        String sql = "INSERT INTO khachhang (Makh, Name, Ngayrahoadon, Soluong, Dongia, DoituongKH, Dinhmuc, Thanhtien) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, KhachhangViet.getMakh());
            statement.setString(2, KhachhangViet.getName());
            statement.setDate(3, (Date) KhachhangViet.getNgayrahoadon()); // Convert to java.sql.Date
            statement.setInt(4, KhachhangViet.getSoluong());
            statement.setDouble(5, KhachhangViet.getDongia());
            statement.setString(6, KhachhangViet.getDoituongKH());
            statement.setInt(7, KhachhangViet.getDinhmuc());
            statement.setDouble(8, KhachhangViet.getThanhTien());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addKhachhangnuocngoai(Khachhangnuocngoai Khachhangnuocngoai) {
        String sql = "INSERT INTO khachhang (Makh, Name, Ngayrahoadon, Soluong, Dongia, Quoctich) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, Khachhangnuocngoai.getMakh());
            statement.setString(2, Khachhangnuocngoai.getName());
            statement.setDate(3, (Date) Khachhangnuocngoai.getNgayrahoadon()); // Convert to java.sql.Date
            statement.setInt(4, Khachhangnuocngoai.getSoluong());
            statement.setDouble(5, Khachhangnuocngoai.getDongia());
            statement.setString(6, Khachhangnuocngoai.getQuoctich());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateKhachhangViet(KhachhangViet KhachhangViet) {
        String sql = "UPDATE khachhang SET Name = ?, Ngayrahoadon = ?, Soluong = ?, Dongia = ?, DoituongKH =?, Dinhmuc = ?, Thanhtien = ? WHERE Makh = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, KhachhangViet.getMakh());
            statement.setString(2, KhachhangViet.getName());
            statement.setDate(3, (Date) KhachhangViet.getNgayrahoadon()); // Convert to java.sql.Date
            statement.setInt(4, KhachhangViet.getSoluong());
            statement.setDouble(5, KhachhangViet.getDongia());
            statement.setString(6, KhachhangViet.getDoituongKH());
            statement.setInt(7, KhachhangViet.getDinhmuc());
            statement.setDouble(8, KhachhangViet.getThanhTien());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateKhachhangnuocngoai(Khachhangnuocngoai Khachhangnuocngoai) {
        String sql = "UPDATE khachhang SET Name = ?, Ngayrahoadon = ?, Soluong = ?, Dongia = ?, Quoctich = ? WHERE Makh = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, Khachhangnuocngoai.getMakh());
            statement.setString(2, Khachhangnuocngoai.getName());
            statement.setDate(3, (Date) Khachhangnuocngoai.getNgayrahoadon()); // Convert to java.sql.Date
            statement.setInt(4, Khachhangnuocngoai.getSoluong());
            statement.setDouble(5, Khachhangnuocngoai.getDongia());
            statement.setString(6, Khachhangnuocngoai.getQuoctich());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteKhachhang(int MaKH) {
        String sql = "SELECT * FROM khachhang WHERE MaKH = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, MaKH);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Khachhang TimkhachhangtuMakh(int MaKH) {
        String sql = "SELECT * FROM khachhang WHERE MaKH = ?";
        Khachhang Khachhang;
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, MaKH);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int Makh = resultSet.getInt("Makh");
                String Name = resultSet.getString("Name");
                Date Ngayrahoadon = resultSet.getDate("Ngayrahoadon");
                int Soluong = resultSet.getInt("Soluong");
                double Dongia = resultSet.getDouble("Dongia");
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
                    Khachhang = new KhachhangViet(Makh, Name, Ngayrahoadon, Soluong, Dongia, ThanhTien, DoituongKH, Dinhmuc);
                    return Khachhang;
                } else if (DoituongKH != null) {
                    Khachhang = new Khachhangnuocngoai(Makh, Name, Ngayrahoadon, Soluong, Dongia, QuocTich, ThanhTien);
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
        String sql = "SELECT * FROM khachhang";
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
               int Makh = resultSet.getInt("Makh");
                String Name = resultSet.getString("Name");
                Date Ngayrahoadon = resultSet.getDate("Ngayrahoadon");
                int Soluong = resultSet.getInt("Soluong");
                double Dongia = resultSet.getDouble("Dongia");
                int Dinhmuc = resultSet.getInt("Dinhmuc");
                String DoituongKH = resultSet.getString("DoituongKH");
                String QuocTich = resultSet.getString("Quoctich");
                double ThanhTien = resultSet.getDouble("Thanhtien");

                if (QuocTich != null) {
                    khachhangs.add(new KhachhangViet(Makh, Name, Ngayrahoadon, Soluong, Dongia, ThanhTien, DoituongKH, Dinhmuc));
                } else if (DoituongKH != null) {
                    khachhangs.add(new Khachhangnuocngoai(Makh, Name, Ngayrahoadon, Soluong, Dongia, QuocTich, ThanhTien));
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

    public List<Khachhang> getKhachhangThang(String thang) {
        List<Khachhang> hoadonT = new ArrayList<>();
        String sql = "SELECT * FROM khachhang WHERE MONTH(Ngayrahoadon) = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, thang);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int Makh = resultSet.getInt("Makh");
                String Name = resultSet.getString("Name");
                Date Ngayrahoadon = resultSet.getDate("Ngayrahoadon");
                int Soluong = resultSet.getInt("Soluong");
                double Dongia = resultSet.getDouble("Dongia");
                int Dinhmuc = resultSet.getInt("Dinhmuc");
                String DoituongKH = resultSet.getString("DoituongKH");
                String QuocTich = resultSet.getString("Quoctich");
                double ThanhTien = resultSet.getDouble("Thanhtien");
                
                if(QuocTich != null){
                    hoadonT.add(new KhachhangViet(Makh, Name, Ngayrahoadon, Soluong, Dongia, ThanhTien, DoituongKH, Dinhmuc));
                }else if(DoituongKH != null){
                    hoadonT.add(new Khachhangnuocngoai(Makh, Name, Ngayrahoadon, Soluong, Dongia, QuocTich, ThanhTien));
                }
                return hoadonT;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return hoadonT;
    }

    @Override
    public int TongSLKHNN() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'TongSLKHNN'");
    }

    @Override
    public int TongSLKHV() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'TongSLKHV'");
    }
}
