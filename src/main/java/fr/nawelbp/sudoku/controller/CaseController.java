package fr.nawelbp.sudoku.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.nawelbp.sudoku.dao.CaseDao;
import fr.nawelbp.sudoku.model.Game;

@RestController
public class CaseController {

	//@Autowired
	private CaseDao caseDao;
	
	
	
}
