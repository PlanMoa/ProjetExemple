package org.drools.planner.RepartitionIntervention.domain;

public class Intervenant {

	private int typeIntervenant;
	private int dureeIntervention;// durée prévue par semaine jusqu'à 40 heures

	// Constructors
	public Intervenant() {

	}

	public Intervenant(int typeIntervenant, int dureeIntervention) {
		this.typeIntervenant = typeIntervenant;
		this.dureeIntervention = dureeIntervention;
	}

	// getters+setters
	public int getTypeIntervenant() {
		return typeIntervenant;
	}

	public void setTypeIntervenant(int typeIntervenant) {
		this.typeIntervenant = typeIntervenant;
	}

	public int getDureeIntervention() {
		return dureeIntervention;
	}

	public void setDureeIntervention(int dureeIntervention) {
		this.dureeIntervention = dureeIntervention;
	}

	// etiquetage intervenant
	public String getLabel() {
		return "intervenant: " + typeIntervenant + " durée/semaine: "
				+ dureeIntervention + " heures ";

	}

}
