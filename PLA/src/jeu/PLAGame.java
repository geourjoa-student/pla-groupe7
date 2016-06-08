package jeu;
public class PLAGame {
	
	public static void main(String[] args) {
		
		/*JDOM j = new JDOM();
		j.xmlMain(); */
		Partie p = new Partie(new InterfaceConsole(), new JoueurConsoleZQSD("Toto"), new JoueurConsoleZQSD("Titi"));
	
		while(!p.estTermine()){
			p.jouerTour();
		}
		
		
		
	} 

}
