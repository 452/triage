package com.github.triage.domain;

import java.util.LinkedList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.triage.processors.Diagnosis;

public class Human {

	private String fullName;
	private int health;
	private List<Trauma> traumas = new LinkedList<Trauma>();
	private List<String> healthHistory = new LinkedList<String>();

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public Human clone() {
		Human human = new Human();
		human.setFullName(this.fullName);
		human.setHealth(this.health);
		return human;
	}

	public void addTraumas(Trauma trauma) {
		traumas.add(trauma);
	}

	@JsonIgnore
	public List<Trauma> getTraumasList() {
		return traumas;
	}

	@JsonIgnore 
	public List<String> getHealthHistory() {
		return healthHistory;
	}

	public void setHealthHistory(List<String> healthHistory) {
		this.healthHistory = healthHistory;
	}

	public String getDiagnosis() {
		Diagnosis diagnosis = new Diagnosis(this);
		return diagnosis.makeDiagnosis();
	}
}