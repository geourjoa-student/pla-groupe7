package jeu;

public class PLAGame {

	public static void main(String[] args) {

		Partie p = new Partie(new InterfaceConsole(), new JoueurConsole("Toto"), new JoueurConsole("Titi"), 10, 10);
	
		while(!p.estTermine()){
			p.jouerTour();
		}
	}

}
