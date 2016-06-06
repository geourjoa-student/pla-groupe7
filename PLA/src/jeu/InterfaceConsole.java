package jeu;

public class InterfaceConsole extends InterfaceUtilisateur {

	@Override
	public void afficherMap(int[][] decor) {
		
		for (int i = 0; i < decor.length; i++) {
			for (int j = 0; j < decor[i].length; j++) {
				System.out.print(decor[i][j]);
			}
		}
		
	}

	

}
