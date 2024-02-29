package com.collegesystem.services;

import com.collegesystem.documents.Students;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface StudentServices {

    // get http method for code
    List<Students> getAllStudents();

    Optional<Students> getStudent(String id);

    List<Students> getStudentByName(String name);

    Optional<Students> getStudentByRoll(String roll);

    List<Students> getStudentByGroup(String group);

    List<Students> getStudentByYear(String year);

    // post method

    String createStudent(Students student);

    // put method

    String updateStudent(String id,Students student);

    String updateStudentPassword(String id,String password);

    // delete method

    String deleteStudent(String id);



}
