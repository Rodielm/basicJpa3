package es.uv.prnr.p3.dao;

import java.util.List;

import javax.persistence.EntityManager;

import es.uv.prnr.p2.Employee;
import es.uv.prnr.p2.Project;

/**
 * ProjectDAOImpl
 */
public class ProjectDAOImpl extends DAOImpl<Integer, Project> implements ProjectDAO {

    public ProjectDAOImpl(EntityManager em) {
		super(em, Project.class);
	}

    @Override
    public Project getProjectById(int id) {
        return this.getById(id);
    }

    @Override
    public void createProject(Project p) {
        this.create(p);
    }

    @Override
    public List<Project> getProjects() {
        return this.findAll();
    }

    @Override
    public void assignTeam(Project p, int startId, int endId) {
        this.em.getTransaction().begin();
		for (int i = startId; i <= endId; i++) {
			Employee e = new Employee();
			e = this.em.find(Employee.class, i);
			p.addEmployee(e);
		}
		this.em.merge(p);
		this.em.getTransaction().commit();
    }

    
}