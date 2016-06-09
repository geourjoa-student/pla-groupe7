package jeu;

public enum Action {


	NE_RIEN_FAIRE (0), 
	ALLER_A_GAUCHE (1),
	ALLER_A_DROITE (2),
	ALLER_EN_HAUT (3),
	ALLER_EN_BAS (4),
	SE_DEPLACER (5),
	ATTAQUER (6),
	RECOLTER (7),
	SOIGNER (9),
	CONVERTIR (10),
	CREER_UNITE (11);
	
	
	private int codeAction;
	
	private Action(int codeAction) {
		this.codeAction=codeAction;
	}
	
	public int getCodeAction() {
		return codeAction;
	}
	
	public static Action codeToAction(int code){
		Action actions[] = Action.values();
		for (int i = 0; i < actions.length; i++) {
			if(actions[i].getCodeAction() == code){
				return actions[i];
			}	
		}
		
		return null;
	}
}
