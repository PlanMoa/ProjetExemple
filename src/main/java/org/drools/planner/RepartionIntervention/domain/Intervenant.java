package org.drools.planner.RepartionIntervention.domain;

public class Intervenant {

	private int typeIntervenant;
	private int dureeIntervention;// durée prévue par semaine
	private int prime;

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

	public int getPrime() {
		return prime;
	}

	public void setPrime(int prime) {
		this.prime = prime;
	}

	
	//etiquetage intervenant
	public String getLabel() {
		return "Intervenant: " + typeIntervenant + " Durée/semaine: " + dureeIntervention +" heures. " ;
				
	}

}
