package jeu;

import automate.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

public class Partie {

	// Taille du monde, une largeur impaire c'est mieux pour centrer
	public static final int LARGEUR = 27;

	public static final int HAUTEUR = 24;

	private InterfaceUtilisateur interfaceUtilisateur; // Interface du jeu

	private Joueur joueur1;

	private Joueur joueur2;

	private List<Personnage> personnages;

	/*
	 * 
	 * 0,0------------------largeur,0 ------------------------------
	 * hauteur,0------hauteur,largeur
	 */
	private Case decor[][];

	public Partie(InterfaceUtilisateur interfaceUtilisateur, Joueur joueur1, Joueur joueur2) {
		this.interfaceUtilisateur = interfaceUtilisateur;
		this.joueur1 = joueur1;
		this.joueur2 = joueur2;
		
		joueur1.setPartie(this);
		joueur2.setPartie(this);

		personnages = new LinkedList<Personnage>();

		decor = new Case[HAUTEUR][LARGEUR];

		creerDecor(joueur1.getNomFichierAutomate(), joueur2.getNomFichierAutomate());

		personnages.add(new Heros(joueur1, decor[2][(int)((LARGEUR-1)/2)]));
		personnages.add(new Heros(joueur2, decor[HAUTEUR-3][(int)((LARGEUR-1)/2)]));
		
		
	}
	
	
	private void inclureAutomates(ArrayList<Automate> autoJ1,ArrayList<Automate> autoJ2){
		Case caseTempo;
		Automate autoTempo;
		Case[][] tableauTempo;
		// JOUEUR 1 
		for(int i=0;i<autoJ1.size();i++){
			autoTempo = autoJ1.get(i);
			tableauTempo = autoTempo.getDecor();
			// Si on � un guerrier
			if(autoTempo.getRole() == 1) {
				joueur1.setAutomateGuerrier(autoTempo);
				for(int j=0;j<tableauTempo.length;j++){
					for(int k=0;k<tableauTempo[j].length;k++){
						tableauTempo[j][k].setProprietaire(joueur1);
						// Le premier automate s'affiche 2 cases � droite du h�ros
						decor[j+2][(int)((LARGEUR-1)/2)+2+k] = tableauTempo[j][k];					
					}
				}
			}
			// Si on � un moine
			if(autoTempo.getRole() == 2) {
				joueur1.setAutomateMoine(autoTempo);
				for(int j=0;j<tableauTempo.length;j++){
					for(int k=0;k<tableauTempo[j].length;k++){
						tableauTempo[j][k].setProprietaire(joueur1);
						// Le premier automate s'affiche (largeur de l'auto +1) cases � gauche du h�ros
						decor[j+2][(int)((LARGEUR-1)/2)-(tableauTempo[j].length+1)+k] = tableauTempo[j][k];						
					}
				}
			}
			// Si on � un paysan
			if(autoTempo.getRole() == 3) {
				joueur1.setAutomatePaysan(autoTempo);
				for(int j=0;j<tableauTempo.length;j++){
					for(int k=0;k<tableauTempo[j].length;k++){
						tableauTempo[j][k].setProprietaire(joueur1);
						// Le premier automate s'affiche � la moiti� de la map - la moiti� de la hauteur du auto, et tout � gauche +1
						decor[((int)((HAUTEUR-1)/2)-((int)tableauTempo.length/2))+j][k] = tableauTempo[j][k];						
					}
				}
			}
		}
		//JOUEUR 2
		for(int i=0;i<autoJ2.size();i++){
			autoTempo = autoJ2.get(i);
			tableauTempo = autoTempo.getDecor();
			// Si on � un guerrier
			if(autoTempo.getRole() == 1) {
				joueur2.setAutomateGuerrier(autoTempo);
				for(int j=0;j<tableauTempo.length;j++){
					for(int k=0;k<tableauTempo[j].length;k++){
						tableauTempo[j][k].setProprietaire(joueur2);
						// Le premier automate s'affiche 2 cases � droite du h�ros
						decor[HAUTEUR-3-j][(int)((LARGEUR-1)/2)-2-k] = tableauTempo[j][k];						
					}
				}
			}
			// Si on � un moine
			if(autoTempo.getRole() == 2) {
				joueur2.setAutomateMoine(autoTempo);
				for(int j=0;j<tableauTempo.length;j++){
					for(int k=0;k<tableauTempo[j].length;k++){
						tableauTempo[j][k].setProprietaire(joueur2);
						// Le premier automate s'affiche (largeur de l'auto +1) cases � gauche du h�ros
						decor[HAUTEUR-3-j][(int)((LARGEUR-1)/2)+(tableauTempo[j].length+1)-k] = tableauTempo[j][k];								
					}
				}
			}
			// Si on � un paysan
			if(autoTempo.getRole() == 3) {
				joueur2.setAutomatePaysan(autoTempo);
				for(int j=0;j<tableauTempo.length;j++){
					for(int k=0;k<tableauTempo[j].length;k++){
						tableauTempo[j][k].setProprietaire(joueur2);
						// Le premier automate s'affiche � la moiti� de la map - la moiti� de la hauteur du auto, et tout � gauche +1
						decor[((int)((HAUTEUR-1)/2)+((int)tableauTempo.length/2))-j][LARGEUR-k-1] = tableauTempo[j][k];								
					}
				}
			}
		}
	}

