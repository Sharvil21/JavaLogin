package hb.smvc.Service;
import hb.smvc.Model.*;

import java.util.List;

import hb.smvc.Model.Employee;

import hb.smvc.Model.Employee;

public interface CourseService {
	
	public void addCourse(Course employee);
	public List<Course> getAllCourses(String empName);
	public void deleteCourse(Integer courseId);
	public Course updateCourse(Course course);
	public Course getCourse(int courseId);
}
