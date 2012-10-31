package org.drools.planner.RepartionIntervention.domain;

import org.drools.planner.api.domain.entity.PlanningEntity;
import org.drools.planner.api.domain.variable.PlanningVariable;
import org.drools.planner.api.domain.variable.ValueRange;
import org.drools.planner.api.domain.variable.ValueRangeType;

//############################################################################
// Classe qui change pendant la phase de plannification. C’est une classe qui n’est pas figée.
//############################################################################

@PlanningEntity
public class Intervention {
	private int typeIntervenantDemande;
	private int dureeInterventionDemande;

	private Intervenant intervenant;

	
	// getters+setters

	public int getTypeIntervenantDemande() {
		return typeIntervenantDemande;
	}

	public void setTypeIntervenantDemande(int typeIntervenantDemande) {
		this.typeIntervenantDemande = typeIntervenantDemande;
	}

	public int getDureeInterventionDemande() {
		return dureeInterventionDemande;
	}

	public void setDureeInterventionDemande(int dureeInterventionDemande) {
		this.dureeInterventionDemande = dureeInterventionDemande;
	}

	// Les valeurs prises par l'attribut Intervenant proviennent de la méthode
	// getIntervenantList issue de la classe implémentant la Solution du problème
	@PlanningVariable
	@ValueRange(type = ValueRangeType.FROM_SOLUTION_PROPERTY, solutionProperty = "Liste_Intervenants")
	public Intervenant getIntervenant() {
		return intervenant;
	}

	public void setIntervenant(Intervenant intervenant) {
		this.intervenant = intervenant;
	}

	//Méthode clone appelée par l'algorithme de résolution: sert à cloner une solution qu'elle
	//en rencontre une meilleure
	public Intervention clone() {
		Intervention clone = new Intervention();
		clone.typeIntervenantDemande = typeIntervenantDemande;
		clone.intervenant = intervenant;
		return clone;
	}

	
	//etiquetage intervention
	public String getLabel() {
		return "Ce qu'on demande, comme intervenant " + typeIntervenantDemande + ", comme durée requise: " + intervenant + " heures ";
		}
}
