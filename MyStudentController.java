package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.MyStudent;
import com.example.demo.service.MyStudentService;


@Controller
public class MyStudentController {
	
	@Autowired
	private MyStudentService myStudentService;
	
	
	
	@GetMapping("/students")
	public ModelAndView listStudents() {
		ModelAndView mv=new ModelAndView("students");
		mv.addObject("students", myStudentService.getAllStudents());
		return mv;
	}

	@GetMapping("/students/new")
	public ModelAndView createStudentForm() {
		MyStudent student = new MyStudent();
		ModelAndView mv=new ModelAndView("create_student");
		mv.addObject("student", student);
		return mv;
	}
	
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") MyStudent student) {
		myStudentService.saveStudent(student);
	    return"redirect:/students";	
	}
	
   
	 @GetMapping("/showupdateform")
	  public ModelAndView showUpdateForm(@RequestParam Long studentId) {
		 ModelAndView mv=new ModelAndView("create_student"); 
		 MyStudent student= myStudentService.findStudent(studentId).get();
		 mv.addObject("student", student);
		 return mv;
	 }
	
     @GetMapping("/deletestudent")
     public String deleteStudent(@RequestParam Long studentId) {
    	 myStudentService.deleteStudent(studentId);
    	 return "redirect:/students";
    			 
     }
}

