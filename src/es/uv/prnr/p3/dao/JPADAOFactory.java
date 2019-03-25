package es.uv.prnr.p3.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPADAOFactory extends DAOFactory {

	private EntityManager getEntityManager(){
		EntityManagerFactory emf =
				Persistence.createEntityManagerFactory("acmeEmployees");
		return emf.createEntityManager();
	}
	
	@Override
	public EmployeeDAO getEmployeeDAO() {
		return new EmployeeDAOImpl(getEntityManager());
	}
	
	@Override
	public ProjectDAO getProjectDAO() {
		return new ProjectDAOImpl(getEntityManager());
	}

}
