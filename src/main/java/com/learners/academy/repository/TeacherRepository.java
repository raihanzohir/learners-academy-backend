package com.learners.academy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learners.academy.entity.Teacher;


public interface TeacherRepository extends JpaRepository<Teacher, Long> {

}
