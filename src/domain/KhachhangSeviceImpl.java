/*
*  created date: Jul 24, 2023
*  author: cgm
*/
package domain;

import java.util.List;

import domain.model.Khachhang;
import pesistence.*;

public class KhachhangSeviceImpl implements KhachhangService {
    private KhachhangDAO KhachhangDAO;

    public KhachhangSeviceImpl() {
        // Initialize the StudentDAO (Data Access Layer)
        KhachhangDAO = new KhachhangDAOImpl(new StudentJdbcGateway());
    }

    @Override
    public void addStudent(Khachhang student) {
        KhachhangDAO.addStudent(student);
    }

    @Override
    public void updateStudent(Khachhang student) {
        KhachhangDAO.updateStudent(student);
    }

    @Override
    public void deleteStudent(int studentId) {
        KhachhangDAO.deleteStudent(studentId);
    }

    @Override
    public Khachhang getStudentById(int studentId) {
        return KhachhangDAO.getStudentById(studentId);
    }

    @Override
    public List<Khachhang> getAllStudents() {
        return KhachhangDAO.getAllStudents();
    }
}
