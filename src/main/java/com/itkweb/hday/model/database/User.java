package com.itkweb.hday.model.database;

import java.util.Set;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class User {

	@Id
	@GeneratedValue
	@JsonProperty("userId")
	private Long id;

	private String login;

	@JsonIgnore
	private String password;

	@ManyToOne
	@JsonProperty("farm")
	private Set<Farm> farms;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Farm> getFarms() {
		return farms;
	}

	public void setFarms(Set<Farm> farms) {
		this.farms = farms;
	}

}
