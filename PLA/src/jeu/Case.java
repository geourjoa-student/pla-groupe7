package jeu;

public class Case {

	private Personnage personnageSurLaCase ; //Null si il n'y a personne
	
	private Type typeDeLaCase;
	
	public Case(Type typeDeLaCase) {
		setPersonnageSurLaCase(null);
		this.setTypeDeLaCase(typeDeLaCase);
	}

	public Personnage getPersonnageSurLaCase() {
		return personnageSurLaCase;
	}

	public void setPersonnageSurLaCase(Personnage personnageSurLaCase) {
		this.personnageSurLaCase = personnageSurLaCase;
	}

	public Type getTypeDeLaCase() {
		return typeDeLaCase;
	}

	public void setTypeDeLaCase(Type typeDeLaCase) {
		this.typeDeLaCase = typeDeLaCase;
	}
	
	@Override
	public String toString() {
		
		String s=" ";
		
		if(personnageSurLaCase!=null){
			if(personnageSurLaCase instanceof Heros)
				s="H";
			else 
				s="P";
		}
		
		switch (typeDeLaCase) {
		case HERBE:
			return s + ". ";
		case ARBRE: 
			return s + "| ";
		case CHAMPS :
			return s + "# ";

		default:
			return s + ". ";
		}
	}
	
}
