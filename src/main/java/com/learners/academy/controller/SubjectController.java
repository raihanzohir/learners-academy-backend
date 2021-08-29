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

import com.learners.academy.entity.Subject;
import com.learners.academy.service.SubjectService;

@RestController
@RequestMapping("/subjects")
public class SubjectController {
	
	@Autowired
	private SubjectService subjectService;

	@GetMapping("")
	public ResponseEntity<List<Subject>> listSubjects() {
		List<Subject> subjectList = subjectService.getAllSubjects();
		return new ResponseEntity<List<Subject>>(subjectList, getNoCacheHeaders(), HttpStatus.OK);
	}
	
	@PostMapping("/add")
    public ResponseEntity<Subject> addSubject(@RequestBody Subject subject) {
        //logger.info("SubjectController.addSubject");
        Subject newSubject = subjectService.saveSubject(subject);
        return new ResponseEntity<Subject>(newSubject, getNoCacheHeaders(), HttpStatus.CREATED);
    }
	
	@PutMapping("/update")
    public ResponseEntity<Subject> updateSubject(@RequestBody Subject subject) {
        //logger.info("SubjectController.updateSubject");
        Subject updatedSubject = subjectService.updateSubject(subject);
        return new ResponseEntity<Subject>(updatedSubject, getNoCacheHeaders(), HttpStatus.OK);
    }
	
	@GetMapping("/find/{id}")
    public ResponseEntity<Subject> findSubject(@PathVariable("id") Long id) {
        //logger.info("SubjectController.getSubjectById: id=" + id);
		Subject subject = subjectService.getSubjectById(id);
        return new ResponseEntity<Subject>(subject, getNoCacheHeaders(), HttpStatus.OK);
    }
	
	@DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteSubject(@PathVariable("id") Long id) {
        //logger.info("SubjectController.deleteSubject: id=" + id);
		subjectService.deleteSubjectById(id);
        return new ResponseEntity<>(getNoCacheHeaders(), HttpStatus.OK);
    }

    private HttpHeaders getNoCacheHeaders() {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Cache-Control", "no-cache");
        return responseHeaders;
    }
}
