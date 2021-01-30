package com.cybertek.controller;

import com.cybertek.entity.*;
import com.cybertek.repository.AddressRepository;
import com.cybertek.repository.ParentRepository;
import com.cybertek.repository.StudentRepository;
import com.cybertek.repository.TeacherRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApiController {

    private AddressRepository addressRepository;
    private StudentRepository studentRepository;
    private TeacherRepository teacherRepository;
    private ParentRepository parentRepository;

    public ApiController(AddressRepository addressRepository, StudentRepository studentRepository, TeacherRepository teacherRepository, ParentRepository parentRepository) {
        this.addressRepository = addressRepository;
        this.studentRepository = studentRepository;
        this.teacherRepository = teacherRepository;
        this.parentRepository = parentRepository;
    }
    //------------------ teacher ----------------------------

    @GetMapping("/teachers")
    public List<Teacher> readAllTeachers(){
        return teacherRepository.findAll();
    }

    //------------------ student ----------------------------
    @GetMapping("/students")
    public ResponseEntity<ResponseWrapper> readAllStudents(){
        return ResponseEntity
                .ok(new ResponseWrapper("students are successfully retrieved",studentRepository.findAll()));
    }
//    @GetMapping("/students")
//    public List<Student> readAllStudents(){
//        return studentRepository.findAll();
//    }


    //------------------ address ----------------------------
    @GetMapping("/address")
    public List<Address> readAllAddress(){
        return addressRepository.findAll();
    }




    //------------------ parent ----------------------------

    @GetMapping("/parents")
    public List<Parent> readAllParents(){
        return parentRepository.findAll();
    }
}
