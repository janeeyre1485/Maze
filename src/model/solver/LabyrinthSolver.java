package model.solver;
import java.util.List;

import model.labyrinth.Labyrinth;
import model.util.Position;


public interface LabyrinthSolver{
	
	public List<Position> solve(Labyrinth l);
	
	public List<Position> getSolution();
	
}
