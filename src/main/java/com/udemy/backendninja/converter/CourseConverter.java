package com.udemy.backendninja.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.udemy.backendninja.entity.Course;
import com.udemy.backendninja.model.CourseModel;

@Component("courseConverter")
public class CourseConverter {

	// Convertir de Entity ---> Model
	public CourseModel entity2Model(Course course) {
		CourseModel courseModel = new CourseModel();
		courseModel.setId(course.getId());
		courseModel.setName(course.getName());
		courseModel.setDescription(course.getDescription());
		courseModel.setPrice(course.getPrice());
		courseModel.setHours(course.getHours());
		return courseModel;
	}

	// Convertir de Model ---> Entity
	public Course model2Entity(CourseModel courseModel) {
		Course course = new Course();
		course.setId(courseModel.getId());
		course.setName(courseModel.getName());
		course.setDescription(courseModel.getDescription());
		course.setPrice(courseModel.getPrice());
		course.setHours(courseModel.getHours());
		return course;
	}

	public List<CourseModel> entityList2Model(List<Course> courses) {
		List<CourseModel> models = new ArrayList<>();
		for (Course course : courses) {
			models.add(entity2Model(course));
		}
		return models;
	}

}
