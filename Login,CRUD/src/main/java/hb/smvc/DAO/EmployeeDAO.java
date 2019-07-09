package hb.smvc.DAO;
import java.util.List;


import hb.smvc.Model.*;

public interface EmployeeDAO {
	
		
	public void addEmployee(Employee employee);
	public List<Employee> getAllEmployees();
	public void deleteEmployee(Integer employeeId);
	public Employee updateEmployee(Employee employee);
	public Employee getEmployee(int employeeId);
	public String login(String name,String password);
	 public List<Employee> checkEmployee(String name);
	 public boolean blockEmployee(String name);
	 public boolean checkAccount(String name);
}
