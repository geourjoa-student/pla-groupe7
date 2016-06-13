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
		
		if (caseSousLeJoueur.getTypeDeLaCase()==Type.CASERNE && caseSousLeJoueur.caseAllie(proprietaire)) {
			boolean insere=false;
			Random rand = new Random();
			
			while(!insere){
				switch (rand.nextInt(4)){
					case 0 :
						if(caseSousLeJoueur.getCaseEnHaut().getPersonnagePresent()==null){
							
						}
				}
			}
				
				
		}
		
	}

}
