package jeu;

import automate.Automate;

public class Homme extends Personnage{
	
	public Homme(Joueur joueur, Case caseSousLeJoueur, Automate comportement) {
		this.caseSousLeJoueur=caseSousLeJoueur;
		caseSousLeJoueur.placerPersonnage(this);
		proprietaire=joueur;	
		pointsDeVie = 50; // TODO Valeurs arbitraires
		force=10;
		this.comportement=comportement;//TODO automate
	}

}
