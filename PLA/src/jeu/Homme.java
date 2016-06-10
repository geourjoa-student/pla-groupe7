package jeu;

import automate.Automate;

public abstract class Homme extends Personnage{
	
	public final static int CODE_GUERRIER = 1; 
	public final static int CODE_MOINE = 1; 
	public final static int CODE_PAYSAN = 1; 
	
	public Homme(Joueur joueur, Case caseSousLeJoueur, Automate comportement) {
		this.caseSousLeJoueur=caseSousLeJoueur;
		caseSousLeJoueur.placerPersonnage(this);
		proprietaire=joueur;	
		this.comportement=comportement;//TODO automate
	}

}

