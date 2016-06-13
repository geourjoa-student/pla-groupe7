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
	}
	
	public Personnage creerUnite(){
		//TODO Clément : prendre en compte le cout de création et retiré ce prix aux joueurs
		
		if (caseSousLePersonnage.estBatiment() && caseSousLePersonnage.caseAllie(proprietaire)) {
			Case caseInsertion = null;;
			if(caseSousLePersonnage.getCaseADroite().estAccessible()){
				caseInsertion=caseSousLePersonnage.getCaseADroite();
			} else if(caseSousLePersonnage.getCaseAGauche().estAccessible()){
				caseInsertion=caseSousLePersonnage.getCaseAGauche();
			} else if(caseSousLePersonnage.getCaseEnBas().estAccessible()){
				caseInsertion=caseSousLePersonnage.getCaseEnBas();
			} else if(caseSousLePersonnage.getCaseEnHaut().estAccessible()){
				caseInsertion=caseSousLePersonnage.getCaseEnHaut();
			}
			
			if(caseInsertion!=null){
				Personnage p=null;
				if(caseSousLePersonnage.getTypeDeLaCase()==Type.CASERNE){
					p = new Guerrier(proprietaire, caseInsertion, proprietaire.getAutomateGuerrier());
				} 
				if(caseSousLePersonnage.getTypeDeLaCase()==Type.POLYTECH){
					p = new Paysan(proprietaire, caseInsertion, proprietaire.getAutomatePaysan());
				}
				if(caseSousLePersonnage.getTypeDeLaCase()==Type.EGLISE){
					p = new Moine(proprietaire, caseInsertion, proprietaire.getAutomateMoine());
				}
				
				return p;
			}
			
			
				
				
		}
		
		return null;
		
	}

}
