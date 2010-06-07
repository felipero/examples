package net.fratech.frasys.domain.repositories;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
//import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import net.fratech.frasys.domain.Item;
import net.fratech.frasys.domain.Iteration;
import net.fratech.frasys.domain.Project;
import net.fratech.frasys.domain.Task;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestProjectRepository {

	private static ProjectRepository repository;
	private static ApplicationContext ctx;

	@Before
	public void prepare() throws Exception {
		reset();
		ctx = new ClassPathXmlApplicationContext(new String[] {"applicationContext.xml", "testDomainContext.xml" });
		repository = (ProjectRepository) ctx.getBean("projectRepository");
	}

	@After
	public void reset() throws Exception {
		EntityManager em = Persistence.createEntityManagerFactory("frasys").createEntityManager();
		em.getTransaction().begin();
		Query query = em.createNativeQuery("ALTER SEQUENCE frasys.hibernate_sequence RESTART WITH 1;");
		query.executeUpdate();
		em.createNativeQuery("DELETE FROM FRASYS.TASK").executeUpdate();
		em.createNativeQuery("DELETE FROM FRASYS.ITEM").executeUpdate();
		em.createNativeQuery("DELETE FROM FRASYS.ITERATION").executeUpdate();
		em.createNativeQuery("DELETE FROM FRASYS.PROJECT").executeUpdate();
		em.getTransaction().commit();
		em.close();
	}

	private Project getProject() {
		return (Project) ctx.getBean("projectExample");
	}
	
	@Test
	public void saveACompleteProject(){
		Project p = createCompleteProject();
		p = repository.save(p);
		assertNotNull(p);
		assertNotSame(0, p.getId());
		
		Project p2 = repository.withId(p.getId());
		assertNotNull(p2);
		
		List<Iteration> iters = p2.getIterations();
        assertEquals(5, iters.size());
        for (Iteration iter : iters) {
            List<Item> itens = iter.getItens();
            assertEquals(7, itens.size());
            for (Item item : itens) {
                List<Task> tasks = item.getTasks();
                assertEquals(10, tasks.size());
            }
        }
        
        testGetNextIdFor();
        
        repository.close();
	}

	@Test
	public void testBehavior() {
		Project p = testSaveNew();
		testSaveManaged(p);
		testSaveUpdate();
		testWithId();
		testAllProjects();
		testRemove();
		testRemoveManaged(p);
		repository.close();
	}

	public Project testSaveNew() {
		Project p = getProject();
		p = repository.save(p);
		assertNotNull(p);
		assertEquals(1, p.getId());
		return p;
	}

	private void testSaveManaged(Project p) {
		assertNotSame("Fratech Office", p.getLocation());
		p.setLocation("Fratech Office");
		p = repository.save(p);
		assertEquals("Fratech Office", p.getLocation());
	}

	private void testSaveUpdate() {
		Project p2 = getProject();
		p2.setLocation("Location do Projeto 1");
		p2.setId(1);
		p2 = repository.save(p2);
		assertNotNull(p2);
		assertEquals("Location do Projeto 1", p2.getLocation());
		assertEquals(1, p2.getId());
	}

	private void testWithId() {
		Project p = repository.withId(1);
		assertNotNull(p);
		assertEquals("Location do Projeto 1", p.getLocation());
	}
	
	private void testAllProjects(){
		Project p2 = getProject();
		p2.setLocation("Location do Projeto 2");
		p2 = repository.save(p2);
		assertNotNull(p2);
		
		List<Project> projects = repository.allProjects();
		assertNotNull(projects);
		assertEquals(2, projects.size());
		assertEquals("Location do Projeto 2", projects.get(1).getLocation());
		assertEquals("Location do Projeto 1", projects.get(0).getLocation());
	}
	
	private void testRemove(){
		Project p = getProject();
		p.setId(2);
		repository.remove(p);
		assertNull(repository.withId(2));
	}
	
	private void testRemoveManaged(Project p){
		repository.remove(p);
		assertNull(repository.withId(p.getId()));
	}
	
	public void testGetNextIdFor(){
		int id = repository.getNextIdFor(new Iteration());
		assertNotSame(id, 0);
		
		id = repository.getNextIdFor(new Item());
		assertNotSame(id, 0);
		
		id = repository.getNextIdFor(new Task());
		assertNotSame(id, 0);
	}
	
	private Project createCompleteProject() {
		Project p = getProject();
		p.setName("Complete Project");
		
		List<Iteration> iters = new ArrayList<Iteration>();
		
		for(int i = 0; i < 5 ; i++){
			Iteration iter = (Iteration) ctx.getBean("iterationExample");
            iter.setStartDate(new Date());
            iter.setEndDate(new Date());
            iter.setName(iter.getName() + " " + i);
            iter.setId(i + 1);
            iter.setProject(p);
            
            List<Item> items = new ArrayList<Item>();
            for(int j = 0 ; j < 7 ; j++){
            	Item item = (Item) ctx.getBean("itemExample");
            	item.setDescription(item.getDescription() + " " + i + 1 + j + 1);
                item.setIteration(iter);
                String idItem = ""+i + 1 + j + 3;
                item.setId(Integer.valueOf(idItem));
                
                List<Task> tasks = new ArrayList<Task>();
                for(int k = 0 ; k < 10 ; k++){
                	Task task = (Task) ctx.getBean("taskExample");
                    task.setItem(item);
                    task.setName(task.getName() + "" + i + 1 + j + 1 + k + 1);
                    String idTask = ""+i + 1 + j + 1 + k + 1;
                    task.setId(Integer.valueOf(idTask));
                    
                    tasks.add(task);
                }
                item.setTasks(tasks);
                items.add(item);
            }
            iter.setItens(items);
            iters.add(iter);
		}
		
		p.setIterations(iters);
		
		List<Iteration> iterations = p.getIterations();
        assertNotNull(iterations);
        assertEquals(iters.size(), iterations.size());

        for (Iteration iter : iterations) {
            List<Item> itens = iter.getItens();
            assertEquals(7, itens.size());
            for (Item item : itens) {
                List<Task> tasks = item.getTasks();
                assertEquals(10, tasks.size());
            }
        }
		
		return p;
	}

}
