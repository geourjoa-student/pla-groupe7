package jeu;

import automate.Automate;

public abstract class Personnage {
	
	protected int positionH;
	
	protected int positionL;
	
	protected int pointsDeVie;
	
	protected Joueur proprietaire;
	
	protected Automate comportement;

	public Joueur getJoueur() { //DOUBLON
		return proprietaire;
	}

	public int getPositionH() {
		return positionH;
	}	

	public int getPositionL() {
		return positionL;
	}

	public Joueur getProprietaire() { //DOUBLON
		return proprietaire;
	}


	public void allerADroite() { //Tests � faire
		if(positionL == Partie.LARGEUR-1)
			positionL=0;
		else 
			positionL++;
		
	}
	
	public void allerAGauche() {
		if(positionL == 0)
			positionL=Partie.LARGEUR-1;
		else 
			positionL--;
		
	}
	
	public void allerEnBas() {
		if(positionH == Partie.HAUTEUR-1)
			positionH=0;
		else 
			positionH++;
		
	}
	
	public void allerEnHaut() {
		if(positionH == 0)
			positionH=Partie.HAUTEUR-1;
		else 
			positionH--;
		
	}

	

}
