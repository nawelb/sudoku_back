package fr.nawelbp.sudoku.model;

public class Case {

	//int id; 
	int value;
	boolean initialyGiven;
	
	public Case () {
		
	}
	
//	public int getId() {
//		return id;
//	}
//	public void setId(int id) {
//		this.id = id;
//	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public boolean isInitialyGiven() {
		return initialyGiven;
	}
	public void setInitialyGiven(boolean initialyGiven) {
		this.initialyGiven = initialyGiven;
	}

	@Override
	public String toString() {
		return "value=" + value + ", initialyGiven=" + initialyGiven ;
	}
	
	
}
