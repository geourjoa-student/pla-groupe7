package jeu;

import java.util.Random;

import automate.Automate;

public abstract class Personnage {

	private static final int NB_TENTATIVE_ATTAQUE_MAX = 5;

	protected Case caseSousLeJoueur;
	
	protected int role;

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

	/*
	 * Fonctions de déplacement
	 * 
	 * -On teste si la case est accessible (qu'il n'y es pas de personnages dessus ou x autres raisons)
	 * -Si c'est possible 
	 * 		- On retire le personnage de la case ou il est actuellement
	 * 		- On recupere la case de destination
	 * 		- on modifie la case courante du personnage
	 * 		- on place notre personnage sur sa nouvelle case
	 */
	public void allerADroite() {
		if (caseSousLeJoueur.getCaseADroite().estAccessible()) {
			caseSousLeJoueur.retirerPersonnagePresent();
			caseSousLeJoueur = caseSousLeJoueur.getCaseADroite();
			caseSousLeJoueur.placerPersonnage(this);
		}
	}

	public void allerAGauche() {
		if (caseSousLeJoueur.getCaseAGauche().estAccessible()) {
			caseSousLeJoueur.retirerPersonnagePresent();
			caseSousLeJoueur = caseSousLeJoueur.getCaseAGauche();
			caseSousLeJoueur.placerPersonnage(this);
		}
	}

	public void allerEnBas() {
		if (caseSousLeJoueur.getCaseEnBas().estAccessible()) {
			caseSousLeJoueur.retirerPersonnagePresent();
			caseSousLeJoueur = caseSousLeJoueur.getCaseEnBas();
			caseSousLeJoueur.placerPersonnage(this);
		}
	}

	public void allerEnHaut() {
		if (caseSousLeJoueur.getCaseEnHaut().estAccessible()) {
			caseSousLeJoueur.retirerPersonnagePresent();
			caseSousLeJoueur = caseSousLeJoueur.getCaseEnHaut();
			caseSousLeJoueur.placerPersonnage(this);
		}
	}
	
	
	/*
	 * Fonction qui représente l'attaque. Je me pose la question de l'interet de créer des classes Guerriers, tout ça tout ça vu qu'au final c'est l'automate leur comportement
	 * 
	 * La fonction en elle meme permet l'attaque d'une case adjacente. Si il il n'y a pas d'ennemi adjacent, la fonction est sans conséquence sur le personnage et son environment.
	 * Pour faire ça je ture NB_TENTATIVE_ATTQUE_MAX fois un nombre qui correspond à l'orientation d'attaque (0 en haut, 1 à droite ..). Si il y a effectivement une personne attaquable
	 * on l'attaque. (Si il reste des tirages, le personnage à attaquer peut changer mais ça restera une personne attaquable)
	 */
	public void attaquer(){
		Random rand = new Random();
			
		Personnage personnageAAttaquer=null;
		
		for(int numeroEssaiAttaque = 0; numeroEssaiAttaque<NB_TENTATIVE_ATTAQUE_MAX ; numeroEssaiAttaque++){
			
			//On choisit l'orientation d'attaque aléatoirement, si il n'y a personne à l'orientation tirée, on recommence
			//Tirage entre 0 et 4 non compris
			switch (rand.nextInt(4)) {
				case 0:
					//Si il y a personnage sur la case choisis et qu'il n'appartient pas au même joueur, je peux le choisir comme cible
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
		
		//Si j'ai  trouve quelqu'un a attaquer, je lui défonce sa race
		if(personnageAAttaquer!=null)
			personnageAAttaquer.recevoirDegat(force+rand.nextInt(force)); //J'ai ajouter un peu d'aléatoire à cet epique combat
		
	}
	
	//Fonction associé à l'attaque
	public void recevoirDegat(int nbDegats){
		pointsDeVie-=nbDegats;
	}
	
	public boolean estVivant (){
		if(pointsDeVie <= 0)
			caseSousLeJoueur.retirerPersonnagePresent();
		return (pointsDeVie>0);
	}
	
	public void recolter(){
		System.out.println("JE recolte");
		if(caseSousLeJoueur.getTypeDeLaCase()==Type.CHAMPS){
			proprietaire.ajouterNourriture(caseSousLeJoueur.recolter());
		} else if(caseSousLeJoueur.getTypeDeLaCase()==Type.ARBRE){
			proprietaire.ajouterBois(caseSousLeJoueur.recolter());
		}  
	}

	@Override
	public String toString() {

		return proprietaire.getNom() + " : " + getClass().getSimpleName() + " : " + pointsDeVie + " : ("
				+ caseSousLeJoueur.getPositionH() + "," + caseSousLeJoueur.getPositionL() + ")";
	}

}
