package fr.nawelbp.sudoku.model;

import java.util.List;

public class Newboard {

	private List <Grid >grids;

	String message; 
	int results;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getResults() {
		return results;
	}

	public void setResults(int results) {
		this.results = results;
	}

	public List<Grid> getGrids() {
		return grids;
	}

	public void setGrids(List<Grid> grids) {
		this.grids = grids;
	}

	@Override
	public String toString() {
		return "Newboard [grids=" + grids + ", message=" + message + ", results=" + results + "]";
	}

	

	
	
}
