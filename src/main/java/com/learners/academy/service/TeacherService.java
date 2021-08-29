package com.learners.academy.service;

import java.util.List;

import com.learners.academy.entity.Teacher;

public interface TeacherService {

	List<Teacher> getAllTeachers();

	Teacher saveTeacher(Teacher classes);

	Teacher getTeacherById(Long id);

	Teacher updateTeacher(Teacher classes);

	void deleteTeacherById(Long id);
}
