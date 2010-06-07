package net.fratech.frasys.domain;

import javax.persistence.Embeddable;

@Embeddable
public class Address {

	private String street;
	private String city;
	private String state;

	public final String getStreet() {
		return street;
	}

	public final void setStreet(String street) {
		this.street = street;
	}

	public final String getCity() {
		return city;
	}

	public final void setCity(String city) {
		this.city = city;
	}

	public final String getState() {
		return state;
	}

	public final void setState(String state) {
		this.state = state;
	}

}
