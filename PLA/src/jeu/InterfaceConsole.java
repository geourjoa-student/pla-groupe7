package jeu;

import java.util.Iterator;
import java.util.List;

public class InterfaceConsole extends InterfaceUtilisateur {
	
	
	
	@Override
	public void afficherMap(Case[][] decor) {
		
		System.out.println("* Map de jeu : *"); 
		System.out.println();
		for (int k=0;k<decor[0].length;k++){
			System.out.print("| " + k + " ");
		}
		
		System.out.println("|"); 
		
		for (int k=0;k<decor[0].length;k++){
			System.out.print("+---");
		}
		System.out.print("+"); 
		System.out.println(" --");
		
		for (int i = 0; i < decor.length; i++) {
			System.out.print("|");
			for (int j = 0; j < decor[i].length; j++) {
				
				
				System.out.print(decor[i][j]);
				System.out.print("|");
			}
		
			System.out.println(" " + i);
			for (int k=0;k<decor[i].length;k++){
				System.out.print("+---");
			}
			System.out.print("+");   
			System.out.println(" --");
		}
		
		System.out.println(); 
	}

	@Override
	public void demanderNouvelleAction(String nomJoueur) {
		System.out.println( nomJoueur + " : saisissez l'action a effectuer : ");
		
	}

	@Override
	public void afficherPersonnages(List<Personnage> personnages) {
		
		System.out.println("* Liste des personnages : *");
		System.out.println("Proprietaire : Classe : PV : position (h,l)");
		
		for (Iterator<Personnage> iterator = personnages.iterator(); iterator.hasNext();) {
			Personnage personnage = (Personnage) iterator.next();
			System.out.println(personnage);
			
		}
		
		System.out.println();
	}

	@Override
	public void afficherJoueur(Joueur joueur1, Joueur joueur2) {
		System.out.println("* Etats des joueurs : *");
		System.out.println("Nom : Classe : Richesse ");
		
		System.out.println(joueur1);
		System.out.println(joueur2);
		
		System.out.println();
		
	}

	

}
