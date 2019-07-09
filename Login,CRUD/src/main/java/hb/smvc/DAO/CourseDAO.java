package hb.smvc.DAO;

import java.util.List;

import hb.smvc.Model.Course;
import hb.smvc.Model.Employee;

public interface CourseDAO {
	public void addCourse(Course course);
	public List<Course> getAllCourses(String empName);
	public void deleteCourse(Integer courseId);
	public Course updateCourse(Course course);
	public Course getCourse(int courseId);
}
