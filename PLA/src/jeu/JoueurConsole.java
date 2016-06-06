package jeu;

public class JoueurConsole implements Joueur{
	
	private String nom;
	
	private Heros heros;
	
	private int nourriture;
	
	public JoueurConsole(String nom) {
		this.nom=nom;		
		heros=new Heros(this);
		nourriture=100; //TODO Choix totalement arbitraire, à modifier quand on jouera vraiment et qu'on décidera des regles exactes du jeu
		
	}

	@Override
	public Personnage getHeros() {
		return heros;
	}

	@Override
	public int getNouvelleTransition() {
		// TODO Auto-generated method stub
		return 0;
	}

}
