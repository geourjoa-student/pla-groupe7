
public class Partie {
	
	private InterfaceUtilisateur  interfaceGraphique ; // Interface du jeu 
	
	private Moteur moteur ; // Moteur de jeu

	public Partie(InterfaceUtilisateur interfaceGraphique, Moteur moteur) {
		super();
		this.interfaceGraphique = interfaceGraphique;
		this.moteur = moteur;
		
		//TODO initialiserPartie
	}
	
	public void jouerPartie(){
		interfaceGraphique.afficherMonde(moteur);
	}

}
