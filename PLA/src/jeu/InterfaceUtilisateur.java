package jeu;

import java.awt.List;

public abstract class InterfaceUtilisateur {

	public abstract void demanderNouvelleAction() ;

	public abstract void afficherMap(Case[][] decor, java.util.List<Personnage> personnages) ;
	

}
