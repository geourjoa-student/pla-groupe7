package jeu;

public abstract class InterfaceUtilisateur {

	public abstract void demanderNouvelleAction(String nomJoueur) ;

	public abstract void afficherMap(Case[][] decor, java.util.List<Personnage> personnages) ;
	

}
