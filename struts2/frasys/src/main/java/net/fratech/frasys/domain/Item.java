package net.fratech.frasys.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries(
		@NamedQuery(name="Item.getLastId", query="SELECT i FROM Item i where i.id = (select MAX(i.id) from Item i)")
)
public class Item {

	@Id
	private int id;
	private String description;
	private int priority;
	
	@OneToMany(mappedBy="item", cascade = CascadeType.ALL)
	private List<Task> tasks;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="iterationId", referencedColumnName="id")
	private Iteration iteration;

	public final int getId() {
		return id;
	}

	public final void setId(int id) {
		this.id = id;
	}

	public final String getDescription() {
		return description;
	}

	public final void setDescription(String description) {
		this.description = description;
	}

	public final int getPriority() {
		return priority;
	}

	public final void setPriority(int priority) {
		this.priority = priority;
	}

	public final List<Task> getTasks() {
		return tasks;
	}

	public final void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public final Iteration getIteration() {
		return iteration;
	}

	public final void setIteration(Iteration iteration) {
		this.iteration = iteration;
	}

	public void addTask(Task task) {
		tasks = tasks == null ? new ArrayList<Task>() : tasks;
		tasks.add(task);
	}

	public Task task(int id) {
		for(Task task : tasks)
			if(task.getId() == id)
				return task;
		return null;
	}

}
