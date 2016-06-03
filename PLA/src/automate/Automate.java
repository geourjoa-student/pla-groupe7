package automate;
import java.util.List;

public class Automate {

	private Etat initial;
	
	private List<Etat> etatsFinaux;
	
	private List<Etat> etats;
	
	private int[][] transitions;
	
	private int [][] actions;

	public Automate(Etat initial, List<Etat> etatsFinaux, List<Etat> etats, int[][] transitions, int[][] actions) {
		super();
		this.initial = initial;
		this.etatsFinaux = etatsFinaux;
		this.etats = etats;
		this.transitions = transitions;
		this.actions = actions;
	}
	
	
	
	


}
