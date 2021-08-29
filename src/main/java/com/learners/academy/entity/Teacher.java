package com.learners.academy.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.JoinColumn;

@Entity
public class Teacher {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="teacher_seq")
	@SequenceGenerator(
	    name="teacher_seq",
	    sequenceName="teacher_sequence",
	    allocationSize=1
	)
	@Column(name = "teacherId", updatable = false, nullable = true)
	private Long teacherId;
	@Column(nullable = true)
	private String teacherName;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "teacher_subject", joinColumns = { @JoinColumn(name = "teacherId") }, inverseJoinColumns = {
			@JoinColumn(name = "subjectId") })
	private List<Subject> subjects = new ArrayList<>();

	public List<Subject> getSubject() {
		return subjects;
	}

	public void setSubject(List<Subject> subjects) {
		this.subjects = subjects;
	}

	public Long getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(Long teacherId) {
		this.teacherId = teacherId;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public Teacher(String teacherName, List<Subject> subjects) {
		super();
		this.teacherName = teacherName;
		this.subjects = subjects;
	}

	public Teacher() {

	}

	@Override
	public String toString() {
		return "Teacher [teacherId=" + teacherId + ", teacherName=" + teacherName + ", subjects=" + subjects + "]";
	}

}
