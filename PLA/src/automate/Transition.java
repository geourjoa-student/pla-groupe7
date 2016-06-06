package automate;
import java.util.List;

public class Transition {
	
	private int depart;
	
	private int arrivee;
	
	public Transition(int depart,arrivee){
		this.depart = depart;
		this.arrivee = arrivee;
	}
	
	public int getDepart(){
		return this.depart;
	}
	
	public int getArrivee(){
		return this.arrivee;
	}

}
