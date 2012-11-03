package org.drools.planner.RepartitionIntervention.domain;

import org.drools.planner.api.domain.entity.PlanningEntity;
import org.drools.planner.api.domain.variable.PlanningVariable;
import org.drools.planner.api.domain.variable.ValueRange;
import org.drools.planner.api.domain.variable.ValueRangeType;

//############################################################################
// Classe qui change pendant la phase d'optimisation. C’est une classe qui n’est pas figée.
//############################################################################

@PlanningEntity
public class Intervention {

	public int typeIntervenantDemande;
	public int dureeInterventionDemande;

	private Intervenant intervenant;

	// constructors
	public Intervention() {
	}

	public Intervention(int typeIntervenantDemande, int dureeInterventionDemande) {
		this.typeIntervenantDemande = typeIntervenantDemande;
		this.dureeInterventionDemande = dureeInterventionDemande;
	}

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

	// --------------------------------------------------------------------------------------
	// Les valeurs que Drools va choisir pour l'attribut Intervenant vont
	// provenir de la méthode
	// getListIntervenants issue de la classe implémentant la Solution du
	// problème. Cette méthode retourne une liste d'intervenants
	// (cf.@ValueRange)
	// -------------------------------------------------------------------------------------

	@PlanningVariable
	@ValueRange(type = ValueRangeType.FROM_SOLUTION_PROPERTY, solutionProperty = "listeIntervenants")
	public Intervenant getIntervenant() {
		return intervenant;
	}

	public void setIntervenant(Intervenant intervenant) {
		this.intervenant = intervenant;
	}

	// Méthode utilisée par la classe RepartirIntervention
	
	public Intervention clone() {
		Intervention clone = new Intervention(typeIntervenantDemande, dureeInterventionDemande);
		clone.typeIntervenantDemande = typeIntervenantDemande;
		clone.intervenant = intervenant;
		return clone;
	}

	// etiquetage intervention
	public String getLabel() {
		return "Intervenant requis: " + typeIntervenantDemande
				+ " durée requise: " + dureeInterventionDemande
				+ " heures ";
	}
}
