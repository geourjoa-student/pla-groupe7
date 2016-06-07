package jeu;

import java.util.Random;

import automate.Automate;

public abstract class Personnage {

	private static final int NB_TENTATIVE_ATTQUE_MAX = 3;

	protected Case caseSousLeJoueur;

	protected int pointsDeVie;
	
	protected int force;

	protected Joueur proprietaire;

	protected Automate comportement;

	public Joueur getJoueur() {
		return proprietaire;
	}

	public Joueur getProprietaire() {
		return proprietaire;
	}

	public void allerADroite() {

		if (!caseSousLeJoueur.getCaseADroite().estAccessible()) {
			caseSousLeJoueur.retirerPersonnagePresent();
			caseSousLeJoueur = caseSousLeJoueur.getCaseADroite();
			caseSousLeJoueur.placerPersonnage(this);
		}
	}

	public void allerAGauche() {
		if (!caseSousLeJoueur.getCaseAGauche().estAccessible()) {
			caseSousLeJoueur.retirerPersonnagePresent();
			caseSousLeJoueur = caseSousLeJoueur.getCaseAGauche();
			caseSousLeJoueur.placerPersonnage(this);
		}
	}

	public void allerEnBas() {
		if (!caseSousLeJoueur.getCaseEnBas().estAccessible()) {
			caseSousLeJoueur.retirerPersonnagePresent();
			caseSousLeJoueur = caseSousLeJoueur.getCaseEnBas();
			caseSousLeJoueur.placerPersonnage(this);
		}
	}

	public void allerEnHaut() {
		if (!caseSousLeJoueur.getCaseEnHaut().estAccessible()) {
			caseSousLeJoueur.retirerPersonnagePresent();
			caseSousLeJoueur = caseSousLeJoueur.getCaseEnHaut();
			caseSousLeJoueur.placerPersonnage(this);
		}
	}
	
	public void recevoirDegat(int nbDegats){
		pointsDeVie-=nbDegats;
	}
	
	public boolean estVivant (){
		return (pointsDeVie>0);
	}
	
	public void attaquer(){
		Random rand = new Random();
			
		Personnage personnageAAttaquer=null;
		
		for(int numeroEssaiAttaque = 0; numeroEssaiAttaque<NB_TENTATIVE_ATTQUE_MAX ; numeroEssaiAttaque++){
			
			//On choisit l'orientation d'attaque aléatoirement, si il n'y a personne à l'orientation tirée, on recommence
			switch (rand.nextInt(5)) {
				case 0:
					if(caseSousLeJoueur.getCaseEnHaut().getPersonnagePresent()!=null && caseSousLeJoueur.getCaseEnHaut().getPersonnagePresent().getJoueur()!=proprietaire)
						personnageAAttaquer=caseSousLeJoueur.getCaseEnHaut().getPersonnagePresent();
					break;
				case 1:
					if(caseSousLeJoueur.getCaseADroite().getPersonnagePresent()!=null && caseSousLeJoueur.getCaseADroite().getPersonnagePresent().getJoueur()!=proprietaire)
						personnageAAttaquer=caseSousLeJoueur.getCaseADroite().getPersonnagePresent();
					break;
				case 2:
					if(caseSousLeJoueur.getCaseEnBas().getPersonnagePresent()!=null && caseSousLeJoueur.getCaseEnBas().getPersonnagePresent().getJoueur()!=proprietaire)
						personnageAAttaquer=caseSousLeJoueur.getCaseEnBas().getPersonnagePresent();
					break;	
				case 3:
					if(caseSousLeJoueur.getCaseAGauche().getPersonnagePresent()!=null && caseSousLeJoueur.getCaseAGauche().getPersonnagePresent().getJoueur()!=proprietaire)
						personnageAAttaquer=caseSousLeJoueur.getCaseAGauche().getPersonnagePresent();
					break;	

				default:
					break;
			}
		}
		
		if(personnageAAttaquer!=null)
			personnageAAttaquer.recevoirDegat(force+rand.nextInt(force));
		
	}

	@Override
	public String toString() {

		return proprietaire.getNom() + " : " + getClass().getSimpleName() + " : " + pointsDeVie + " : ("
				+ caseSousLeJoueur.getPositionH() + "," + caseSousLeJoueur.getPositionL() + ")";
	}

}
