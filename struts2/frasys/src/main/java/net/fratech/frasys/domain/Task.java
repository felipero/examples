package net.fratech.frasys.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries(
		@NamedQuery(name="Task.getLastId", query="SELECT t FROM Task t where t.id = (select MAX(t.id) from Task t)")
)
public class Task {
	
	@Id
	private int id;
	private String name;
	private int resource;
	
	@Enumerated(value = EnumType.STRING)
	private Status status;
	private String location;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="itemId", referencedColumnName="id")
	private Item item;
	
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
	public final int getResource() {
		return resource;
	}
	public final void setResource(int resource) {
		this.resource = resource;
	}
	public final Status getStatus() {
		return status;
	}
	public final void setStatus(Status status) {
		this.status = status;
	}
	public final String getLocation() {
		return location;
	}
	public final void setLocation(String location) {
		this.location = location;
	}
	public final Item getItem() {
		return item;
	}
	public final void setItem(Item item) {
		this.item = item;
	}
	
}
