package jeu;

public abstract class Joueur {
	
	protected String nom;
	
	public String getNom() {
		return nom;
	}

	public abstract Action getNouvelleAction();

}