	private void creerDecor(String nomFichierAutomates1, String nomFichierAutomates2) {

		//On rempli le décror d'herbe et de ligne de champs, d'arbre, 
		for (int h = 0; h < HAUTEUR; h++) {
			for (int l = 0; l < LARGEUR; l++) {
				decor[h][l] = new Case(Type.HERBE, h, l);
			}
		}
		
		for (int h = 0; h < 7; h++) {
			for (int l = 0; l < 6; l++) {
				if (h != 6)
					decor[h][l].setTypeDeLaCase(Type.CHAMPS);
				else
					decor[h][l].setTypeDeLaCase(Type.ROCHER);
			}
		}
		
		decor[6][2].setTypeDeLaCase(Type.HERBE);
		decor[6][3].setTypeDeLaCase(Type.HERBE);
		for(int l = 4; l < 6; l++){
			decor[5][l].setTypeDeLaCase(Type.ROCHER);
		}
		decor[4][5].setTypeDeLaCase(Type.ROCHER);
		
		for (int h = HAUTEUR - 8; h < HAUTEUR - 1; h++) {
			for (int l = LARGEUR - 6; l < LARGEUR; l++) {
				if (h != HAUTEUR - 8)
					decor[h][l].setTypeDeLaCase(Type.CHAMPS);
				else
					decor[h][l].setTypeDeLaCase(Type.ROCHER);
			}
		}
		decor[HAUTEUR-8][LARGEUR-3].setTypeDeLaCase(Type.HERBE);
		decor[HAUTEUR-8][LARGEUR-4].setTypeDeLaCase(Type.HERBE);
		for(int l = LARGEUR-6; l < LARGEUR-4; l++){
			decor[HAUTEUR-7][l].setTypeDeLaCase(Type.ROCHER);
		}
		decor[HAUTEUR-6][LARGEUR-6].setTypeDeLaCase(Type.ROCHER);
		
		for(int x=0;x<LARGEUR;x++){
			decor[0][x].setTypeDeLaCase(Type.ROCHER);
			decor[HAUTEUR-1][x].setTypeDeLaCase(Type.ROCHER);
		}
		for (int h = HAUTEUR - 8; h < HAUTEUR - 1; h++) {
			for (int l = 0; l < 6; l++) {
				if (h != HAUTEUR - 8)
					decor[h][l].setTypeDeLaCase(Type.CHAMPS);
				else
					decor[h][l].setTypeDeLaCase(Type.ROCHER);
			}
		}
		for (int h = 1; h < 7; h++) {
			for (int l = LARGEUR-6; l < LARGEUR; l++) {
				if (h != 6)
					decor[h][l].setTypeDeLaCase(Type.CHAMPS);
				else
					decor[h][l].setTypeDeLaCase(Type.ROCHER);
			}
		}
		for(int k=0;k<3;k++){
			decor[(int)((HAUTEUR-1)/2)+2+k][5].setTypeDeLaCase(Type.ROCHER);
			decor[(int)((HAUTEUR-1)/2)-2-k][LARGEUR-6].setTypeDeLaCase(Type.ROCHER);
		}
		for(int k=6;k<LARGEUR-6;k++){
			decor[1][k].setTypeDeLaCase(Type.ARBRE);
			decor[HAUTEUR-2][k].setTypeDeLaCase(Type.ARBRE);
		}
		for(int l=2;l<HAUTEUR-2;l++){
			decor[l][6].setTypeDeLaCase(Type.ARBRE);
			decor[l][12].setTypeDeLaCase(Type.ARBRE);
			decor[l][14].setTypeDeLaCase(Type.ARBRE);
			decor[l][20].setTypeDeLaCase(Type.ARBRE);
			if( (l == 11) || (l == 12)){
				decor[l][12].setTypeDeLaCase(Type.HERBE);
				decor[l][14].setTypeDeLaCase(Type.HERBE);
			}
			if ( (l == 10) || (l == 13)){
				decor[l][12].setTypeDeLaCase(Type.HERBE);
				decor[l][14].setTypeDeLaCase(Type.HERBE);				
			}
		}
		for(int l=7;l<13;l++){
			decor[l][5].setTypeDeLaCase(Type.ARBRE);
			decor[l+3][21].setTypeDeLaCase(Type.ARBRE);
		}
		for(int k=7;k<20;k++){
			decor[11][k].setTypeDeLaCase(Type.ARBRE);
			decor[12][k].setTypeDeLaCase(Type.ARBRE);
			if(k>10 && k<16){
				decor[11][k].setTypeDeLaCase(Type.HERBE);
				decor[12][k].setTypeDeLaCase(Type.HERBE);
			}
		}
		
		decor[1][(int)((LARGEUR-1)/2)].setTypeDeLaCase(Type.POLYTECH);
		decor[HAUTEUR-2][(int)((LARGEUR-1)/2)].setTypeDeLaCase(Type.POLYTECH);
		
		decor[1][(int)((LARGEUR-1)/2)].setProprietaire(joueur1);
		decor[HAUTEUR-2][(int)((LARGEUR-1)/2)].setProprietaire(joueur2);
		
		JDOM jdom = new JDOM();
		inclureAutomates(jdom.xmlMain(nomFichierAutomates1), jdom.xmlMain(nomFichierAutomates2));
		
		// Tout le décor est crée, il faut maintenant chainer les cases entre
		// elles

		for (int h = 0; h < HAUTEUR; h++) {
			for (int l = 0; l < LARGEUR; l++) {
				// Chainage en haut
				if (h == 0)
					decor[h][l].setCaseEnHaut(decor[HAUTEUR - 1][l]);
				else
					decor[h][l].setCaseEnHaut(decor[h - 1][l]);

				// Chainage en bas
				if (h == HAUTEUR - 1)
					decor[h][l].setCaseEnBas(decor[0][l]);
				else
					decor[h][l].setCaseEnBas(decor[h + 1][l]);

				// Chainage a gauche
				if (l == 0)
					decor[h][l].setCaseAGauche(decor[h][LARGEUR - 1]);
				else
					decor[h][l].setCaseAGauche(decor[h][l - 1]);

				// Chainage a droite
				if (l == LARGEUR - 1)
					decor[h][l].setCaseADroite(decor[h][0]);
				else
					decor[h][l].setCaseADroite(decor[h][l + 1]);
			}
		}
		
		//Je modifie le décor pour qu'il soit un peu intéressant

		

	}

