package net.fratech.frasys.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(schema = "frasys")
@NamedQueries( { @NamedQuery(name = "User.getByLogin", query = "SELECT u FROM User u WHERE u.login = :login and u.password = :password") })
public class User implements Serializable {

	@Id
	@SequenceGenerator(name = "USER_GENERATOR", sequenceName = "resource_id_seq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_GENERATOR")
	private int id;

	@Embedded
	private Address address;

	@Column(nullable = false)
	private String name;

	private String password;

	@Enumerated(value = EnumType.STRING)
	private UserRole role;

	@Column(nullable = false, unique = true)
	private String login;

	public final int getId() {
		return id;
	}

	public final void setId(int id) {
		this.id = id;
	}

	public final Address getAddress() {
		return address;
	}

	public final void setAddress(Address address) {
		this.address = address;
	}

	public final String getName() {
		return name;
	}

	public final void setName(String name) {
		this.name = name;
	}

	public final String getPassword() {
		return password;
	}

	public final void setPassword(String password) {
		this.password = password;
	}

	public final UserRole getRole() {
		return role;
	}

	public final void setRole(UserRole role) {
		this.role = role;
	}

	public final String getLogin() {
		return login;
	}

	public final void setLogin(String login) {
		this.login = login;
	}

	public boolean isElegibleForLogin() {
		return !(this.getLogin() == null || this.getPassword() == null
				|| "".equals(this.getLogin()) || this.getLogin().length() == 0
				|| "".equals(this.getPassword()) || this.getPassword().length() == 0);
	}

}
