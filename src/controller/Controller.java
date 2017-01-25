package controller;

import model.labyrinth.Labyrinth;
import model.labyrinth.LabyrinthFactory;
import model.solver.AutomatedSolver;
import view.LabyrinthObserver;
import view.LabyrinthText;
import view.LabyrinthView;
import view.PrintObserver;

public class Controller {
	public static void main(String[] args) {
		LabyrinthFactory factory = new LabyrinthFactory();

		Labyrinth matrixLabyrinth = factory.createLabyrinth("matrix.txt");
		Labyrinth listLabyrinth = factory.createLabyrinth("list.txt");

		LabyrinthObserver obs = new PrintObserver();

		LabyrinthView labyrinthText = new LabyrinthText();

		AutomatedSolver is = new AutomatedSolver();

		System.out.println(labyrinthText.displayLabyrinth(matrixLabyrinth));

		is.addObserver(obs);

		is.solve(matrixLabyrinth);

		System.out.println(labyrinthText.displayLabyrinth(listLabyrinth));

		is.solve(listLabyrinth);
	}
}
