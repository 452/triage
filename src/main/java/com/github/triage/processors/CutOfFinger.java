package com.github.triage.processors;

import java.io.Serializable;

import com.github.triage.domain.Human;
import com.github.triage.domain.Traumable;

public class CutOfFinger implements Traumable, Serializable {

	private static final long serialVersionUID = 1L;
	private double bleedingSpeedspeed = 0.2;

	@Override
	public Human process(Human human) {
		Human humanWithTrauma = human.clone();
		double currentCountOfBlood = humanWithTrauma.getBlood();
		for (double i = currentCountOfBlood; i >= 50; i--) {
			humanWithTrauma.setBlood(currentCountOfBlood - i);
			// humanWithTrauma.getHealthHistory().add(String.valueOf(i));
		}
		humanWithTrauma.getHealthHistory()
				.add("Human have finger cut and blood in percent: " + humanWithTrauma.getBlood());
		return humanWithTrauma;
	}

}
// private Date startTime = new Date();
// Date currentTime = new Date();
// long difference = currentTime.getTime() - startTime.getTime();
// humanWithTrauma.getHealthHistory().add(String.valueOf(difference));