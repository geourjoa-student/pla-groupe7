package jeu;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Partie {

	// Taille du monde
	public static final int LARGEUR = 10;

	public static final int HAUTEUR = 10;

	private InterfaceUtilisateur interfaceUtilisateur; // Interface du jeu

	private Joueur joueur1;

	private Joueur joueur2;

	private List<Personnage> personnages;

	/*
	 * 
	 * 0,0------------------largeur,0 ------------------------------
	 * hauteur,0------hauteur,largeur
	 */
	private int decor[][];

	public Partie(InterfaceUtilisateur interfaceUtilisateur, Joueur joueur1, Joueur joueur2) {
		this.interfaceUtilisateur = interfaceUtilisateur;
		this.joueur1 = joueur1;
		this.joueur2 = joueur2;

		personnages = new LinkedList<Personnage>();

		personnages.add(joueur1.getHeros());
		personnages.add(joueur2.getHeros());

		decor = new int[LARGEUR][HAUTEUR];

		for (int i = 0; i < decor.length; i++) {
			for (int j = 0; j < decor[i].length; j++) {
				decor[i][j] = 0; // On rempli la map de 0
			}
		}

	}

	public void jouerTour() {

		interfaceUtilisateur.afficherMap(decor);

		for (Iterator<Personnage> iterator = personnages.iterator(); iterator.hasNext();) {
			Personnage personnage = (Personnage) iterator.next();

			Action actionAfaire = Action.NE_RIEN_FAIRE;

			if (personnage instanceof Heros) {

				actionAfaire = personnage.getJoueur().getNouvelleAction();

			} /*
				 * else {
				 * 
				 * //TODO Choisir la transitiona affecté à un personnage qui
				 * n'est pas un héros (qui n'est pas jouable) //TODO Récuperer
				 * l'action à effectuer }
				 * 
				 * 
				 * //TODO Faire executer l'action
				 */
			switch (actionAfaire) {
				case ALLER_A_DROITE:
					if (estParcourable(personnage.getPositionX() + 1, personnage.getPositionY()))
						;
					personnage.allerADroite();
					break;
				case ALLER_A_GAUCHE:
					if (estParcourable(personnage.getPositionX() - 1, personnage.getPositionY()))
						;
					personnage.allerAGauche();
					break;
				case ALLER_EN_HAUT:
					if (estParcourable(personnage.getPositionX(), personnage.getPositionY() - 1))
						;
					personnage.allerEnHaut();
					break;
				case ALLER_EN_BAS:
					if (estParcourable(personnage.getPositionX(), personnage.getPositionY() + 1))
						;
					personnage.allerEnBas();
					break;
				
				//Si on arrive la, soit la commande est mauvaise soit on ne doit rien faire
				case NE_RIEN_FAIRE:
				default:
				
					break;
			}
		}

	}

	public boolean estTermine() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean estParcourable(int x, int y) {
		// TODO pour l'instant toute les cases sont parcourables, on peut être à
		// plusieurs dessus etc..
		return true;
	}
}
