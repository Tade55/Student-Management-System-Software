package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.example.demo.entity.MyStudent;

@Component
public interface MyStudentService {
	List<MyStudent> getAllStudents();
    MyStudent saveStudent(MyStudent student);
    Optional<MyStudent> findStudent(long id);
    void deleteStudent(long id);
}
