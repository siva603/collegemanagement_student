package com.collegesystem.servicesimp;

import com.collegesystem.documents.Students;
import com.collegesystem.repository.StudentRepository;
import com.collegesystem.services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImp implements StudentServices {

    private final   StudentRepository sr;

    public StudentServiceImp(StudentRepository sr)
    {
        this.sr=sr;
    }
    @Override
    public List<Students> getAllStudents() {
        return sr.findAll();
    }

    @Override
    public Optional<Students> getStudent(String id) {
        return sr.findById(id);
    }

    @Override
    public List<Students> getStudentByName(String name) {
        return sr.findByName(name);
    }

    @Override
    public Optional<Students> getStudentByRoll(String roll) {
        return Optional.ofNullable(sr.findByRoll(roll));
    }

    @Override
    public List<Students> getStudentByGroup(String group) {
        return sr.findByGroup(group);
    }

    @Override
    public List<Students> getStudentByYear(String year) {
        return sr.findByYear(year);
    }

    @Override
    public String createStudent(Students student) {

        sr.save(student);
        return "Student is created...";
    }

    @Override
    public String updateStudent(String id, Students student) {
        Optional<Students> exit=sr.findById(id);

        if(exit.isPresent())
        {
            Students _exit=exit.get();

            _exit.setName(student.getName());
            _exit.setAddress(student.getAddress());
            _exit.setCollege(student.getCollege());
            _exit.setGroup(student.getGroup());
            _exit.setRoll(student.getRoll());
            _exit.setStatus(student.getStatus());
            sr.save(_exit);

            return "Student updated successfully...";
        }
            return "student doesn't exit !!!";


    }

    @Override
    public String updateStudentPassword(String id, String password) {
        Optional<Students> exit= sr.findById(id);
        if (exit.isPresent()) {
            Students _exit=exit.get();

            _exit.setPassword(password);
            sr.save(_exit);
            return "Password reset successfully..";
        }
        return "student doesn't exited !!!";
    }

    @Override
    public String deleteStudent(String id) {

        Optional<Students> exit= sr.findById(id);

        if(exit.isPresent())
        {
            sr.deleteById(id);
            return "Student deleted successfully...";
        }
        return  "Student doesn't exited !!!";
    }
}
