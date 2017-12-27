package com.github.triage.processors;

import com.github.triage.domain.Human;
import com.github.triage.domain.Traumable;

public class Diagnosis {

	private Human human;

	public Diagnosis(Human human) {
		this.human = human;
	}

	public String makeDiagnosis() {
		StringBuilder diagnosis = new StringBuilder();
		for (Traumable trauma : human.getTraumasList()) {
			human = trauma.process(human);
		}
		if (human.getHealth() == 1000) {
			diagnosis.append("Human have a lot of life.");
		}
		if (human.getHealth() >= 500) {
			diagnosis.append("Human have a half of life, provide some help.");
		}
		if (human.getHealth() <= 0) {
			diagnosis.append("Human is dead (¬▂¬).");
		}
		diagnosis.append("\n Human History:\n ");
		for (String healthHistory : human.getHealthHistory()) {
			diagnosis.append(healthHistory);
		}
		return diagnosis.toString();
	}

}