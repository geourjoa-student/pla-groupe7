package jeu;

public enum Condition {


	//TODO Completer
	
	AUCUNE_CONDITION (0);
	
	
	private int codeCondition;
	
	private Condition (int codeCondition) {
		this.codeCondition=codeCondition;
	}
	
	public int getCodeCondition() {
		return codeCondition;
	}
	
	public static Condition codeToCondition(int code){
		Condition conditions[] = Condition.values();
		for (int i = 0; i < conditions.length; i++) {
			if(conditions[i].getCodeCondition() == code){
				return conditions[i];
			}	
		}
		
		return null;
	}
}
