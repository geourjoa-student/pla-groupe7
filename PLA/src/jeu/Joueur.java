package jeu;

public abstract class Joueur {
	
	protected String nom;
	
	protected int richesse;
	
	protected int nombrePersonnage;
	
	public int getRichesse(){
		return richesse;
	}
	
	public String getNom() {
		return nom;
	}

	public abstract Action getNouvelleAction();
	
	@Override
	public String toString() {
		return nom + " : " + getClass().getSimpleName() + " : " + richesse;
	}

}
