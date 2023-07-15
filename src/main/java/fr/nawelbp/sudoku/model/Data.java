package fr.nawelbp.sudoku.model;

public class Data {
	
	private Newboard newboard;

	
	public Data() {
	}

	public Newboard getNewboard() {
		return newboard;
	}

	public void setNewboard(Newboard newboard) {
		this.newboard = newboard;
	}

	@Override
	public String toString() {
		return "Data [newboard=" + newboard + "]";
	}
	
	
}
