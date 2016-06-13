package jeu;

import java.util.Random;

public class Heros extends Personnage{

	public Heros(Joueur joueur, Case caseSousLeJoueur) {
		this.caseSousLeJoueur=caseSousLeJoueur;
		caseSousLeJoueur.placerPersonnage(this);
		proprietaire=joueur;	
		pointsDeVie = 250; // TODO Valeurs arbitraires
		force=30;
		recolte = 20;
		soin = 50;
		convertir = 20;
		comportement=null;//TODO automate
	}
	
	public void creerUnite(){
		
		
		if (caseSousLeJoueur.estBatiment() && caseSousLeJoueur.caseAllie(proprietaire)) {
			Case caseInsertion = null;;
			if(caseSousLeJoueur.getCaseADroite().getPersonnagePresent()==null){
				caseInsertion=caseSousLeJoueur.getCaseADroite();
			} else if(caseSousLeJoueur.getCaseAGauche().getPersonnagePresent()==null){
				caseInsertion=caseSousLeJoueur.getCaseAGauche();
			} else if(caseSousLeJoueur.getCaseEnBas().getPersonnagePresent()==null){
				caseInsertion=caseSousLeJoueur.getCaseEnBas();
			} else if(caseSousLeJoueur.getCaseEnHaut().getPersonnagePresent()==null){
				caseInsertion=caseSousLeJoueur.getCaseEnHaut();
			}
			
				
			Personnage p = new Guerrier(proprietaire, caseSousLeJoueur.getCaseADroite(), proprietaire.getAutomateGuerrier());	
		}
		
	}

}
