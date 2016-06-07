package jeu;

import java.io.IOException;
import java.util.Scanner;

public class JoueurConsoleZQSD extends JoueurConsole {

	public JoueurConsoleZQSD(String nom) {
		this.nom = nom;
	}

	@Override
	// Ne devra pas �tre modulable par l'automate?
	public Action getNouvelleAction() {
		
		char codeAction;
		try {
			codeAction = (char) System.in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			codeAction=' ';
			e.printStackTrace();
		}

	

		switch (codeAction) {
			case '0':
				return Action.NE_RIEN_FAIRE;
			
			case 'Z':
			case 'z':
				return Action.ALLER_EN_HAUT;
			
			case 'Q':
			case 'q':
				return Action.ALLER_A_GAUCHE;

			case 'S':
			case 's':
				return Action.ALLER_EN_BAS;

			case 'D':
			case 'd':
				return Action.ALLER_A_DROITE;

			default:
				return Action.NE_RIEN_FAIRE;
		}
	}

}
