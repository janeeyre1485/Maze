package controller;

import model.Labyrinth;
import view.LabyrinthText;
import view.LabyrinthView;

public class Controller {
	public static void main(String[] args) {
		LabyrinthFactory factory = new LabyrinthFactory();
		
		Labyrinth matrixLabyrinth = factory.createLabyrinth("matrix.txt");
		Labyrinth listLabyrinth = factory.createLabyrinth("list.txt");

		
		
		LabyrinthView labyrinthText = new LabyrinthText(matrixLabyrinth);
		
		System.out.println(labyrinthText.displayLabyrinth());

		LabyrinthSolver is = new AutomatedSolver();
		System.out.println(labyrinthText.displaySolution(is.solve(matrixLabyrinth)));


		labyrinthText.setLabyrinth(listLabyrinth);
		
		System.out.println(labyrinthText.displayLabyrinth());
		
		System.out.println(labyrinthText.displaySolution(is.solve(listLabyrinth)));
	}
}
