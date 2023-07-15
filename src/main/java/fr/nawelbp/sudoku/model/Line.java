package fr.nawelbp.sudoku.model;

import java.util.List;

public class Line {

	//int id;
	private List<Case> cases;

	public List<Case> getCases() {
		return cases;
	}

	public void setCases(List<Case> cases) {
		this.cases = cases;
	}

	@Override
	public String toString() {
		return "Line [cases=" + cases + "]";
	}

	
	
	
	
}
