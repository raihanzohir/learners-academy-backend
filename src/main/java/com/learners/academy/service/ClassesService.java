package com.learners.academy.service;

import java.util.List;

import com.learners.academy.entity.Classes;

public interface ClassesService {

	List<Classes> getAllClasses();

	Classes saveClasses(Classes classes);

	Classes getClassesById(Long id);

	Classes updateClasses(Classes classes);

	void deleteClassesById(Long id);
}
