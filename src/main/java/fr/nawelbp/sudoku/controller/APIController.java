package fr.nawelbp.sudoku.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import fr.nawelbp.sudoku.model.Case;
import fr.nawelbp.sudoku.model.Data;
import fr.nawelbp.sudoku.model.Grid;
import fr.nawelbp.sudoku.model.Grille;
import fr.nawelbp.sudoku.model.Line;

@CrossOrigin("*")
@RestController
public class APIController {
	
	Data data;
	Grille newGrille;
	Grille valeur = new Grille(); 
	Grille solution = new Grille(); 
	private WebClient client;
	
	public APIController(WebClient.Builder webClientBuilder) {
		this.client = webClientBuilder.baseUrl("https://sudoku-api.vercel.app/api/dosuku").build();
	}
	

	
	//@GetMapping("/game")
	public Data getAllData(){
		data = client.get()
				.accept(MediaType.APPLICATION_JSON)
				.retrieve()
				.bodyToMono(Data.class)
				.log("heyy$*****" )
				.block(); 
		getGrilles(data);
		return data;
	}
	
	@GetMapping("/newgame")
	public @ResponseBody List<Grille> newGame() {
		getAllData();
		List<Grille>listeGrille= new ArrayList<Grille>();
		listeGrille.add(valeur);
		listeGrille.add(solution);
		System.out.println("DATA : "+listeGrille.toString());
		return listeGrille;
	}
	
	public Grille getGrilles(Data data) {
		newGrille = new Grille();
		List<Grid> grid = new ArrayList<Grid>();
		grid = data.getNewboard().getGrids();
		List <List <Integer>> gridValue = grid.get(0).getValue();
		List <List <Integer>> gridSolution = grid.get(0).getSolution();

		System.out.println("VALUE : "+ gridValue);
		valeur = createGrilleValeur(gridValue);
		solution = createGrilleSolution(gridSolution);
		System.out.println("SOLUTION : "+solution);
		System.out.println("VALEUR : "+valeur);
		return newGrille ;
	}

	public Grille createGrilleValeur(List<List<Integer>>grilles) {
		Grille newGrille= new Grille ();
		List<Line> lines = new ArrayList<Line>();
		List<Integer> lineGrid;
		for(int i=0; i<=8; i++) {
			lineGrid= data.getNewboard().getGrids().get(0).getValue().get(i);
			lines.add(createCase(lineGrid));
			newGrille.setLine(lines);
		}
		System.out.println("CREATE GRILLE VALEUR : "+newGrille.toString());

		return newGrille;
	}
	public Grille createGrilleSolution(List<List<Integer>>grilles) {
		Grille newGrille= new Grille ();
		List<Line> lines = new ArrayList<Line>();
		List<Integer> lineGrid;
		for(int i=0; i<=8; i++) {
			lineGrid= data.getNewboard().getGrids().get(0).getSolution().get(i);
			lines.add(createCase(lineGrid));
			newGrille.setLine(lines);
		}
		System.out.println(newGrille.toString());

		return newGrille;
	}

	
	public Line createCase(List<Integer>line) {
		Line newLine = new Line();
		List <Case> listeCases= new ArrayList<>();
	
		for(int i=0; i<=8; i++) {
			Case caseGride = new Case();
			caseGride.setValue(line.get(i));
			if(line.get(i)!=0) {
				caseGride.setInitialyGiven(true);
			}else {
				caseGride.setInitialyGiven(false);
			}
			listeCases.add(caseGride);
		}
		newLine.setCases(listeCases);

		return newLine;
	}
	

}