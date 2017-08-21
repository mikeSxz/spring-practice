package com.udemy.backendninja.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.udemy.backendninja.model.CourseModel;
import com.udemy.backendninja.service.CourseService;

@Controller
@RequestMapping("/courses") 
public class CourseController {

	private static final String COURSES_VIEW = "courses";
	private static final Log LOG = LogFactory.getLog(CourseController.class);

	@Autowired
	@Qualifier("courseServiceImpl")
	private CourseService courseService;



	@GetMapping("/listcourses")
	public ModelAndView listAllCourses() {
		LOG.info("Call: listAllCourses()");
		ModelAndView mav = new ModelAndView(COURSES_VIEW);
		mav.addObject("course", new CourseModel());
		mav.addObject("courses", courseService.listAllCourses());
		return mav;
	}
	

	@GetMapping("/listcourses2")
	@ResponseBody
	public List<CourseModel> listAllCourses2() {
		LOG.info("Call: listAllCourses()");
		ModelAndView mav = new ModelAndView(COURSES_VIEW);
		mav.addObject("course", new CourseModel());
		mav.addObject("courses", courseService.listAllCourses());
		return courseService.listAllCourses();
	}

	@PostMapping("/addcourse")
	public String addCourse(@ModelAttribute("course") CourseModel courseModel) {
		LOG.info("Call: addCourse() ----  with PARAMS: " + courseModel.toString());
		courseService.addCourse(courseModel);
		return "redirect:/courses/listcourses";
	}

	@GetMapping("/deletecourse")
	public String deleteCourse(@RequestParam(name="id",required=true, defaultValue="NULL") String id) {
		LOG.info("Call: deleteCourse() ----  with PARAMS: " + id);
		CourseModel courseModel = new CourseModel();
		int intId = Integer.parseInt(id);
		courseModel.setId(intId);
		courseService.removeCourse(courseModel.getId());
		return "redirect:/courses/listcourses";
	}

	@PostMapping("/updatecourse")
	public String updateCourse(@ModelAttribute("course") CourseModel courseModel) {
		LOG.info("Call: updatecourse() ----  with PARAMS: " + courseModel.toString());
		courseService.updateCourse(courseModel);
		return "redirect:/courses/listcourses";
	}

}
