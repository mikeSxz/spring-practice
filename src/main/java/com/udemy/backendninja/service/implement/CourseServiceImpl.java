package com.udemy.backendninja.service.implement;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.udemy.backendninja.converter.CourseConverter;
import com.udemy.backendninja.entity.Course;
import com.udemy.backendninja.model.CourseModel;
import com.udemy.backendninja.repository.CourseJpaRepository;
import com.udemy.backendninja.service.CourseService;

@Service("courseServiceImpl")
public class CourseServiceImpl implements CourseService {

	private static final Log LOG = LogFactory.getLog(CourseServiceImpl.class);
	@Autowired
	@Qualifier("courseJpaRepository")
	private CourseJpaRepository courseJpaRepository;
	
	@Autowired
	@Qualifier("courseConverter")
	private CourseConverter courseConverter;

	@Override
	public List<CourseModel> listAllCourses() {		
		return courseConverter.entityList2Model(courseJpaRepository.findAll());
	}

	@Override
	public CourseModel addCourse(CourseModel courseModel) {
		return courseConverter.entity2Model(courseJpaRepository.save(courseConverter.model2Entity(courseModel)));	
	}

	@Override
	public int removeCourse(int id) {
		Course course = new Course();
		course.setId(id);
		courseJpaRepository.delete(course);
		return 0;
	}

	@Override
	public CourseModel updateCourse(CourseModel courseModel) {
		return courseConverter.entity2Model(courseJpaRepository.save(courseConverter.model2Entity(courseModel)));
	}

	
}