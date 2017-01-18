package controller;

import model.ListLabyrinth;
import model.MatrixLabyrinth;
import view.LabyrinthText;

public class Controller {
	public static void main(String[] args) {
		MatrixLabyrinth l = new MatrixLabyrinth("input.txt");

		LabyrinthText lt = new LabyrinthText(l);
		System.out.println(lt.toString());

		LabyrinthSolver is = new AutomatedSolver();
		is.solve(l);

		ListLabyrinth lst = new ListLabyrinth("list.txt");

		LabyrinthText lstt = new LabyrinthText(lst);
		System.out.println(lstt.toString());
		
		is.solve(lst);
	}
}
