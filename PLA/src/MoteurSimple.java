import java.util.ArrayList;
import java.util.List;

public class MoteurSimple implements Moteur {
	
	private static final int EAU = 0;

	private List<Humain> humains ;
	
	private List<Pays> pays;
	
	private int decor[][];

	public MoteurSimple(int x, int y) {
		this.humains = new ArrayList<Humain>();
		this.pays = new ArrayList<Pays>();
		
		decor = new int[x][y];
		for (int i = 0; i < decor.length; i++) {
			for (int j = 0; j < decor[i].length; j++) {
				decor[i][j]=EAU;
			}
		}
		
	}
	
	public void creerPartie(){
		pays.add(new Pays("France", 5, 3, 2, 1, 5));
		pays.add(new Pays("Espagne", 2, 3, 2, 1, 2));
		
		humains.add(new Humain(pays.get(0), 5));
		humains.add(new Humain(pays.get(1), 4));
	}

	@Override
	public int[][] getDecor() {
		return decor;
	}
	
	
	
	

}
