package fr.nawelbp.sudoku.model;

import java.util.List;

public class Grille {
	
	List<Line> line;

	public List<Line> getLine() {
		return line;
	}

	public void setLine(List<Line> line) {
		this.line = line;
	}

	@Override
	public String toString() {
		return "Grille [line=" + line + "]";
	}

	

	
	

	
}
