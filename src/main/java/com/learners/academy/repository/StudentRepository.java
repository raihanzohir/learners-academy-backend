package com.learners.academy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learners.academy.entity.Student;


public interface StudentRepository extends JpaRepository<Student, Long> {

}
