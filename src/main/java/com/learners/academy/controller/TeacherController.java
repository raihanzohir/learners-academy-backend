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

import com.learners.academy.entity.Teacher;
import com.learners.academy.service.TeacherService;

@RestController
@RequestMapping("/teachers")
public class TeacherController {
	
	@Autowired
	private TeacherService teacherService;

	@GetMapping("")
	public ResponseEntity<List<Teacher>> listTeachers() {
		List<Teacher> teacherList = teacherService.getAllTeachers();
		return new ResponseEntity<List<Teacher>>(teacherList, getNoCacheHeaders(), HttpStatus.OK);
	}
	
	@PostMapping("/add")
    public ResponseEntity<Teacher> addTeacher(@RequestBody Teacher teacher) {
        //logger.info("TeacherController.addTeacher");
        Teacher newTeacher = teacherService.saveTeacher(teacher);
        return new ResponseEntity<Teacher>(newTeacher, getNoCacheHeaders(), HttpStatus.CREATED);
    }
	
	@PutMapping("/update")
    public ResponseEntity<Teacher> updateTeacher(@RequestBody Teacher teacher) {
        //logger.info("TeacherController.updateTeacher");
        Teacher updatedTeacher = teacherService.updateTeacher(teacher);
        return new ResponseEntity<Teacher>(updatedTeacher, getNoCacheHeaders(), HttpStatus.OK);
    }
	
	@GetMapping("/find/{id}")
    public ResponseEntity<Teacher> findTeacher(@PathVariable("id") Long id) {
        //logger.info("TeacherController.getTeacherById: id=" + id);
		Teacher teacher = teacherService.getTeacherById(id);
        return new ResponseEntity<Teacher>(teacher, getNoCacheHeaders(), HttpStatus.OK);
    }
	
	@DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTeacher(@PathVariable("id") Long id) {
        //logger.info("TeacherController.deleteTeacher: id=" + id);
		teacherService.deleteTeacherById(id);
        return new ResponseEntity<>(getNoCacheHeaders(), HttpStatus.OK);
    }

    private HttpHeaders getNoCacheHeaders() {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Cache-Control", "no-cache");
        return responseHeaders;
    }
}
