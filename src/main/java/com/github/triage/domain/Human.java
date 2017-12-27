package com.github.triage.domain;

import java.util.LinkedList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.triage.processors.Diagnosis;

public class Human {

	private String fullName;
	private int health;
	private double blood;
	private List<Traumable> traumas = new LinkedList<Traumable>();
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

	public double getBlood() {
		return blood;
	}

	public void setBlood(double blood) {
		this.blood = blood;
	}

	public Human clone() {
		Human human = new Human();
		human.setFullName(this.fullName);
		human.setHealth(this.health);
		human.setBlood(this.blood);
		return human;
	}

	public void addTraumas(Traumable trauma) {
		traumas.add(trauma);
	}

	@JsonIgnore
	public List<Traumable> getTraumasList() {
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