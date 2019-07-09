package hb.smvc.Controller;

import hb.smvc.DAO.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import hb.smvc.Model.Course;
import hb.smvc.Model.Employee;
import hb.smvc.Service.CourseService;
import hb.smvc.Service.EmployeeService;
import hb.smvc.Service.EmployeeServiceImpl;
import hb.smvc.DAO.*;

@Controller
public class CourseController {

	

	private static final Logger logger = Logger
			.getLogger(CourseController.class);
	SessionFactory sessionFactory;
	public CourseController() {
		/*
		 * System.out.println("CourseController()");
		 */	}
	
	
	@Autowired
	private CourseService courseService;

	//Show only those courses that that Specific Employee Has registeed for 
	@RequestMapping(value = "/courselist")
	public ModelAndView listCourse(ModelAndView model,HttpServletRequest request) throws IOException {
		/*
		 * System.out.println("\nInside listCourse Method now");
		 */		String name = request.getParameter("name");
		/*
		 * System.out.
		 * println("\nThe name of the Logged iN person whose courses are to be displayed is "
		 * + name);
		 */		/* Map<String, Object> model1 = new HashMap<String, Object>(); */
		
		 List<Course> listCourses = courseService.getAllCourses(name);
		
		 /*
		 * System.out.println("The courses "+name + " has registered for are "+
		 * listCourses);
		 */
		 
		 model.addObject("listCourses", listCourses);
		 model.setViewName("courselist");
		return model;
	}
	
	@RequestMapping(value = "/newCourse", method = RequestMethod.GET)
	public ModelAndView newCourse(ModelAndView model) {
		Course course = new Course();
		model.addObject("course", course);
		model.setViewName("redirect:/");
		return model;
	}
	
	//IGNORE THIS METHOD
	@RequestMapping(value = "/saveCourse", method = RequestMethod.POST)
	public ModelAndView saveCourse(@Valid @ModelAttribute Course course, BindingResult result) {
		
		
		/*
		 * if(result.hasErrors()) { return new ModelAndView("EmployeeForm"); }
		 */
		
		if (course.getName().equals(null)) {
			courseService.addCourse(course);
		} else {
			courseService.updateCourse(course);
		}
		return new ModelAndView("redirect:/");
	}
	
	
	@RequestMapping(value = "/deleteCourse", method = RequestMethod.GET)
	public ModelAndView deleteCourse(HttpServletRequest request) {
		int courseId = Integer.parseInt(request.getParameter("id"));
		courseService.deleteCourse(courseId);
		return new ModelAndView("redirect:/");
	}
	
	
	/*
	 * @RequestMapping(value = "/editCourse", method = RequestMethod.GET) public
	 * ModelAndView editContact(HttpServletRequest request) { int courseId =
	 * Integer.parseInt(request.getParameter("id")); Course course =
	 * courseService.getCourse(courseId); ModelAndView model = new ModelAndView("");
	 * model.addObject("", );
	 * 
	 * return model; }
	 */
	
	
	
	
	
	
	
	
}
