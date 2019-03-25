package es.uv.prnr.p3.dao;

import java.util.List;
import javax.persistence.EntityManager;
import es.uv.prnr.p2.Employee;

public class EmployeeDAOImpl extends DAOImpl<Integer, Employee> implements EmployeeDAO {

	public EmployeeDAOImpl(EntityManager em) {
		super(em, Employee.class);
	}

	public Employee getEmployeeById(int id) {
		return this.getById(id);
	}

	public List<Employee> getEmployees() {
		return this.findAll();
	}

	public void createEmployee(Employee e) {
		this.create(e);
	}

	// Completad metodos a implementar del ejercicio 1
	public void deleteEmployeeById(int id) {
		if (this.deleteById(id)) {
			System.out.println("Registro Borrado");
		} else {
			System.out.println("Resgistro No Borrado");
		}
	}

	public List<Employee> getByFirstName(String firstName) {
		return this.findByCriteria("firstName",firstName);
	}


}
