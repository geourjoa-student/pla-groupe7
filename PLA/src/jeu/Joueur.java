package jeu;

public abstract class Joueur {
	
	protected String nom;
	
	protected int bois;
	
	protected int nourriture;
	
	protected int nombrePersonnage;
	
	protected String nomFichierAutomate;
	
	public int getBois() {
		return bois;
	}

	public int getNourriture() {
		return nourriture;
	}
	
	public void ajouterBois(int quantite){
		bois+=quantite;
	}
	
	public void ajouterNourriture(int quantite){
		nourriture+=quantite;
	}

	public String getNom() {
		return nom;
	}

	public abstract Action getNouvelleAction();
	
	@Override
	public String toString() {
		return nom + " : " + getClass().getSimpleName() + " : " + nourriture + " : " + bois;
	}

	public String getNomFichierAutomate(){
		return nomFichierAutomate;
	}
}
