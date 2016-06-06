package automate;
import java.util.List;

public class Automate {

	private int initial;
		
	private int[] etatsFinaux;
	
	private  int[] etats;
	
	private int[][] transitions;
	
	private int [][] actions;
	
	private int courant;

	public Automate(int initial, int[] etatsFinaux, int[] etats, int[][] transitions, int[][] actions) {

		this.initial = initial;
		courant=initial;
		this.etatsFinaux = etatsFinaux;
		this.etats = etats;
		this.transitions = transitions;
		this.actions = actions;
	}
	
	

	



	
}
