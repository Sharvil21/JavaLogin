package hb.smvc.DAO;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hb.smvc.Model.Course;
import hb.smvc.Model.Employee;
@Repository
public class CourseDAOImpl implements CourseDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public void addCourse(Course course) {
		sessionFactory.getCurrentSession().saveOrUpdate(course);
	}

	@SuppressWarnings("unchecked")
	public List<Course> getAllCourses(String empName) {

		/*
		 * return
		 * sessionFactory.getCurrentSession().createQuery("from Employee").list();
		 */
		System.out.println("\nInside CourseDAOImpl,\nnow adding hibernate Criteria Restriction\nThe name to be applied for restriction is "+empName);
		  return sessionFactory.getCurrentSession().createCriteria(Course.class).add(Restrictions.like("name", empName)).list();


	}

	@Override
	public void deleteCourse(Integer courseId) {
		Course course = (Course) sessionFactory.getCurrentSession().load(Course.class, courseId);
		if (null != courseId) {
			this.sessionFactory.getCurrentSession().delete(course);
		}
	}

	public Course getCourse(int courseId) {
		System.out.println("test");
		return (Course) sessionFactory.getCurrentSession().get(Course.class, courseId);
	}

	public Course updateCourse(Course course) {
		sessionFactory.getCurrentSession().update(course);
		return course;
	}
}
