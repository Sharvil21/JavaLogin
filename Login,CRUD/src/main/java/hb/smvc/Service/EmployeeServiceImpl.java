package hb.smvc.Service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hb.smvc.DAO.EmployeeDAO;
import hb.smvc.Model.*;


@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
		
	
	@Autowired
	private EmployeeDAO employeeDAO;
	
	@Override
	@Transactional
	public void addEmployee(Employee employee) {
		employeeDAO.addEmployee(employee);
	}
	
	
	@Override
	@Transactional
	public List<Employee> getAllEmployees(){
		return employeeDAO.getAllEmployees();
	}
	
	
	@Override
	@Transactional
	public void deleteEmployee(Integer employeeId) {
		employeeDAO.deleteEmployee(employeeId);
	}
	
	public Employee getEmployee(int empId) {
		return employeeDAO.getEmployee(empId);
	}
	
	
	public Employee updateEmployee(Employee employee) {
		return employeeDAO.updateEmployee(employee);
		
	}
	
	public void setEmployeeDAO(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}
	
	public String login(String name, String password) {
		System.out.println("\n\nInside EmployeeServiceImpl login Method Now\nNow Going into EmployeeDAO.login");
		return employeeDAO.login(name,password);
		
	}
	
	
	  @Override
	  @Transactional 
	  public List<Employee> checkEmployee(String name){ 
		  return employeeDAO.checkEmployee(name);
		  }
	 
	
	
	public boolean blockEmployee(String name) {
		System.out.println("\nInside blockEmployee Method Now");
		return employeeDAO.blockEmployee(name);
	}
	
		public boolean checkAccount(String name) {
			System.out.println("\nInside checkAccount Method now");
			return employeeDAO.checkAccount(name);
		}
			
		
}
