package view;

import java.util.List;

import model.solver.LabyrinthSolver;
import model.util.Position;

public class PrintObserver implements LabyrinthObserver {

	@Override
	public void processSolution(Object o) {
		List<Position> sol = ((LabyrinthSolver)o).getSolution();
		
		LabyrinthView lt = new LabyrinthText();
		System.out.println(lt.displaySolution(sol));
	}

}
