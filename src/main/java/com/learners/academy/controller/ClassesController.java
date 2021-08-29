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

import com.learners.academy.entity.Classes;
import com.learners.academy.service.ClassesService;

@RestController
@RequestMapping("/classes")
public class ClassesController {
	
	@Autowired
	private ClassesService classesService;

	@GetMapping("")
	public ResponseEntity<List<Classes>> listStudents() {
		List<Classes> classesList = classesService.getAllClasses();
		return new ResponseEntity<List<Classes>>(classesList, getNoCacheHeaders(), HttpStatus.OK);
	}
	
	@PostMapping("/add")
    public ResponseEntity<Classes> addClasses(@RequestBody Classes classes) {
        //logger.info("ClassesController.addClasses");
        Classes newClass = classesService.saveClasses(classes);
        return new ResponseEntity<Classes>(newClass, getNoCacheHeaders(), HttpStatus.CREATED);
    }
	
	@PutMapping("/update")
    public ResponseEntity<Classes> updateClasses(@RequestBody Classes classes) {
        //logger.info("ClassesController.updateClasses");
        Classes updatedClasses = classesService.updateClasses(classes);
        return new ResponseEntity<Classes>(updatedClasses, getNoCacheHeaders(), HttpStatus.OK);
    }
	
	@GetMapping("/find/{id}")
    public ResponseEntity<Classes> findClasses(@PathVariable("id") Long id) {
        //logger.info("ClassesController.getClassesById: id=" + id);
		Classes classes = classesService.getClassesById(id);
        return new ResponseEntity<Classes>(classes, getNoCacheHeaders(), HttpStatus.OK);
    }
	
	@DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteClasses(@PathVariable("id") Long id) {
        //logger.info("ClassesController.deleteClasses: id=" + id);
		classesService.deleteClassesById(id);
        return new ResponseEntity<>(getNoCacheHeaders(), HttpStatus.OK);
    }
	
    private HttpHeaders getNoCacheHeaders() {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Cache-Control", "no-cache");
        return responseHeaders;
    }
}
