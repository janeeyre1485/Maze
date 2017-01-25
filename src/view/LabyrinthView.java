package view;
import java.util.List;

import model.labyrinth.Labyrinth;
import model.util.Position;

public interface LabyrinthView {
	
	public String displayLabyrinth(Labyrinth l);

//	public void setLabyrinth();
//
//	public Labyrinth getLabyrinth();
//	
	public String displaySolution(List<Position> solution);
}
