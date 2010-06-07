package net.fratech.frasys.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Project implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String description;
	private Date lastDate;
	private String location;
	
	@OneToMany(mappedBy = "project", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Iteration> iterations;

	public void addIteration(Iteration iteration) {
		this.iterations.add(iteration);
	}
	
	public final int getId() {
		return id;
	}

	public final void setId(int id) {
		this.id = id;
	}

	public final String getName() {
		return name;
	}

	public final void setName(String name) {
		this.name = name;
	}

	public final String getDescription() {
		return description;
	}

	public final void setDescription(String description) {
		this.description = description;
	}

	public final Date getLastDate() {
		return lastDate;
	}

	public final void setLastDate(Date lastDate) {
		this.lastDate = lastDate;
	}

	public final String getLocation() {
		return location;
	}

	public final void setLocation(String location) {
		this.location = location;
	}

	public final List<Iteration> getIterations() {
		return iterations;
	}

	public final void setIterations(List<Iteration> iterations) {
		this.iterations = iterations;
	}

	public void addItemTo(Iteration iter, Item item) throws Exception {
		if (iter == null)
            throw new Exception("Iteration does not exist!");
		
		iter = iteration(iter.getId());
		item.setIteration(iter);
		iter.addItem(item);
	}

	public Iteration iteration(int id) {
		for (Iteration iter : iterations)
            if (iter.getId() == id)
                return iter;
        return null;
	}

	public void addTaskTo(Iteration iter, Item item, Task task) throws Exception {
		iter = iteration(iter.getId());
        if (iter == null)
            throw new Exception("Iteration does not exist!");
        item = iter.item(item.getId());
        if (item == null)
            throw new Exception("Item does not exist!");
        task.setItem(item);
        item.addTask(task);
	}

}
