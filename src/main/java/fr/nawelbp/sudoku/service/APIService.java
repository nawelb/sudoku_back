package fr.nawelbp.sudoku.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.nawelbp.sudoku.model.Case;
import fr.nawelbp.sudoku.model.Grille;
import fr.nawelbp.sudoku.model.Line;

@CrossOrigin("*")
@RestController
public class APIService {

	@GetMapping("/solution")
	public Grille solveGame(@RequestBody List<Grille>listeGrille) {
		return listeGrille.get(1);
	}
	
	@PostMapping("/verification")
	public @ResponseBody Grille verifyGame(@RequestBody List<Grille>listeGrille) {
		Grille game = listeGrille.get(0);
		Grille solution = listeGrille.get(1);
		Line lineToEvaluate = new Line();
		Line lineSolution = new Line();
		Case caseToEvaluate = new Case();
		Case caseSolution = new Case();
		Grille verifiedGame = new Grille();
		Line verifiedLine ;
		List<Case>verifiedCase ;
		List<Line>verifiedListLine = new ArrayList<Line>();
		for(int i=0; i<9; i++) {
			lineToEvaluate= game.getLine().get(i);
			lineSolution = solution.getLine().get(i);
			verifiedCase = new ArrayList<Case>();
			verifiedLine = new Line();
			for(int j=0; j<9; j++) {
				caseToEvaluate = lineToEvaluate.getCases().get(j);
				caseSolution = lineSolution.getCases().get(j);
				if(caseToEvaluate.isInitialyGiven()== true) {
					verifiedCase.add(caseToEvaluate);
				}else if (caseToEvaluate.getValue()==caseSolution.getValue()) {
					//caseToEvaluate.getValue();
					caseToEvaluate.setInitialyGiven(true);
					verifiedCase.add(caseToEvaluate);
				}else {
					caseToEvaluate.setValue(0);
					verifiedCase.add(caseToEvaluate);
				}	
			}
			verifiedLine.setCases(verifiedCase);
			verifiedListLine.add(verifiedLine);
		}
		verifiedGame.setLine(verifiedListLine);
		System.out.println("VERIFIED GAME : "+ verifiedGame.toString());
		return verifiedGame;
	}
	
	@GetMapping("/message")
	public String evaluateGame(@RequestBody Grille verifiedGrille) {
		int index=0 ;  
		Line line = new Line();
		for(int i=0; i<=8; i++) {
			line = verifiedGrille.getLine().get(i);			
			for(int j=0; j<=8; j++) {
				Case caseToVerify = new Case();
				caseToVerify = line.getCases().get(j);
				if(caseToVerify.getValue()==0) {
					index++;	
				}
			}
		}
		String message=getMessage(index);
		
		return message;
	}
	
	
	private String getMessage(int index) {
		String message="";
		switch(index) {
			case 0:
				message= "Bravo! Vous avez réussi!";
				break;
			case 1:
				message= "Courage plus que 1 chiffre à trouver";
				break;
			default: 
				message= "Courage plus que "+ index +" chiffres à trouver";
				break;
		}
	
		
		return message;
	}

}
