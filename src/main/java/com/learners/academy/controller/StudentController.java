package com.learners.academy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learners.academy.entity.Student;
import com.learners.academy.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	private StudentService studentService;

	@GetMapping("")
	public ResponseEntity<List<Student>> listStudents() {
		List<Student> studentList = studentService.getAllStudents();
		return new ResponseEntity<List<Student>>(studentList, getNoCacheHeaders(), HttpStatus.OK);
	}
	
	@PostMapping("/add")
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        //logger.info("StudentController.addStudent");
        Student newStudent = studentService.saveStudent(student);
        return new ResponseEntity<Student>(newStudent, getNoCacheHeaders(), HttpStatus.CREATED);
    }
	
	@PutMapping("/update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
        //logger.info("StudentController.updateStudent");
        Student updatedStudent = studentService.updateStudent(student);
        return new ResponseEntity<Student>(updatedStudent, getNoCacheHeaders(), HttpStatus.OK);
    }
	
	@GetMapping("/find/{id}")
    public ResponseEntity<Student> findStudent(@PathVariable("id") Long id) {
        //logger.info("StudentController.getStudentById: id=" + id);
		Student student = studentService.getStudentById(id);
        return new ResponseEntity<Student>(student, getNoCacheHeaders(), HttpStatus.OK);
    }
	
	@DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable("id") Long id) {
        //logger.info("StudentController.deleteStudent: id=" + id);
		studentService.deleteStudentById(id);
        return new ResponseEntity<>(getNoCacheHeaders(), HttpStatus.OK);
    }

    private HttpHeaders getNoCacheHeaders() {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Cache-Control", "no-cache");
        return responseHeaders;
    }
}
