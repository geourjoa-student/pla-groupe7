package jeu;

public enum Action {


	NE_RIEN_FAIRE (0, Type.CHAMPS), 
	ALLER_A_GAUCHE (1, Type.CHAMPS),
	ALLER_A_DROITE (2, Type.CHAMPS),
	ALLER_EN_HAUT (3, Type.CHAMPS),
	ALLER_EN_BAS (4, Type.CHAMPS),
	SE_DEPLACER (5, Type.CHAMPS),
	ATTAQUER (6, Type.CHAMPS),
	RECOLTER (7, Type.CHAMPS),
	SOIGNER (9, Type.CHAMPS),
	CONVERTIR (10, Type.CHAMPS),
	CREER_UNITE (11, Type.CHAMPS);
	
	
	private int codeAction;
	
	private Type typeCaseAssociee;
	
	private Action(int codeAction, Type type) {
		this.codeAction=codeAction;
		this.typeCaseAssociee=type;
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
	
	public static Action typeToAction (Type type){
		Action actions[] = Action.values();
		for (int i = 0; i < actions.length; i++) {
			if(actions[i].getTypeCaseAssociee()== type){
				return actions[i];
			}	
		}
		
		return null;
	}

	public Type getTypeCaseAssociee() {
		return typeCaseAssociee;
	}

	
}
