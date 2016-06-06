package jeu;

public class PLAGame {

	public static void main(String[] args) {

		Partie p = new Partie(new InterfaceConsole(), new JoueurConsoleZQSD("Toto"), new JoueurConsoleZQSD("Titi"));
	
		p.jouerTour();
		
	}

}
