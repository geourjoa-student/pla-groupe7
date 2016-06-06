package automate;
import java.util.List;

public class Automate {

	private int initial;
		
	private int[] etatsFinaux;
	
	private  int[] etats;
	
	private List<Transition> transitions;
	
	private int [][] actions;
	
	private int courant;

	public Automate(int initial, int[] etatsFinaux, int[] etats, List<Transition> transitions, int[][] actions) {

		this.initial = initial;
		courant=initial;
		this.etatsFinaux = etatsFinaux;
		this.etats = etats;
		this.transitions =  = new ArrayList<Transition>();
		this.transitions = transition;
		this.actions = actions;
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



	
}
