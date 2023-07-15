package fr.nawelbp.sudoku.model;

import java.util.List;

public class Grid {

	private List<List<Integer>> value;
	private List<List<Integer>> solution;
	private String difficulty;
	
	
	

	public List<List<Integer>> getValue() {
		return value;
	}
	public void setValue(List<List<Integer>> value) {
		this.value = value;
	}
	public List<List<Integer>> getSolution() {
		return solution;
	}
	public void setSolution(List<List<Integer>> solution) {
		this.solution = solution;
	}
	public String getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}
	@Override
	public String toString() {
		return "Grid [value=" + value + ", solution=" + solution + ", difficulty=" + difficulty + "]";
	}
	
	
}
