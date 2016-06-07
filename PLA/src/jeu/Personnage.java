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
		caseSousLeJoueur.retirerPersonnagePresent();
		caseSousLeJoueur=caseSousLeJoueur.getCaseADroite();
		caseSousLeJoueur.placerPersonnage(this);
		
	}
	
	public void allerAGauche() {
		caseSousLeJoueur.retirerPersonnagePresent();
		caseSousLeJoueur=caseSousLeJoueur.getCaseAGauche();
		caseSousLeJoueur.placerPersonnage(this);
		
	}
	
	public void allerEnBas() {
		caseSousLeJoueur.retirerPersonnagePresent();
		caseSousLeJoueur=caseSousLeJoueur.getCaseEnBas();
		caseSousLeJoueur.placerPersonnage(this);
		
	}
	
	public void allerEnHaut() {
		caseSousLeJoueur.retirerPersonnagePresent();
		caseSousLeJoueur=caseSousLeJoueur.getCaseEnHaut();
		caseSousLeJoueur.placerPersonnage(this);
		
	}
	
	

	

}
