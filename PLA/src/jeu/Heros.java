package jeu;

public class Heros extends Personnage{

	public Heros(Joueur joueur, Case caseSousLeJoueur) {
		this.caseSousLeJoueur=caseSousLeJoueur;
		caseSousLeJoueur.placerPersonnage(this);
		proprietaire=joueur;
		pointsDeVie = 100;
		comportement=null;//TODO automate
	}

}
