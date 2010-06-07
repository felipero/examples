package net.fratech.frasys.infrastructure;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.NoResultException;

import net.fratech.frasys.domain.User;
import net.fratech.frasys.domain.repositories.UserRepository;
import net.fratech.frasys.infrastructure.daos.DAO;

public class UserDecorator implements UserRepository {

	private DAO<User, Integer> dao;

	public List<User> allUsers() {
		return dao.list();
	}

	public void remove(User u) {
		dao.remove(u);
	}

	public User save(User u) {
		if (u.getId() != 0) {
			return dao.merge(u);
		}
		dao.persist(u);
		return u;
	}

	public User userWithId(int id) {
		return dao.find(id);
	}

	public User userWithLogin(String login, String password) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("login", login);
		params.put("password", password);
		try {
			return dao.getByNamedQuery("User.getByLogin", params);
		} catch (NoResultException nre) {
			return null;
		}
	}

	public void setDao(DAO<User, Integer> dao) {
		this.dao = dao;
	}

}
