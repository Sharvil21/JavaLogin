package hb.smvc.Service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hb.smvc.DAO.CourseDAO;
import hb.smvc.DAO.EmployeeDAO;
import hb.smvc.Model.Course;
import hb.smvc.Model.Employee;
@Service
@Transactional
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseDAO courseDAO;
	
	@Override
	@Transactional
	public void addCourse(Course course) {
		courseDAO.addCourse(course);
	}
	
	
	@Override
	@Transactional
	public List<Course> getAllCourses(String empName){
		return courseDAO.getAllCourses(empName);
	}
	
	
	@Override
	@Transactional
	public void deleteCourse(Integer courseId) {
		courseDAO.deleteCourse(courseId);
	}
	
	public Course getCourse(int courseId) {
		return courseDAO.getCourse(courseId);
	}
	
	
	public Course updateCourse(Course course) {
		return courseDAO.updateCourse(course);
		
	}
	
	public void setCourseDAO(CourseDAO courseDAO) {
		this.courseDAO = courseDAO;
	}
	
	
}

	
	

