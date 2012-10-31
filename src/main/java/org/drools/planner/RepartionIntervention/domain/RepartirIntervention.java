package org.drools.planner.RepartionIntervention.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.drools.planner.core.score.buildin.hardandsoft.HardAndSoftScore;
import org.drools.planner.core.solution.Solution;

//############################################################################
//Implémente l'interface Solution, contient la liste des intervenants et des interventions
//############################################################################
public class RepartirIntervention implements Solution<HardAndSoftScore> {

	private List<Intervenant> Liste_Intervenants;

	private List<Intervention> Liste_Interventions;

	// A Solution requires a score property.
	// The score property is usually typed to the specific Score implementation
	// you use.
	// A HardAndSoftScore is a Score based on hard and soft int constraints.
	// Hard constraints have priority over soft constraints.
	private HardAndSoftScore score;

	// Méthodes à implémenter

	public HardAndSoftScore getScore() {
		return score;
	}

	public void setScore(HardAndSoftScore score) {
		this.score = score;

	}

	// All objects returned by the getProblemFacts() method will be asserted
	// into the Drools working memory, so the score rules can access them.
	// The working memory is where all knowledge is contained, each item of
	// knowledge is called a Fact.
	public Collection<? extends Object> getProblemFacts() {
		List<Object> facts = new ArrayList<Object>();

		facts.addAll(Liste_Intervenants);
		// Do not add planning entities in this method. They are automatically
		// inserted into the Drools working memory
		return facts;
	}

	public Solution<HardAndSoftScore> cloneSolution() {
		RepartirIntervention clone = new RepartirIntervention();
		clone.Liste_Intervenants = Liste_Intervenants;
		//The cloneSolution() method should only deep clone the planning entities
		List<Intervention> clonedListe_Interventions = new ArrayList<Intervention>(
				Liste_Interventions.size());
		for (Intervention intervention : Liste_Interventions) {
			Intervention clonedIntervention = intervention.clone();
			clonedListe_Interventions.add(clonedIntervention);
		}
		clone.Liste_Interventions = clonedListe_Interventions;
		clone.score = score;
		return clone;
	}
}
