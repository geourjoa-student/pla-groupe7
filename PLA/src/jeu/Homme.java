package jeu;

import automate.Automate;

public abstract class Homme extends Personnage{
	
	public final static int CODE_GUERRIER = 1; 
	public final static int CODE_MOINE = 2; 
	public final static int CODE_PAYSAN = 3; 
	
	public Homme(Joueur joueur, Case caseSousLeJoueur, Automate comportement) {
		this.caseSousLeJoueur=caseSousLeJoueur;
		caseSousLeJoueur.placerPersonnage(this);
		proprietaire=joueur;	
		this.comportement=comportement;//TODO automate
	}

	public Action getAction() {
		Condition
		
	}

}

