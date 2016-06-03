package jeu;

public class InterfaceConsole implements InterfaceUtilisateur {

	@Override
	public void afficherMonde(Moteur m) {
		
		int decor[][] = m.getDecor();
		
		System.out.println("Le monde mesure " + decor.length + " par " + decor[0].length + " cases.\n");
		
		for (int i = 0; i < decor.length; i++) {
			for (int j = 0; j < decor[i].length; j++) {
				System.out.print(decor[i][j]);
			}
			
			System.out.print("\n");
		}
		
	}

}
