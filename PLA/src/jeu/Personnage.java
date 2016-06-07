package jeu;

import automate.Automate;

public abstract class Personnage {
	
	protected int positionX;
	
	protected int positionY;
	
	protected int pointsDeVie;
	
	protected Joueur proprietaire;
	
	protected Automate comportement;

	public Joueur getJoueur() { //DOUBLON
		return proprietaire;
	}

	public int getPositionX() {
		return positionX;
	}	

	public int getPositionY() {
		return positionY;
	}

	public Joueur getProprietaire() { //DOUBLON
		return proprietaire;
	}

	public void setPosition(int x, int y){
		positionX=x;
		positionY=y;
	}

	public void allerADroite() { //Tests � faire
		if(positionX == Partie.LARGEUR-1)
			positionX=0;
		else 
			positionX++;
		
	}
	
	public void allerAGauche() {
		if(positionX == 0)
			positionX=Partie.LARGEUR-1;
		else 
			positionX--;
		
	}
	
	public void allerEnBas() {
		if(positionY == Partie.HAUTEUR-1)
			positionY=0;
		else 
			positionY++;
		
	}
	
	public void allerEnHaut() {
		if(positionY == 0)
			positionY=Partie.HAUTEUR-1;
		else 
			positionY--;
		
	}

	

}
