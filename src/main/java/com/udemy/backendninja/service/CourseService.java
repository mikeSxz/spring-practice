package com.udemy.backendninja.service;

import java.util.List;

import com.udemy.backendninja.model.CourseModel;

public interface CourseService {
	
	public abstract List<CourseModel> listAllCourses();

	public abstract CourseModel addCourse(CourseModel courseModel);

	public abstract int removeCourse(int id);

	public abstract CourseModel updateCourse(CourseModel courseModel);
}