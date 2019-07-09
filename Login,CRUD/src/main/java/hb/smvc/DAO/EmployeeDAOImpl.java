package hb.smvc.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hb.smvc.Model.*;
import org.hibernate.criterion.*;
import org.hibernate.*;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void addEmployee(Employee employee) {
		sessionFactory.getCurrentSession().saveOrUpdate(employee);
	}

	@SuppressWarnings("unchecked")
	public List<Employee> getAllEmployees() {

		/*
		 * return
		 * sessionFactory.getCurrentSession().createQuery("from Employee").list();
		 */
		
		 return sessionFactory.getCurrentSession().createCriteria(Employee.class).list();
		

	}

	@Override
	public void deleteEmployee(Integer employeId) {
		Employee employee = (Employee) sessionFactory.getCurrentSession().load(Employee.class, employeId);
		if (null != employee) {
			this.sessionFactory.getCurrentSession().delete(employee);
		}
	}

	public Employee getEmployee(int empId) {
		System.out.println("test");
		return (Employee) sessionFactory.getCurrentSession().get(Employee.class, empId);
	}

	public Employee updateEmployee(Employee employee) {
		sessionFactory.getCurrentSession().update(employee);
		return employee;
	}

	
	
	
	  @SuppressWarnings("unchecked") 
	  public List<Employee> checkEmployee(String name) { 
		/*
		 * List<Employee> employees = new ArrayList<Employee>();
		 * System.out.println("Inside CheckEmployee Method"); Criteria cri
		 * =sessionFactory.getCurrentSession().createCriteria(Employee.class).add(
		 * Restrictions.like("name", name).ignoreCase()); List<Employee> objlst =
		 * cri.list(); if (objlst.size() > 0){ employees = objlst; } return employees;
		 */
		  
		  System.out.println("Inside checkEmployee Method now\nThe name Entered is " + name);
		  
		  
		  
		  return sessionFactory.getCurrentSession().createCriteria(Employee.class).add(Restrictions.like("name", name).ignoreCase()).list();
	  }
	  
	  
	  
	  public String login(String name, String password) {
		  System.out.println("\n\nInside EmployeeDAOImpl Now");
		  if(!sessionFactory.getCurrentSession().createCriteria(Employee.class).add(Restrictions.like("name", name).ignoreCase()).list().isEmpty()) {
			  System.out.println("\nUsername is Valid,\nChecking whether Password is correct or not");
			  
			  if(!sessionFactory.getCurrentSession().createCriteria(Employee.class).add(Restrictions.like("password", password)).list().isEmpty()) {
				  System.out.println("\nPassword is Correct, Returning TRUE");
				  return "true";
			  }
			  else {
				  System.out.println("\nPassword was False. Returning \"falsePassword\" ");
				  return "falsepassword";
			  }
			  
			  }
		  else {
			  System.out.println("\nUsername was incorrect");
			  return "false";
		  }
		  
	  }
	  
	 //Checking Whether the account is Blocked or Not
	  public boolean checkAccount(String name) {
		  Session session = this.sessionFactory.getCurrentSession();
		  Query query = session.createQuery("select e.status from Employee e where e.name = :name"); 
		  query.setParameter("name", name);
		  List results = query.list();
		  System.out.println("\n\nPrinting the query list now\nThe value stored in results is" + results);
		  if(results.contains("blocked")) {
			  System.out.println("\nThe UserName And Password are True but the account was already BLOCKED");
		  return true;
		  }
		  else {
			  System.out.println("\nThe UserName And Password are True. ");
			  return false;
		  }
	  }
	  

	  //Block the Employee if the Username Was correct
	  //But entered the wrong password for 3 attempts
	  public boolean blockEmployee(String name) {
		  String status = "blocked";
		  Session session = this.sessionFactory.getCurrentSession();
		  Query query = session.createQuery("UPDATE Employee e SET e.status= :status WHERE e.name = :name");
		  query.setParameter("name", name);
		  query.setParameter("status", status);
		  query.executeUpdate();
		  return true;
	  }
	  
	  
}
