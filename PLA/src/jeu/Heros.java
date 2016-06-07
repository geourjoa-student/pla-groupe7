package jeu;

public class Heros extends Personnage{

	public Heros(Joueur joueur, int x, int y) {
		positionH=x;
		positionL=y;
		proprietaire=joueur;
		pointsDeVie = 100;
		comportement=null;//TODO automate
	}

}
