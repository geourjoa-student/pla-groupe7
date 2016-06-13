package jeu;

public class Heros extends Personnage{

	public Heros(Joueur joueur, Case caseSousLeJoueur) {
		this.caseSousLePersonnage=caseSousLeJoueur;
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
		//Ajouter reteait de ressource
		
		if (caseSousLePersonnage.estBatiment() && caseSousLePersonnage.caseAllie(proprietaire)) {
			Case caseInsertion = null;;
			if(caseSousLePersonnage.getCaseADroite().getPersonnagePresent()==null){
				caseInsertion=caseSousLePersonnage.getCaseADroite();
			} else if(caseSousLePersonnage.getCaseAGauche().getPersonnagePresent()==null){
				caseInsertion=caseSousLePersonnage.getCaseAGauche();
			} else if(caseSousLePersonnage.getCaseEnBas().getPersonnagePresent()==null){
				caseInsertion=caseSousLePersonnage.getCaseEnBas();
			} else if(caseSousLePersonnage.getCaseEnHaut().getPersonnagePresent()==null){
				caseInsertion=caseSousLePersonnage.getCaseEnHaut();
			}
			
			if(caseInsertion!=null){
				Personnage p=null;
				if(caseSousLePersonnage.getTypeDeLaCase()==Type.CASERNE){
					p = new Guerrier(proprietaire, caseInsertion, proprietaire.getAutomateGuerrier());
				} 
				if(caseSousLePersonnage.getTypeDeLaCase()==Type.POLYTECH){
					p = new Guerrier(proprietaire, caseInsertion, proprietaire.getAutomatePaysan());
				}
				if(caseSousLePersonnage.getTypeDeLaCase()==Type.EGLISE){
					p = new Guerrier(proprietaire, caseInsertion, proprietaire.getAutomateMoine());
				}
				
				if(p!=null){
					proprietaire.getPartie().ajouterPersonnage(p);
				}
			}
			
			
				
				
		}
		
	}

}
