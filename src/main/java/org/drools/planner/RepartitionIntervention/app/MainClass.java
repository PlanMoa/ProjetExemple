package org.drools.planner.RepartitionIntervention.app;

import java.util.ArrayList;
import java.util.List;

import org.drools.planner.RepartitionIntervention.domain.Intervenant;
import org.drools.planner.RepartitionIntervention.domain.Intervention;
import org.drools.planner.RepartitionIntervention.domain.RepartirIntervention;
import org.drools.planner.config.SolverFactory;
import org.drools.planner.config.XmlSolverFactory;
import org.drools.planner.core.Solver;

public class MainClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// Build the Solver
		SolverFactory solverFactory = new XmlSolverFactory(
				"/org/drools/planner/RepartitionIntervention/solver/SolverConfiguration.xml");
		Solver solver = solverFactory.buildSolver();

		// Create randomly 5 "intervenants"

		List<Intervenant> intervenants = new ArrayList<Intervenant>();
		intervenants.add(new Intervenant(1, 1 + (int) (Math.random() * 40)));
		intervenants.add(new Intervenant(2, 1 + (int) (Math.random() * 40)));
		intervenants.add(new Intervenant(3, 1 + (int) (Math.random() * 40)));
		intervenants.add(new Intervenant(4, 1 + (int) (Math.random() * 40)));
		intervenants.add(new Intervenant(5, 1 + (int) (Math.random() * 40)));

		// Create randomly 15 "interventions 
		// les durées d'interventions requises sont comprises entre 5 et 10 heures)"

		List<Intervention> interventions = new ArrayList<Intervention>();
		interventions.add(new Intervention(1 + (int) (Math.random() * 5),
				5 + (int) (Math.random() * ((10 - 5) + 1))));
		interventions.add(new Intervention(1 + (int) (Math.random() * 5),
				5 + (int) (Math.random() * ((10 - 5) + 1))));
		interventions.add(new Intervention(1 + (int) (Math.random() * 5),
				5 + (int) (Math.random() * ((10 - 5) + 1))));
		interventions.add(new Intervention(1 + (int) (Math.random() * 5),
				5 + (int) (Math.random() * ((10 - 5) + 1))));
		interventions.add(new Intervention(1 + (int) (Math.random() * 5),
				5 + (int) (Math.random() * ((10 - 5) + 1))));
		interventions.add(new Intervention(1 + (int) (Math.random() * 5),
				5 + (int) (Math.random() * ((10 - 5) + 1))));
		interventions.add(new Intervention(1 + (int) (Math.random() * 5),
				5 + (int) (Math.random() * ((10 - 5) + 1))));
		interventions.add(new Intervention(1 + (int) (Math.random() * 5),
				5 + (int) (Math.random() * ((10 - 5) + 1))));
		interventions.add(new Intervention(1 + (int) (Math.random() * 5),
				5 + (int) (Math.random() * ((10 - 5) + 1))));
		interventions.add(new Intervention(1 + (int) (Math.random() * 5),
				5 + (int) (Math.random() * ((10 - 5) + 1))));
		interventions.add(new Intervention(1 + (int) (Math.random() * 5),
				5 + (int) (Math.random() * ((10 - 5) + 1))));
		interventions.add(new Intervention(1 + (int) (Math.random() * 5),
				5 + (int) (Math.random() * ((10 - 5) + 1))));
		interventions.add(new Intervention(1 + (int) (Math.random() * 5),
				5 + (int) (Math.random() * ((10 - 5) + 1))));
		interventions.add(new Intervention(1 + (int) (Math.random() * 5),
				5 + (int) (Math.random() * ((10 - 5) + 1))));
		interventions.add(new Intervention(1 + (int) (Math.random() * 5),
				5 + (int) (Math.random() * ((10 - 5) + 1))));

		// Load data
		RepartirIntervention unsolvedRepartirIntervention = new RepartirIntervention(
				intervenants, interventions);

		// Solve the problem
		solver.setPlanningProblem(unsolvedRepartirIntervention);
		solver.solve();
		RepartirIntervention solvedRepartirIntervention = (RepartirIntervention) solver
				.getBestSolution();

		// Display the result
		System.out.println("\nRésultat obtenu:\n"
				+ toDisplayString(solvedRepartirIntervention));

	}

	public static String toDisplayString(
			RepartirIntervention repartirIntervention) {
		// construire une chaîne de caractère
		StringBuilder displayString = new StringBuilder();
		for (Intervention intervention : repartirIntervention
				.getListeInterventions()) {
			for (Intervenant intervenant : repartirIntervention
					.getListeIntervenants()) {
				if (intervenant.getTypeIntervenant() == intervention
						.getTypeIntervenantDemande()) {
					// Intervenant intervenant = intervention.getIntervenant();
					displayString
							.append("  ")
							.append(intervenant == null ? null : intervenant
									.getLabel()).append(" -> ")
							.append(intervention.getLabel()).append("\n");
				}
			}
		}
		return displayString.toString();
	}
}