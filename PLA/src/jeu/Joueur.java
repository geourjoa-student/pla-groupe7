package jeu;

public abstract class Joueur {
	
	protected String nom;
	
	protected Heros heros;
	
	public Personnage getHeros(){
		return heros;
	}

	public abstract Action getNouvelleAction();

}
