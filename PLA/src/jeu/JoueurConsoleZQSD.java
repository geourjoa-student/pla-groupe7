package jeu;


import java.util.Scanner;


public class JoueurConsoleZQSD extends JoueurConsole {
	
	private static Scanner sc;

	public JoueurConsoleZQSD(String nom) {
		if(sc==null){
			sc = new Scanner(System.in);
		}
		this.nom = nom;
		this.bois=200;
		this.nourriture=200;
		this.nombrePersonnage=0;
	}

	@Override
	// Ne devra pas �tre modulable par l'automate?
	public Action getNouvelleAction() {
		
		char codeAction = '0';
		try{
			codeAction = sc.nextLine().charAt(0);
		} catch (Exception e){
			
		}
		
		
		switch (codeAction) {
			
			
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
				
			case '0':
				return Action.NE_RIEN_FAIRE;
				
			case '1':
				return Action.ATTAQUER;

			case '2':
				return Action.RECOLTER;
				
			case ' ':
				return Action.NE_RIEN_FAIRE;
			default:
				System.out.println("Commande de jeu :");
				System.out.println("z,q,s,d -> haut, gauche, bas, droite");
				System.out.println("0 -> ne rien faire");
				System.out.println("1 -> recolter");
				System.out.println("? ou n'importe quelles autres touches -> afficher ce manuel puis saisir une action correcte.");
				return getNouvelleAction();
			}
	}

}
