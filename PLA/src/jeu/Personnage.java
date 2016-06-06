package jeu;

import automate.Automate;

public abstract class Personnage {
	
	protected int positionX;
	
	protected int positionY;
	
	protected Joueur proprietaire;
	
	protected Automate comportement;

	public abstract void agir(int nouvelleTransition);

	public Joueur getJoueur() {
		return proprietaire;
	}

	public int getPositionX() {
		return positionX;
	}

	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	public int getPositionY() {
		return positionY;
	}

	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}

	public Joueur getProprietaire() {
		return proprietaire;
	}

	

}
