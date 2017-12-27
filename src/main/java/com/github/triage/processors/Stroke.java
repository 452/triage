package com.github.triage.processors;

import java.io.Serializable;

import com.github.triage.domain.Human;
import com.github.triage.domain.Traumable;

public class Stroke implements Traumable, Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public Human process(Human human) {
		Human humanWithTrauma = human.clone();
		humanWithTrauma.setHealth(human.getHealth() - 500);
		humanWithTrauma.getHealthHistory().add("Human have stroke -50% of life");
		return humanWithTrauma;
	}

}