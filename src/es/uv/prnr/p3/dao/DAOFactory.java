package es.uv.prnr.p3.dao;

public abstract class DAOFactory {
	
	public enum TYPE {JPA,XML}
	
	// Ejercicio 2: Añadir la recuperación de una clase DAO para la entidad Project

	public abstract EmployeeDAO getEmployeeDAO();
	public abstract ProjectDAO getProjectDAO();
	
	public static DAOFactory getDAOFactory(TYPE t){
		switch(t){
			case JPA:
				return new JPADAOFactory();
			/*case XML:
				// return new XMLDAOFactory();*/
		}
		return null;
	}

}
