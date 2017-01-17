package controller;

import model.LabyrinthList;
import model.LabyrinthMatrix;
import view.LabyrinthText;

public class Controller {
	public static void main(String[] args) {
		LabyrinthMatrix l = new LabyrinthMatrix("input.txt");

		LabyrinthText lt = new LabyrinthText(l);
		System.out.println(lt.toString());

		AutomatedSolver is = new AutomatedSolver(l);
		is.solve();

		LabyrinthList lst = new LabyrinthList("list.txt");

		LabyrinthText lstt = new LabyrinthText(lst);
		System.out.println(lstt.toString());
		is.setLabyrinth(lst);

		is.solve();
	}
}
