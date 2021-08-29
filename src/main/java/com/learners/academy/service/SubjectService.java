package com.learners.academy.service;

import java.util.List;

import com.learners.academy.entity.Subject;

public interface SubjectService {

	List<Subject> getAllSubjects();

	Subject saveSubject(Subject classes);

	Subject getSubjectById(Long id);

	Subject updateSubject(Subject classes);

	void deleteSubjectById(Long id);
}
