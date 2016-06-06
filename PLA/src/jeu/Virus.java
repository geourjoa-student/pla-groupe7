package jeu;

public class Virus {
	
	private String nom;
	
	private int phase;
	
	private int resistanceChaleur;
	
	private int resistanceFroid;
	
	private int resistanceHumidite;
	
	private int propagation;
	
	private int etalite;
	
	private boolean reveille;

	public Virus(String nom, int phase, int resistanceChaleur,
			int resistanceFroid, int resistanceHumidite, int propagation,
			int etalite, boolean reveille) {

		this.nom = nom;
		this.phase = phase;
		this.resistanceChaleur = resistanceChaleur;
		this.resistanceFroid = resistanceFroid;
		this.resistanceHumidite = resistanceHumidite;
		this.propagation = propagation;
		this.etalite = etalite;
		this.reveille = reveille;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getPhase() {
		return phase;
	}

	public void setPhase(int phase) {
		this.phase = phase;
	}

	public int getResistanceChaleur() {
		return resistanceChaleur;
	}

	public void setResistanceChaleur(int resistanceChaleur) {
		this.resistanceChaleur = resistanceChaleur;
	}

	public int getResistanceFroid() {
		return resistanceFroid;
	}

	public void setResistanceFroid(int resistanceFroid) {
		this.resistanceFroid = resistanceFroid;
	}

	public int getResistanceHumidite() {
		return resistanceHumidite;
	}

	public void setResistanceHumidite(int resistanceHumidite) {
		this.resistanceHumidite = resistanceHumidite;
	}

	public int getPropagation() {
		return propagation;
	}

	public void setPropagation(int propagation) {
		this.propagation = propagation;
	}

	public int getEtalite() {
		return etalite;
	}

	public void setEtalite(int etalite) {
		this.etalite = etalite;
	}

	public boolean isReveille() {
		return reveille;
	}

	public void setReveille(boolean reveille) {
		this.reveille = reveille;
	}
	
	

}