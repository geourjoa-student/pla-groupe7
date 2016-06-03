package jeu;

public class Plague {

	public static void main(String[] args) {

		Partie p = new Partie(new InterfaceConsole(), new MoteurSimple(10, 10));
		p.jouerPartie();

	}

}
