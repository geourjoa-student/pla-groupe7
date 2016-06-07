package jeu;

public class Case {

	private Type typeDeLaCase;

	public Case(Type typeDeLaCase) {
		this.setTypeDeLaCase(typeDeLaCase);
	}

	public Type getTypeDeLaCase() {
		return typeDeLaCase;
	}

	public void setTypeDeLaCase(Type typeDeLaCase) {
		this.typeDeLaCase = typeDeLaCase;
	}

	@Override
	public String toString() {

		switch (typeDeLaCase) {
			case HERBE:
				return ".";
			case ARBRE:
				return "|";
			case CHAMPS:
				return "#";

			default:
				return ".";
		}
	}

}
