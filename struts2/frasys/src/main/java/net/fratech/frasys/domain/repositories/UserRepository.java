package net.fratech.frasys.domain.repositories;

import java.util.List;

import net.fratech.frasys.domain.User;

public interface UserRepository {
	
	public User save(User u);
	public void remove(User u);
    public User userWithId(int id);
    public User userWithLogin(String login, String password);
    public List<User> allUsers();

}
