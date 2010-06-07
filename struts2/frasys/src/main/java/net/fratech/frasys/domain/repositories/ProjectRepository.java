package net.fratech.frasys.domain.repositories;

import java.util.List;

import net.fratech.frasys.domain.Item;
import net.fratech.frasys.domain.Iteration;
import net.fratech.frasys.domain.Project;
import net.fratech.frasys.domain.Task;

public interface ProjectRepository {
	
	public Project save(Project p);
    public void remove(Project p);
    public Project withId(int id);
    public List<Project> allProjects();
    public void close();
	public int getNextIdFor(Object object);
	public List<Iteration> allIterations();
	public List<Item> allItens();
	public List<Task> allTasks();

}
