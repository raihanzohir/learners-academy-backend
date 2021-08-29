package com.learners.academy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learners.academy.entity.Classes;
import com.learners.academy.repository.ClassesRepository;

@Service
public class ClassesServiceImpl implements ClassesService {

	@Autowired
	private ClassesRepository classesRepository;

	@Override
	public List<Classes> getAllClasses() {
		return classesRepository.findAll();
	}

	@Override
	public Classes saveClasses(Classes student) {
		return classesRepository.save(student);
	}

	@Override
	public Classes getClassesById(Long id) {
		return classesRepository.findById(id).get();
	}

	@Override
	public Classes updateClasses(Classes classes) {
		return classesRepository.save(classes);
	}

	@Override
	public void deleteClassesById(Long id) {
		classesRepository.deleteById(id);
	}
}
