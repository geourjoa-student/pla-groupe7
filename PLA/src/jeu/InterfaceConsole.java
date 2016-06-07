package jeu;

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
				
				
				System.out.print(decor[i][j]);
				System.out.print("|");
			}
		
			System.out.println();
			for (int k=0;k<decor[i].length;k++){
				System.out.print("+---");
			}
			System.out.println("+");   
		}
		
	}

	@Override
	public void demanderNouvelleAction(String nomJoueur) {
		System.out.println( nomJoueur + " : saisissez l'action a effectuer : ");
		
	}

	

}
