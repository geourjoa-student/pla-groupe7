package automate;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

import jeu.*;

public class Automate {

	private int initial;
		
	//private int[] etatsFinaux;
	
	private  int[] etats;
	
	private List<Transition> transitions;
	
	private int courant;

	public Automate(int initial, int[] etats, List<Transition> transitions) {

		this.initial = initial;
		courant=initial;
		//this.etatsFinaux = etatsFinaux;
		this.etats = etats;
		this.transitions = transitions;
	}
	
	public void ajouter_transition(Transition transition) {
		transitions.add(transition);
	}

	public void retirer_transition(Transition transition){
		int i = transitions.indexOf(transition);
		if(i != -1){
			transitions.remove(i);
		}
		// TODO Redecaler tout
	}
	
	public Action utiliserAutomate(int conditions[]){
		
		Transition transitionsAEffectuer  = null;;
		
		for (Iterator<Transition> iterator = transitions.iterator(); iterator.hasNext();) {
			Transition transition = (Transition) iterator.next();
			
			if(transition.getDepart()==courant){
				for (int i = 0; i < conditions.length; i++) {
					if(transition.getCondition()==conditions[i]){
						if(transitionsAEffectuer == null || transition.getPriorite()>transitionsAEffectuer.getPriorite()){
							transitionsAEffectuer=transition;
						}
					}
					
				}
				
			}
			
		}
		
		
		
		if(transitionsAEffectuer==null)
			return Action.NE_RIEN_FAIRE;
		else {
			courant=transitionsAEffectuer.getArrivee();
			switch (transitionsAEffectuer.getAction()) {
				case -1 :
					return Action.ALLER_EN_HAUT;
				case -2 :
					return Action.ALLER_A_DROITE;
				case -3 :
					return Action.ALLER_EN_BAS;
				case -4 :
					return Action.ALLER_A_GAUCHE;
				case -5 : 
					//TODO améliorer : 
					switch(new Random().nextInt(4)){
						case 0 :
							return Action.ALLER_EN_HAUT;
					}
				case 0:
					return Action.NE_RIEN_FAIRE;
				case 1 : 
					return Action.ATTAQUER;
				case 2 : 
					return Action.RECOLTER;
		
				default:
					return Action.NE_RIEN_FAIRE;
			} 
		}
		
		
	}
	
	public Type[][] getDecor(){
		return null;
	}

	


	
}
