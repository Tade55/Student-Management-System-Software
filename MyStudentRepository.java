package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.entity.MyStudent;

public interface MyStudentRepository extends JpaRepository<MyStudent, Long> {

}
