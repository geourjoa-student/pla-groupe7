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

		personnages = new LinkedList<Personnage>();

		decor = new Case[HAUTEUR][LARGEUR];

		creerDecor(joueur1.getNomFichierAutomate(), joueur2.getNomFichierAutomate());

		// TODO verifier si la case est vraiment accessible, pour l'instant on
		// n'en tiens pas encore compte
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
				for(int j=0;j<tableauTempo.length;j++){
					for(int k=0;k<tableauTempo[j].length;k++){
						caseTempo = tableauTempo[j][k];
						// Le premier automate s'affiche 2 cases � droite du h�ros
						decor[j+2][(int)((LARGEUR-1)/2)+2+k] = caseTempo;						
					}
				}
			}
			// Si on � un moine
			if(autoTempo.getRole() == 2) {
				for(int j=0;j<tableauTempo.length;j++){
					for(int k=0;k<tableauTempo[j].length;k++){
						caseTempo = tableauTempo[j][k];
						// Le premier automate s'affiche (largeur de l'auto +1) cases � gauche du h�ros
						decor[j+2][(int)((LARGEUR-1)/2)-(tableauTempo[j].length+1)+k] = caseTempo;						
					}
				}
			}
			// Si on � un paysan
			if(autoTempo.getRole() == 3) {
				for(int j=0;j<tableauTempo.length;j++){
					for(int k=0;k<tableauTempo[j].length;k++){
						caseTempo = tableauTempo[j][k];
						// Le premier automate s'affiche � la moiti� de la map - la moiti� de la hauteur du auto, et tout � gauche +1
						decor[((int)((HAUTEUR-1)/2)-((int)tableauTempo.length/2))+j][k] = caseTempo;						
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
				for(int j=0;j<tableauTempo.length;j++){
					for(int k=0;k<tableauTempo[j].length;k++){
						caseTempo = tableauTempo[j][k];
						// Le premier automate s'affiche 2 cases � droite du h�ros
						decor[HAUTEUR-3-j][(int)((LARGEUR-1)/2)-2-k] = caseTempo;						
					}
				}
			}
			// Si on � un moine
			if(autoTempo.getRole() == 2) {
				for(int j=0;j<tableauTempo.length;j++){
					for(int k=0;k<tableauTempo[j].length;k++){
						caseTempo = tableauTempo[j][k];
						// Le premier automate s'affiche (largeur de l'auto +1) cases � gauche du h�ros
						decor[HAUTEUR-3-j][(int)((LARGEUR-1)/2)+(tableauTempo[j].length+1)-k] = caseTempo;						
					}
				}
			}
			// Si on � un paysan
			if(autoTempo.getRole() == 3) {
				for(int j=0;j<tableauTempo.length;j++){
					for(int k=0;k<tableauTempo[j].length;k++){
						caseTempo = tableauTempo[j][k];
						// Le premier automate s'affiche � la moiti� de la map - la moiti� de la hauteur du auto, et tout � gauche +1
						decor[((int)((HAUTEUR-1)/2)+((int)tableauTempo.length/2))-j][LARGEUR-k-1] = caseTempo;						
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
		//TODO completer
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


		// On parcourt la liste des personnages et on fait effectuer une action
		// à chacun
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

				} /*
					 * else {
					 * 
					 * //TODO Choisir la transitiona affecté à un personnage qui
					 * n'est pas un héros (qui n'est pas jouable) //TODO
					 * Récuperer l'action à effectuer }
					 * 
					 * 
					 * 
					 */

				// TODO Completer avec toute les actions
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

					case NE_RIEN_FAIRE:
					default:

						break;
				}

			}
		}

		// Je supprime les morts de la liste
		for (int i = 0; i < personnages.size(); i++) {
			// TODO Peut buguer, mais fonctionne à priori
			if (!personnages.get(i).estVivant()) {
				personnages.remove(i);
			}

		}
	}

	public boolean estTermine() {
		return false;
	}

}
