package com.cybertek.repository;

import com.cybertek.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //mapping repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    // can create class specific methods other than from JPARepository
}