	public void jouerTour() {

		System.out.println(personnages.size());

		List<Personnage> tempo = new ArrayList<>();
		for (Iterator<Personnage> iterator = personnages.iterator(); iterator.hasNext();) {
			Personnage personnage = iterator.next();

			// Un personnage ne peut évoluer que si il n'est pas mort, il sera
			// supprimé à la fin du tour
			// TODO il reste un cas ou ce fonctionnement n'est pas satisfaisant
			// : si un joueur est mort, on peut toujour l'attaquer
			if (personnage.estVivant()) {

				Action actionAfaire = Action.NE_RIEN_FAIRE;

				if (personnage instanceof Heros) {
					
					interfaceUtilisateur.afficherJoueur(joueur1, joueur2);
					interfaceUtilisateur.afficherMap(decor);
					interfaceUtilisateur.afficherPersonnages(personnages);

					interfaceUtilisateur.demanderNouvelleAction(personnage.getProprietaire().getNom());
					actionAfaire = personnage.getProprietaire().getNouvelleAction();

				} else {
					actionAfaire =((Homme) personnage).getAction();
				}
					 

				// TODO Rajouter ici aussi quand on ajoute de nouvelles actions
				switch (actionAfaire) {
					case ALLER_A_DROITE:
						personnage.allerADroite();
						break;
					case ALLER_A_GAUCHE:
						personnage.allerAGauche();
						break;
					case ALLER_EN_HAUT:
						personnage.allerEnHaut();
						break;
					case ALLER_EN_BAS:
						personnage.allerEnBas();
						break;
					case ATTAQUER:
						personnage.attaquer();
						break;	
					case RECOLTER:
						personnage.recolter();
						break;
					case SOIGNER:
						personnage.soigner();
						break;
					case CONVERTIR:
						personnage.soigner();
						break;
					case SE_DEPLACER:
						personnage.seDeplacer();
						break;
					case CREER_UNITE:
						//On ne peut ajouter les personnages qu'après la fin de l'itération : err java.util.ConcurrentModificationException
						Personnage p =((Heros) personnage).creerUnite();
						if(p!=null)
							tempo.add(p);
						break;

					case NE_RIEN_FAIRE:
					default:

						break;
				}

			}
		}

		// Je supprime les morts de la liste
		for (int i = 0; i < personnages.size(); i++) {
			if (!personnages.get(i).estVivant()) {
				personnages.remove(i);
			}

		}
		
		//Je rajoute les nouveaux personnages
		for (Iterator<Personnage> iterator = tempo.iterator(); iterator.hasNext();) {
			personnages.add((Personnage) iterator.next());
			
		}
	}

	public boolean estTermine() {
		return false;
	}
	
	

}
