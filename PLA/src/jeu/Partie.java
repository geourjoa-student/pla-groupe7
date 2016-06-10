package jeu;

import automate.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

public class Partie {

	// Taille du monde, une largeur impaire c'est mieux pour centrer
	public static final int LARGEUR = 19;

	public static final int HAUTEUR = 22;

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

		creerDecor();

		// TODO verifier si la case est vraiment accessible, pour l'instant on
		// n'en tiens pas encore compte
		personnages.add(new Heros(joueur1, decor[2][(int)((LARGEUR-1)/2)]));
		personnages.add(new Heros(joueur2, decor[HAUTEUR-3][(int)((LARGEUR-1)/2)]));

	}
	
	private void inclureAutomates(ArrayList<Automate> autoJ1,ArrayList<Automate> autoJ2){
		Case caseTempo;
		Automate autoTempo;
		Case[][] tableauTempo;
		for(int i=0;i<autoJ1.size();i++){
			autoTempo = autoJ1.get(i);
			tableauTempo = autoTempo.getDecor();
			// Si on ‡ un guerrier
			if(autoTempo.getRole() == 1) {
				for(int j=0;j<tableauTempo.length;j++){
					for(int k=0;k<tableauTempo[j].length;j++){
						caseTempo = tableauTempo[j][k];
						// Le premier automate s'affiche 2 cases ‡ droite du hÈros
						decor[j+2][(int)((LARGEUR-1)/2)+3+k] = caseTempo;						
					}
				}
			}
			// Si on ‡ un moine
			if(autoTempo.getRole() == 2) {
				for(int j=0;j<tableauTempo.length;j++){
					for(int k=0;k<tableauTempo[j].length;j++){
						caseTempo = tableauTempo[j][k];
						// Le premier automate s'affiche (largeur de l'auto +1) cases ‡ gauche du hÈros
						decor[j+2][(int)((LARGEUR-1)/2)-(tableauTempo[j].length+1)+k] = caseTempo;						
					}
				}
			}
			// Si on ‡ un paysan
			if(autoTempo.getRole() == 3) {
				for(int j=0;j<tableauTempo.length;j++){
					for(int k=0;k<tableauTempo[j].length;j++){
						caseTempo = tableauTempo[j][k];
						// Le premier automate s'affiche ‡ la moitiÈ de la map - la moitiÈ de la hauteur du auto, et tout ‡ gauche +1
						decor[((int)((HAUTEUR-1)/2)-((int)tableauTempo.length/2))+j][k+1] = caseTempo;						
					}
				}
			}
		}
	}

	private void creerDecor() {

		for (int h = 0; h < HAUTEUR; h++) {
			for (int l = 0; l < LARGEUR; l++) {
				decor[h][l] = new Case(Type.HERBE, h, l);
			}
		}

		// Tout le d√©cor est cr√©e, il faut maintenant chainer les cases entre
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
		
		//Je modifie le d√©cor pour qu'il soit un peu int√©ressant

		for (int h = 0; h < decor.length; h++) {
			decor[h][5].setTypeDeLaCase(Type.ARBRE);
			decor[h][8].setTypeDeLaCase(Type.CHAMPS);
		}
		
		for(int l =4; l< 7; l++){
			decor[3][l].setTypeDeLaCase(Type.ROCHER);	
			decor[5][l].setTypeDeLaCase(Type.ROCHER);
		}
		for(int x=0;x<LARGEUR;x++){
			decor[0][x].setTypeDeLaCase(Type.ROCHER);
			decor[HAUTEUR-1][x].setTypeDeLaCase(Type.ROCHER);
		}

	}

	public void jouerTour() {


		// On parcourt la liste des personnages et on fait effectuer une action
		// √† chacun
		for (Iterator<Personnage> iterator = personnages.iterator(); iterator.hasNext();) {
			Personnage personnage = iterator.next();

			// Un personnage ne peut √©voluer que si il n'est pas mort, il sera
			// supprim√© √† la fin du tour
			// TODO il reste un cas ou ce fonctionnement n'est pas satisfaisant
			// : si un joueur est mort, on peut toujour l'attaquer
			if (personnage.estVivant()) {

				Action actionAfaire = Action.NE_RIEN_FAIRE;

				if (personnage instanceof Heros) {
					
					interfaceUtilisateur.afficherJoueur(joueur1, joueur2);
					interfaceUtilisateur.afficherMap(decor);
					interfaceUtilisateur.afficherPersonnages(personnages);

					interfaceUtilisateur.demanderNouvelleAction(personnage.getJoueur().getNom());
					actionAfaire = personnage.getJoueur().getNouvelleAction();

				} /*
					 * else {
					 * 
					 * //TODO Choisir la transitiona affect√© √† un personnage qui
					 * n'est pas un h√©ros (qui n'est pas jouable) //TODO
					 * R√©cuperer l'action √† effectuer }
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
			// TODO Peut buguer, mais fonctionne √† priori
			if (!personnages.get(i).estVivant()) {
				personnages.remove(i);
			}

		}
	}

	public boolean estTermine() {
		return false;
	}

}
