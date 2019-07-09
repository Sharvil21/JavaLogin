package hb.smvc.Service;
import hb.smvc.Model.*;
import java.util.List;

import hb.smvc.Model.Employee;

public interface EmployeeService {

	
	public void addEmployee(Employee employee);
	public List<Employee> getAllEmployees();
	public void deleteEmployee(Integer employeeId);
	public Employee updateEmployee(Employee employee);
	public Employee getEmployee(int employeeId);
	public String login(String name,String password);
	public boolean blockEmployee(String name);
	  public List<Employee> checkEmployee(String name);
	  public boolean checkAccount(String name);
	 }
