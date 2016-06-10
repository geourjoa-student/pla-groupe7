package jeu;

public class Heros extends Personnage{

	public Heros(Joueur joueur, Case caseSousLeJoueur) {
		this.caseSousLeJoueur=caseSousLeJoueur;
		caseSousLeJoueur.placerPersonnage(this);
		proprietaire=joueur;	
		pointsDeVie = 250; // TODO Valeurs arbitraires
		force=30;
		recolte = 20;
		soin = 50;
		convertir = 20;
		comportement=null;//TODO automate
	}

}
