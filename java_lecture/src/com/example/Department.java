package com.example;

import java.io.Serializable;

public class Department implements Serializable {
	private String name;
	private Employee leader;

	@Override
	public String toString() {
		return "Department [name=" + name + ", leader=" + leader + "]";
	}

	public Department(String name, Employee leader) {
		super();
		this.name = name;
		this.leader = leader;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Employee getLeader() {
		return leader;
	}

	public void setLeader(Employee leader) {
		this.leader = leader;
	}

}
