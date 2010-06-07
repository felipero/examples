package net.fratech.frasys.view.actions;

import net.fratech.frasys.domain.User;
import net.fratech.frasys.domain.repositories.UserRepository;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven {

	private UserRepository repository;
	private User user;

	// Este loco de codigo será executado no construtor logo após a chamada de
	// super().
	{
		user = user == null ? new User() : user;
	}

	public String signIn(){
		
		if(!user.isElegibleForLogin()){
			addFieldError("login", "Please, type a login!");
			return INPUT;
		}
		
		user = repository.userWithLogin(user.getLogin(), user.getPassword());
		if(user == null){
			addFieldError("login", "User Not Found!");
			return INPUT;
		}
		
		return "logged";
	}

	public User getModel() {
		return user;
	}

	public void setRepository(UserRepository repository) {
		this.repository = repository;
	}

}
