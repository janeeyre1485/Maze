package view;
import java.util.List;

import model.Labyrinth;
import model.Position;

public interface LabyrinthView {
	
	public String displayLabyrinth();

	public void setLabyrinth(Labyrinth l);

	public Labyrinth getLabyrinth();
	
	public String displaySolution(List<Position> solution);
}
