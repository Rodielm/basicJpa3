package es.uv.prnr.p3.dao;

import java.util.List;
import es.uv.prnr.p2.Employee;

public interface EmployeeDAO {
	public Employee getEmployeeById(int id);

	public List<Employee> getEmployees();

	public void createEmployee(Employee e);

	public void delete(Employee e);

	// TODO A�adir m�todos del ejercicio 1

}
