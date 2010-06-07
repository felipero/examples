package net.fratech.frasys.domain.repositories;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import net.fratech.frasys.domain.User;
import net.fratech.frasys.domain.UserRole;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUserRepository {

	private static UserRepository repository;
	private static ApplicationContext ctx;

	@BeforeClass
	public static void prepare() {
		reset();
		ctx = new ClassPathXmlApplicationContext(new String[] {
				"applicationContext.xml", "testDomainContext.xml" });
		repository = (UserRepository) ctx.getBean("userRepository");
	}
	
	@AfterClass
	public static void reset(){
		EntityManager em = Persistence.createEntityManagerFactory("frasys").createEntityManager();
        em.getTransaction().begin();
        em.createNativeQuery("ALTER SEQUENCE frasys.resource_id_seq RESTART WITH 10;").executeUpdate();
        em.createNativeQuery("DELETE FROM FRASYS.USER").executeUpdate();
        em.getTransaction().commit();
        em.close();
	}

	private User getUser() {
		return (User) ctx.getBean("userExample");
	}

	@Test
	public void success() {
		User user = saveNewUser();
		saveManaged(user);
		saveUpdate();
		saveAnotherUser();
		userWithId();
		userWithLogin();
		allUsers();
		remove();
		removeManaged(user);
	}

	private User saveNewUser() {
		User user = getUser();
		repository.save(user);
		assertNotNull(user);
		assertEquals(10, user.getId());
		assertEquals("Usuário", user.getName());
		return user;
	}

	private void saveManaged(User user) {
		user.setName("User");
		user = repository.save(user);
		assertEquals("User", user.getName());
	}

	private void saveUpdate() {
		User u3 = repository.userWithId(10);
		u3.setName("User 1");
		u3.setLogin("loginUser1");
		u3 = repository.save(u3);
		assertNotNull(u3);
		assertEquals(10, u3.getId());
	}

	private void saveAnotherUser() {
		User u2 = getUser();
		u2.setName("User 2");
		u2.setLogin("loginUser2");
		u2 = repository.save(u2);
		assertEquals(20, u2.getId());
	}

	private void userWithId() {
		User u = repository.userWithId(20);
		assertNotNull(u);
		assertEquals("User 2", u.getName());
		assertEquals("SBO", u.getAddress().getCity());
		assertEquals("SP", u.getAddress().getState());
	}

	private void userWithLogin() {
		User u = repository.userWithLogin("loginUser1", "password");
		assertNotNull(u);
		assertEquals(10, u.getId());
		assertEquals(UserRole.ADMIN, u.getRole());
		assertEquals("password", u.getPassword());
	}

	private void allUsers() {
		List<User> users = repository.allUsers();
		assertNotNull(users);
		assertEquals(2, users.size());
		assertEquals("User 2", users.get(1).getName());
		assertEquals("User 1", users.get(0).getName());
	}
	
	private void remove(){
		User u = repository.userWithId(20);
		repository.remove(u);
		assertNull(repository.userWithId(20));
	}
	
	private void removeManaged(User u){
		repository.remove(u);
		assertNull(repository.userWithId(u.getId()));
	}
}
