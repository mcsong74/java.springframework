package com.cybertek.controller;

import com.cybertek.entity.*;
import com.cybertek.repository.AddressRepository;
import com.cybertek.repository.ParentRepository;
import com.cybertek.repository.StudentRepository;
import com.cybertek.repository.TeacherRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
//------------------ parent ----------------------------
    @GetMapping("/parents")
    public ResponseEntity<ResponseWrapper> readAllParents(){
        ResponseWrapper responseWrapper= new ResponseWrapper(true, "Parents are successfully retrieved."
                , HttpStatus.ACCEPTED.value(), parentRepository.findAll());
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(responseWrapper);
    }
    //    @GetMapping("/parents")
    //    public List<Parent> readAllParents(){
    //        return parentRepository.findAll();
    //    }
    //------------------ address ----------------------------
//    @GetMapping("/address")
//    public List<Address> readAllAddress(){
//        return addressRepository.findAll();
//    }

    @PutMapping("/address/{id}")
    public Address updateAdrress(@PathVariable("id") Long id, @RequestBody Address address) throws Exception {
        Optional<Address> foundAddress = addressRepository.findById(id);

        if (!foundAddress.isPresent()){
            throw new Exception("Address does not exists");
        }
        address.setCurrentTemperature(new Address().consumeTemp(address.getCity()));
        address.setId(foundAddress.get().getId());
        return addressRepository.save(address);
    }





}
