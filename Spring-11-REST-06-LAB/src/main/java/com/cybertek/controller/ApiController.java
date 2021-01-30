package com.cybertek.controller;

import com.cybertek.entity.Address;
import com.cybertek.entity.Parent;
import com.cybertek.entity.Student;
import com.cybertek.entity.Teacher;
import com.cybertek.repository.AddressRepository;
import com.cybertek.repository.ParentRepository;
import com.cybertek.repository.StudentRepository;
import com.cybertek.repository.TeacherRepository;
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

    @GetMapping("/address")
    public List<Address> getAllAddress(){
        return addressRepository.findAll();
    }

    @GetMapping("/students")
    public List<Student> readAllStudents(){
        return studentRepository.findAll();
    }
    @GetMapping("/teachers")
    public List<Teacher> readAllTeachers(){
        return teacherRepository.findAll();
    }
    @GetMapping("/parents")
    public List<Parent> readAllParents(){
        return parentRepository.findAll();
    }
}
