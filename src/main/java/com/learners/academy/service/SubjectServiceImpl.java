package com.learners.academy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learners.academy.entity.Subject;
import com.learners.academy.repository.SubjectRepository;

@Service
public class SubjectServiceImpl implements SubjectService {

	@Autowired
	private SubjectRepository subjectRepository;

	@Override
	public List<Subject> getAllSubjects() {
		return subjectRepository.findAll();
	}

	@Override
	public Subject saveSubject(Subject subject) {
		return subjectRepository.save(subject);
	}

	@Override
	public Subject getSubjectById(Long id) {
		return subjectRepository.findById(id).get();
	}

	@Override
	public Subject updateSubject(Subject subject) {
		return subjectRepository.save(subject);
	}

	@Override
	public void deleteSubjectById(Long id) {
		subjectRepository.deleteById(id);
	}
}
