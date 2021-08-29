package com.learners.academy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learners.academy.entity.Classes;


public interface ClassesRepository extends JpaRepository<Classes, Long> {

}
