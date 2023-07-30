/*
*  created date: Jul 24, 2023
*  author: cgm
*/
package pesistence;

import java.util.List;

import domain.model.Khachhang;

public interface StudentGateway {
    void addStudent(Khachhang student);

    void updateStudent(Khachhang student);

    void deleteStudent(int studentId);

    Khachhang getStudentById(int studentId);

    List<Khachhang> getAllStudents();
}
