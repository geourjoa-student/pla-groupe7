package jeu;

import java.util.List;

public abstract class InterfaceUtilisateur {

	public abstract void demanderNouvelleAction(String nomJoueur) ;

	public abstract void afficherMap(Case[][] decor) ;
	
	public abstract void afficherPersonnages(List<Personnage> personnages) ;
}
