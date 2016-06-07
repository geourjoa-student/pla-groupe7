package jeu;

import automate.Automate;

public abstract class Personnage {

	protected Case caseSousLeJoueur;

	protected int pointsDeVie;

	protected Joueur proprietaire;

	protected Automate comportement;

	public Joueur getJoueur() {
		return proprietaire;
	}

	public Joueur getProprietaire() {
		return proprietaire;
	}

	public void allerADroite() {

		if (!caseSousLeJoueur.getCaseADroite().joueurPresent()) {
			caseSousLeJoueur.retirerPersonnagePresent();
			caseSousLeJoueur = caseSousLeJoueur.getCaseADroite();
			caseSousLeJoueur.placerPersonnage(this);
		}
	}

	public void allerAGauche() {
		if (!caseSousLeJoueur.getCaseAGauche().joueurPresent()) {
			caseSousLeJoueur.retirerPersonnagePresent();
			caseSousLeJoueur = caseSousLeJoueur.getCaseAGauche();
			caseSousLeJoueur.placerPersonnage(this);
		}
	}

	public void allerEnBas() {
		if (!caseSousLeJoueur.getCaseEnBas().joueurPresent()) {
			caseSousLeJoueur.retirerPersonnagePresent();
			caseSousLeJoueur = caseSousLeJoueur.getCaseEnBas();
			caseSousLeJoueur.placerPersonnage(this);
		}
	}

	public void allerEnHaut() {
		if (!caseSousLeJoueur.getCaseEnHaut().joueurPresent()) {
			caseSousLeJoueur.retirerPersonnagePresent();
			caseSousLeJoueur = caseSousLeJoueur.getCaseEnHaut();
			caseSousLeJoueur.placerPersonnage(this);
		}
	}

	@Override
	public String toString() {

		return proprietaire.getNom() + " : " + getClass().getSimpleName() + " : " + pointsDeVie + " : ("
				+ caseSousLeJoueur.getPositionH() + "," + caseSousLeJoueur.getPositionL() + ")";
	}

}
