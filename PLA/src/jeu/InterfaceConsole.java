package jeu;


import java.util.Iterator;


public class InterfaceConsole extends InterfaceUtilisateur {
	
	
	
	@Override
	public void afficherMap(Case[][] decor, java.util.List<Personnage> personnages) {
		
		for (int k=0;k<decor[0].length;k++){
			System.out.print("+---");
		}
		System.out.println("+"); 
		
		for (int i = 0; i < decor.length; i++) {
			System.out.print("|");
			for (int j = 0; j < decor[i].length; j++) {
				
				char affichagePersonnage = ' ';
				
				for (Iterator<Personnage> iterator = personnages.iterator(); iterator.hasNext();) {
					Personnage personnage = (Personnage) iterator.next();
					
					if(personnage.getPositionH()==i && personnage.getPositionL()==j){
						affichagePersonnage = 'P';
						break;
					} 
					
				}
				
				System.out.print(affichagePersonnage);
				System.out.print(decor[i][j]);
				System.out.print(" |");
			}
		
			System.out.println();
			for (int k=0;k<decor[i].length;k++){
				System.out.print("+---");
			}
			System.out.println("+");   
		}
		
	}

	@Override
	public void demanderNouvelleAction() {
		System.out.println("Saisissez l'action a effectuer : ");
		
	}

	

}
