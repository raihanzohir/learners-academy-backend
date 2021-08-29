package com.learners.academy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learners.academy.entity.Subject;


public interface SubjectRepository extends JpaRepository<Subject, Long> {

}
