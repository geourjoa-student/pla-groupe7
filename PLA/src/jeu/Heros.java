package jeu;

public class Heros extends Personnage{

	public Heros(Joueur joueur) {
		positionX=0;
		positionY=0;
		proprietaire=joueur;
		pointsDeVie = 100;
		comportement=null;//TODO automate
	}

	

}
