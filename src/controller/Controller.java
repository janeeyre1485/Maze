package controller;
import model.LabyrinthMatrix;
import view.LabyrinthText;

public class Controller {
	public static void main(String[] args) {
		LabyrinthMatrix l = new LabyrinthMatrix();
		l.setupLabyrinth(-1, 2, 0, 1);
		
		l.loadFromFile("input.txt");
		
		LabyrinthText lt = new LabyrinthText();
		lt.setLabyrinth(l);
		System.out.println(lt.toString());
		
		AutomatedSolver is = new AutomatedSolver();
		is.setLabyrinth(l);
		is.solve();
		
//		LabyrinthList lst = new LabyrinthList();
//		lst.setupLabyrinth(-1, 2);
//		
//		lst.loadFromFile("list.txt");
//		
//		LabyrinthText lstt = new LabyrinthText();
//		lstt.setLabyrinth(lst);
//		System.out.println(lstt.toString());
	}
}
