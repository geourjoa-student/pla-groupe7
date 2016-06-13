package jeu;

import automate.Automate;

public abstract class Joueur {
	
	protected String nom;
	
	protected int bois;
	
	protected int nourriture;
	
	protected int nombrePersonnage;
	
	protected String nomFichierAutomate;
	
	protected Automate automateGuerrier;
	
	protected Automate automateMoine;
	
	protected Automate automatePaysan;
	
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

	public Automate getAutomateGuerrier() {
		return automateGuerrier;
	}

	public void setAutomateGuerrier(Automate automateGuerrier) {
		this.automateGuerrier = automateGuerrier;
	}

	public Automate getAutomateMoine() {
		return automateMoine;
	}

	public void setAutomateMoine(Automate automateMoine) {
		this.automateMoine = automateMoine;
	}

	public Automate getAutomatePaysan() {
		return automatePaysan;
	}

	public void setAutomatePaysan(Automate automatePaysan) {
		this.automatePaysan = automatePaysan;
	}
	
	
}
