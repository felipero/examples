package net.fratech.frasys.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries(
		@NamedQuery(name="Iteration.getLastId", query="SELECT i FROM Iteration i where i.id = (select MAX(i.id) from Iteration i)")
)
public class Iteration {

	@Id
	private int id;
	
	@Column(nullable = false)
	private Date startDate;
	@Column(nullable = false)
	private Date endDate;
	private String name;
	
	@OneToMany(mappedBy="iteration", cascade= CascadeType.ALL)
	private List<Item> itens;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="projectId", referencedColumnName="id")
	private Project project;

	public final int getId() {
		return id;
	}

	public final void setId(int id) {
		this.id = id;
	}

	public final Date getStartDate() {
		return startDate;
	}

	public final void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public final Date getEndDate() {
		return endDate;
	}

	public final void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public final String getName() {
		return name;
	}

	public final void setName(String name) {
		this.name = name;
	}

	public final List<Item> getItens() {
		return itens;
	}

	public final void setItens(List<Item> itens) {
		this.itens = itens;
	}

	public final Project getProject() {
		return project;
	}

	public final void setProject(Project project) {
		this.project = project;
	}

	public void addItem(Item item) {
		itens = itens == null ? new ArrayList<Item>() : itens;
        itens.add(item);
	}

	public Item item(int id) {
		for (Item item : itens)
            if (item.getId() == id)
                return item;
        return null;
	}

}
