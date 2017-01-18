package controller;
import java.util.List;

import model.Labyrinth;
import model.Position;


public interface LabyrinthSolver {
	
	public List<Position> solve(Labyrinth l);
	
	
}
