package com.collegesystem.controller;

import com.collegesystem.documents.Students;
import com.collegesystem.services.StudentServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/students")
public class StudentController {

    private  final StudentServices studentService;

    public  StudentController(StudentServices studentService)
    {
        this.studentService=studentService;
    }

    @PostMapping
    public String createStudentMethod(@RequestBody Students student)
    {
        return studentService.createStudent(student);
    }

    @GetMapping("/{id}")
    public Optional<Students> getStudentById(@PathVariable("id") String id) {

        return studentService.getStudent(id);
    }

    @GetMapping
    public List<Students> getStudents(){

        return studentService.getAllStudents();

    }

    @PutMapping("/{id}")
    public String updateStudent(@PathVariable("id") String id,@RequestBody Students student)
    {
        return studentService.updateStudent(id,student);
    }

    @PutMapping("/{id}/{password}")
    public String updateStudentPassword(@PathVariable("id") String id,@PathVariable("password") String password)
    {
        return studentService.updateStudentPassword(id,password);
    }

    @DeleteMapping("/{id}")
    public   String deleteStudent(@PathVariable("id") String id)
    {
            return  studentService.deleteStudent(id);
    }

    @GetMapping("/name/{name}")
    public  List<Students> getStudentByName(@PathVariable("name") String name){

        return studentService.getStudentByName(name);
    }

    @GetMapping("/roll/{roll}")
    public  Optional<Students> getStudentByRoll(@PathVariable("roll") String roll){

        return studentService.getStudentByRoll(roll);
    }

    @GetMapping("/group/{group}")
    public List<Students> getStudentByGroup(@PathVariable("group") String group){

        return studentService.getStudentByGroup(group);
    }

    @GetMapping("/year/{year}")
    public List<Students> getStudentByyear(@PathVariable("year") String year){

        return studentService.getStudentByYear(year);
    }



}
