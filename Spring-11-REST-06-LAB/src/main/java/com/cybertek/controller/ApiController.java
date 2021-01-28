package com.cybertek.controller;

import com.cybertek.entity.Address;
import com.cybertek.entity.Student;
import com.cybertek.repository.AddressRepository;
import com.cybertek.repository.StudentRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApiController {

    private AddressRepository addressRepository;
    private StudentRepository studentRepository;

    public ApiController(AddressRepository addressRepository, StudentRepository studentRepository) {
        this.addressRepository = addressRepository;
        this.studentRepository = studentRepository;
    }

    @GetMapping("/address")
    public List<Address> getAllAddress(){
        return addressRepository.findAll();
    }

    @GetMapping("/students")
    public List<Student> readAllStudents(){
        return studentRepository.findAll();
    }
}
