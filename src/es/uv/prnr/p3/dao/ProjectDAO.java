package es.uv.prnr.p3.dao;

import java.util.List;

import es.uv.prnr.p2.Project;

/**
 * ProjectDAO
 */
public interface ProjectDAO {

    public Project getProjectById(int id);

    public List<Project> getProjects();

    public void createProject(Project p);

    public void delete(Project p);

    public void assignTeam(Project p, int startId, int endId);

}