package jeu;

public class Heros extends Personnage{

	public Heros(Joueur joueur, int x, int y) {
		positionX=x;
		positionY=y;
		proprietaire=joueur;
		pointsDeVie = 100;
		comportement=null;//TODO automate
	}

}
