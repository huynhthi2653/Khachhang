/*
*  created date: Jul 24, 2023
*  author: cgm
*/
package pesistence;

import java.util.List;

import domain.model.Khachhang;

public class KhachhangDAOImpl implements KhachhangDAO {
    private StudentGateway studentGateway;

    public KhachhangDAOImpl(StudentGateway studentGateway) {
        this.studentGateway = studentGateway;
    }

    @Override
    public void addStudent(Khachhang student) {
        studentGateway.addStudent(student);
    }

    @Override
    public void updateStudent(Khachhang student) {
        studentGateway.updateStudent(student);
    }

    @Override
    public void deleteStudent(int studentId) {
        studentGateway.deleteStudent(studentId);
    }

    @Override
    public Khachhang getStudentById(int studentId) {
        return studentGateway.getStudentById(studentId);
    }

    @Override
    public List<Khachhang> getAllStudents() {
        return studentGateway.getAllStudents();
    }
}
