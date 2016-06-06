package automate;
import java.util.List;

public class Automate {

	private Etat initial;
		
	private List<Etat> etatsFinaux;
	
	private List<Etat> etats;
	
	private int[][] transitions;
	
	private int [][] actions;
	
	private int courant;

	public Automate(Etat initial, List<Etat> etatsFinaux, List<Etat> etats, int[][] transitions, int[][] actions) {
		super();
		this.initial = initial;
		this.etatsFinaux = etatsFinaux;
		this.etats = etats;
		this.transitions = transitions;
		this.actions = actions;
	}
	
	public Etat get_initial(){
		return(this.initial);
	}
	
	public Etat get_courant(){
		return(etats[courant]);
	}


	
}
