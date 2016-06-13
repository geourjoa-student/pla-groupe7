package jeu;

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
			
			if(caseInsertion!=null){
				Personnage p=null;
				if(caseSousLeJoueur.getTypeDeLaCase()==Type.CASERNE){
					p = new Guerrier(proprietaire, caseInsertion, proprietaire.getAutomateGuerrier());
				} 
				if(caseSousLeJoueur.getTypeDeLaCase()==Type.POLYTECH){
					p = new Guerrier(proprietaire, caseInsertion, proprietaire.getAutomateGuerrier());
				}
				if(caseSousLeJoueur.getTypeDeLaCase()==Type.EGLISE){
					p = new Guerrier(proprietaire, caseInsertion, proprietaire.getAutomateGuerrier());
				}
				
				if(p!=null){
					proprietaire.getPartie().ajouterPersonnage(p);
				}
			}
			
			
				
				
		}
		
	}

}
