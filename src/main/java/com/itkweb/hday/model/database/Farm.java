package com.itkweb.hday.model.database;

import java.util.Set;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

public class Farm {


	@Id
	@GeneratedValue
	private Long id;

	private String name;

	@OneToMany
	private User user;

	@ManyToOne
	private Set<Plot> plots;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<Plot> getPlots() {
		return plots;
	}

	public void setPlots(Set<Plot> plots) {
		this.plots = plots;
	}


}
