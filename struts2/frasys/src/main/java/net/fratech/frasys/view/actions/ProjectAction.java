package net.fratech.frasys.view.actions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import net.fratech.frasys.domain.Item;
import net.fratech.frasys.domain.Iteration;
import net.fratech.frasys.domain.Project;
import net.fratech.frasys.domain.Status;
import net.fratech.frasys.domain.Task;
import net.fratech.frasys.domain.repositories.ProjectRepository;

public class ProjectAction {

	private ProjectRepository repository;
	private Project project;
	private Iteration iteration;
	private String startDate;
	private String endDate;
	private String lastDate;
	private Item item;
	private Task task;
	private List<Project> projects;
	private List<Iteration> iterations;
	private List<Item> itens;
	private List<Task> tasks;
	
	// This block will be exceuted with the constructor
	{
		iteration = iteration == null ? new Iteration() : iteration;
		item = item == null ? new Item() : item;
		task = task == null ? new Task() : task;
	}

	public String show(){
		String result = "show";
		
		project = repository.withId(project.getId());
		iterations = project.getIterations();
		
		if(iteration != null && iteration.getId() > 0){
			iteration = project.iteration(iteration.getId());
			itens = iteration.getItens();
			result = "showIteration";
		}
		
		if (item != null && item.getId() > 0) {
            item = iteration.item(item.getId());
            tasks = item.getTasks();
            result = "showItem";
        }
		
		if (task != null && task.getId() > 0) {
            task = item.task(task.getId());
            result = "showTask";
        }
		
		return result;
	}
	
	public String list(){
		projects = repository.allProjects();
		return "list";
	}
	
	public String iterations(){
		if(project != null && project.getId() > 0){
			return show();
		}
		
		iterations = repository.allIterations();
		return "listIterations";
	}
	
	public String itens(){
		if(iteration != null && project != null && iteration.getId() > 0)
            return show();

        itens = repository.allItens();
        return "listItens";
	}
	
	public String tasks(){
		if(item != null && iteration != null && project != null && item.getId() > 0)
            return show();

        tasks = repository.allTasks();
        return "listTasks";
	}
	
	public String add() {
		project.setLastDate(parseDate(lastDate));
		project = repository.save(project);
		return "addIteration";
	}

	public String addIteration() throws Exception {
		project = repository.withId(project.getId());
		iteration.setProject(project);
		iteration.setStartDate(parseDate(startDate));
		iteration.setEndDate(parseDate(endDate));
		iteration.setId(repository.getNextIdFor(iteration));
		project.addIteration(iteration);
		project = repository.save(project);
		return "addItem";
	}

	public String addItem() throws Exception {
		project = repository.withId(project.getId());
		item.setId(repository.getNextIdFor(item));
		project.addItemTo(iteration, item);
		project = repository.save(project);
		return "addTask";
	}

	public String addTask() throws Exception {
		project = repository.withId(project.getId());
		task.setId(repository.getNextIdFor(task));
		task.setStatus(Status.TODO);
		project.addTaskTo(iteration, item, task);
		project = repository.save(project);
		return "success";
	}

	private Date parseDate(String source) {
		Date date;
		try {
			date = new SimpleDateFormat("dd/MM/yyyy").parse(source);
		} catch (ParseException e) {
			date = new Date();
			e.printStackTrace();
		}
		return date;
	}
	
	public static boolean isUser(String role){
		HttpServletRequest request = ServletActionContext.getRequest();
		return request.isUserInRole(role);
	}

	public final ProjectRepository getRepository() {
		return repository;
	}
	
	public final List<Project> getProjects() {
		return projects;
	}

	public final List<Iteration> getIterations() {
		return iterations;
	}

	public final List<Item> getItens() {
		return itens;
	}

	public final List<Task> getTasks() {
		return tasks;
	}

	public final Project getProject() {
		return project;
	}

	public final void setProject(Project project) {
		this.project = project;
	}

	public Iteration getIteration() {
		return iteration;
	}

	public void setIteration(Iteration iteration) {
		this.iteration = iteration;
	}

	public final String getStartDate() {
		return startDate;
	}

	public final void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public final String getEndDate() {
		return endDate;
	}

	public final void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public final String getLastDate() {
		return lastDate;
	}

	public final void setLastDate(String lastDate) {
		this.lastDate = lastDate;
	}

	public final void setRepository(ProjectRepository repository) {
		this.repository = repository;
	}

	public final Item getItem() {
		return item;
	}

	public final void setItem(Item item) {
		this.item = item;
	}

	public final Task getTask() {
		return task;
	}

	public final void setTask(Task task) {
		this.task = task;
	}

}
