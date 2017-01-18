package controller;

import model.ListLabyrinth;
import model.MatrixLabyrinth;
import view.LabyrinthText;

public class Controller {
	public static void main(String[] args) {
		MatrixLabyrinth matrixLabyrinth = new MatrixLabyrinth("input.txt");

		LabyrinthText labyrinthText = new LabyrinthText(matrixLabyrinth);
		
		System.out.println(labyrinthText.displayLabyrinth());

		LabyrinthSolver is = new AutomatedSolver();
		System.out.println(labyrinthText.displaySolution(is.solve(matrixLabyrinth)));

		ListLabyrinth listLabyrinth = new ListLabyrinth("list.txt");

		labyrinthText.setLabyrinth(listLabyrinth);
		
		System.out.println(labyrinthText.displayLabyrinth());
		
		System.out.println(labyrinthText.displaySolution(is.solve(listLabyrinth)));
	}
}
