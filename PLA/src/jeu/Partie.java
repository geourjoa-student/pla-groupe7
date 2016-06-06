package jeu;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Partie {
	
	private InterfaceUtilisateur interfaceUtilisateur ; // Interface du jeu 
	
	private Joueur joueur1;
	
	private Joueur joueur2;
	
	private List<Personnage> personnages;
	
	/*
	 * 
	 * 0,0------------------largeur,0
	 * ------------------------------
	 * hauteur,0------hauteur,largeur
	 */
	private int decor[][];
	
	private int largeur;
	
	private int hauteur;

	public Partie(InterfaceUtilisateur interfaceUtilisateur, Joueur joueur1, Joueur joueur2, int hauteur, int largeur) {
		this.interfaceUtilisateur = interfaceUtilisateur;
		this.joueur1 = joueur1;
		this.joueur2 = joueur2;
		
		personnages=new LinkedList<Personnage>();
		
		personnages.add(joueur1.getHeros());
		personnages.add(joueur2.getHeros());
		
		decor=new int[largeur][hauteur];
		
		this.hauteur=hauteur;
		
		this.largeur=largeur;
		
		
	}
	
	public void jouerTour(){
		
		interfaceUtilisateur.afficherMap(decor);
		
		for (Iterator<Personnage> iterator = personnages.iterator(); iterator.hasNext();) {
			Personnage personnage = (Personnage) iterator.next();
			
			int nouvelleTransition; //TODO variable qui provoquera la nouvelle transition
			
			if (personnage instanceof Heros) {
				
				nouvelleTransition = personnage.getJoueur().getNouvelleTransition();
				
			} else {
				
				//TODO Choisir la transitiona affecté à un personnage qui n'est pas un héros (qui n'est pas jouable)
			}
			
			
			//TODO
			
			personnage.agir(nouvelleTransition);
			
		}
		
		
		
	}
	
	public void deplacerEnHaut(Personnage p){
		
		if(p.getPositionY()==0){
			p.setPositionY(hauteur);
		} else {
			p.setPositionY(p.getPositionY()-1);
		}
	}
	
	public void deplacerEnBas(Personnage p){
		
		if(p.getPositionY()==hauteur){
			p.setPositionY(0);
		} else {
			p.setPositionY(p.getPositionY()+1);
		}
	}
	
	public void deplacerADroite(Personnage p){
		
		if(p.getPositionX()==largeur){
			p.setPositionX(0);
		} else {
			p.setPositionX(p.getPositionX()+1);
		}
	}
	
	public void deplacerAGauche(Personnage p){
		
		if(p.getPositionX()==0){
			p.setPositionX(largeur);
		} else {
			p.setPositionX(p.getPositionX()+1);
		}
	}

	public boolean estTermine() {
		// TODO Auto-generated method stub
		return false;
	}
	

	

}
