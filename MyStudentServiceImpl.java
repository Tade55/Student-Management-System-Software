package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.MyStudent;
import com.example.demo.repository.MyStudentRepository;
import com.example.demo.service.MyStudentService;

@Service
public class MyStudentServiceImpl implements MyStudentService {
	
	@Autowired
	MyStudentRepository myStudentRepository;

	@Override
	public List<MyStudent> getAllStudents() {
		
		return myStudentRepository.findAll();
	}

	@Override
	public MyStudent saveStudent(MyStudent student) {
		
		return myStudentRepository.save(student);
	}

	@Override
	public Optional<MyStudent> findStudent(long id) {
		
		return myStudentRepository.findById(id);
	}

	@Override
	public void deleteStudent(long id) {
		
	     myStudentRepository.deleteById(id);
	}
	
	

}
