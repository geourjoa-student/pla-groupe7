package jeu;

public class Heros extends Personnage{

	//TODO C'est ici que l'on peut paramètrer les capacités de bases
	private static final int FORCE_HEROS_STANDARD = 30;
	private static final int VIE_HEROS_STANDARD = 200;
	private static final int CAPACITE_RECOLTE_STANDARD = 20;
	private static final int CAPACITE_SOIN_STANDARD = 50;
	private static final int TAUX_DE_REUSSITE_DE_CONVERSION_STANDARD = 20;

	public Heros(Joueur joueur, Case caseSousLeJoueur) {
		this.caseSousLePersonnage=caseSousLeJoueur;
		caseSousLeJoueur.placerPersonnage(this);
		proprietaire=joueur;	
		pointsDeVie = VIE_HEROS_STANDARD;
		force=FORCE_HEROS_STANDARD;
		recolte = CAPACITE_RECOLTE_STANDARD;
		soin = CAPACITE_SOIN_STANDARD;
		convertir = TAUX_DE_REUSSITE_DE_CONVERSION_STANDARD;
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
